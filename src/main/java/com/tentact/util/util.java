package com.tentact.util;

import java.util.Random;
import java.util.UUID;

public class util {
    public static String uuid(){
        String s = UUID.randomUUID().toString();
        return s;
    }

    public static String code(){
        String str = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIZKLMNOPQRSTUVWXYZ";
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code += str.charAt(random.nextInt(62));
        }
        return code;
    }
}
