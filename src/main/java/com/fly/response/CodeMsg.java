package com.fly.response;

public class CodeMsg {

    private int code;

    private String msg;


    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 格式化codeMsg的msg信息
     * @param cm
     * @param format
     * @return
     */
    public static CodeMsg format(CodeMsg cm, String format) {
        String format1 = String.format(cm.getMsg(), format);
        cm.setMsg(format1);
        return cm;
    }


    public static CodeMsg SUCCESS = new CodeMsg(0, "");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500000, "服务器异常");
    public static CodeMsg ERROR_LOGIN_NAME_OR_PASSWORD = new CodeMsg(500100, "用户名或密码错误");
    public static CodeMsg PARAMS_ERROR = new CodeMsg(400100, "参数错误：%s");

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }
}
