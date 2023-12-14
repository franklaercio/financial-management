package com.ufrn.financial.utils;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class AuthUtil {

    public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private static String decodePayload(String jwt) {
        String[] parts = jwt.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Token JWT inválido.");
        }

        return new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);
    }

    public static UUID getUuidFromRequest(HttpServletRequest request) {
        String jwtToken = getJwtFromRequest(request);

        if(StringUtils.isBlank(jwtToken)) {
            throw new IllegalArgumentException("Token JWT inválido.");
        }

        String payload = decodePayload(jwtToken);
        JSONObject payloadJson = new JSONObject(payload);
        String userId = payloadJson.getString("sub");

        return UUID.fromString(userId);
    }
}
