package com.fly.util;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static final String PUBLIC_SALT = "1ac2bd5d9ACEGZ";


    public static String md5(String plainStr) {
        return DigestUtils.md5Hex(plainStr);
    }

    public static String encryptFromInput(String input) {
        String s = new StringBuffer().append(PUBLIC_SALT.charAt(1))
                .append(PUBLIC_SALT.charAt(3)).append(input).append(PUBLIC_SALT.charAt(6)).append(PUBLIC_SALT.charAt(8)).toString();
        System.out.println(s);
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
        System.out.println(encryptFormInputToDB(encryptFromInput("123456"), PUBLIC_SALT)); // 26b07769ab3a62086a6263a53e667a51
    }

}
