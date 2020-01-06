package com.fly.response;

public class CodeMsg {

    private int code;

    private String msg;


    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static CodeMsg SUCCESS = new CodeMsg(0, "");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500000, "服务器异常");
    public static CodeMsg ERROR_LOGIN_NAME_OR_PASSWORD = new CodeMsg(500100, "用户名或密码错误");

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
