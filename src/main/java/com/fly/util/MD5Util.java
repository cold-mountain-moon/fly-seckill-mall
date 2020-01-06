package com.fly.util;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static final String PUBLIC_SALT = "13589ACEGZ";


    public static String md5(String plainStr) {
        return DigestUtils.md5Hex(plainStr);
    }

    public static String encryptFromInput(String input) {
        String s = PUBLIC_SALT.charAt(1) + PUBLIC_SALT.charAt(3) + input + PUBLIC_SALT.charAt(6) + PUBLIC_SALT.charAt(8);
        return md5(s);
    }

    public static String encryptFormInputToDB(String form, String salt) {
        String s = form + salt;
        return md5(s);
    }

    public static String encryptPlainFormToDb(String plainInput, String salt) {
        String s = encryptFromInput(plainInput);
        return encryptFormInputToDB(s, salt);
    }

    public static void main(String[] args) {
        System.out.println(encryptFromInput("123456")); // 3287a12fb1152838232ce7722f1f2587
        System.out.println(encryptPlainFormToDb("123456", PUBLIC_SALT)); // 26b07769ab3a62086a6263a53e667a51
    }

}
