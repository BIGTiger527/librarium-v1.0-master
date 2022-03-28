package com.sanxia.util;

import java.util.Random;

/**
 * 字符处理工具类
 * Created by IntelliJ IDEA.
 * User: 冯寒斌
 * Date: 2021/12/8
 */
public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
