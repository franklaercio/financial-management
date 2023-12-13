package com.ufrn.financial.controllers;

import com.ufrn.financial.models.User;
import com.ufrn.financial.models.dtos.AuthDTO;
import com.ufrn.financial.models.dtos.LoginDTO;
import com.ufrn.financial.models.dtos.RegisterDTO;
import com.ufrn.financial.models.enums.UserRoleEnum;
import com.ufrn.financial.repositories.UserRepository;
import com.ufrn.financial.infra.security.JwtTokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtTokenService jwtTokenService;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.jwtTokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByUsername(data.username()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.username(), encryptedPassword, UserRoleEnum.valueOf(data.role()));

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}
