package com.kushaal.ShortURL.util;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Base62Encoder {

    private static final String CHARS="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH=6;
    private final Random random = new Random();

    public String generate(){
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i=0; i<CODE_LENGTH;i++){
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    
}
