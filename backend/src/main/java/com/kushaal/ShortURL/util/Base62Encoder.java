package com.kushaal.ShortURL.util;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {

    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = CHARS.length();

    public String encode(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("id must be non-negative: " + id);
        }
        if (id == 0) {
            return String.valueOf(CHARS.charAt(0));
        }

        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            int remainder = (int) (id % BASE);
            sb.append(CHARS.charAt(remainder));
            id /= BASE;
        }
        return sb.reverse().toString();
    }
}
