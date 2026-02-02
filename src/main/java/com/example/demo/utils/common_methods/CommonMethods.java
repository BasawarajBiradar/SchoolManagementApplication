package com.example.demo.utils.common_methods;

import org.springframework.stereotype.Component;

@Component
public class CommonMethods {

    private CommonMethods() {}

    public static String safeToString(Object res) {
        return res != null ? res.toString() : null;
    }

}
