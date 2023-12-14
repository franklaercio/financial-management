package com.ufrn.financial.utils;

import java.lang.reflect.Field;

public class UpdateUtils {

    public static void update(Object productFounded, Object product, Field[] fields) {
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object newValue = field.get(product);
                Object existingValue = field.get(productFounded);

                if (newValue != null && !newValue.equals(existingValue)) {
                    field.set(productFounded, newValue);
                }
            }
        } catch (IllegalAccessException ex) {
            //throw new InternalServerError("Cannot access this field");
        }

    }
}
