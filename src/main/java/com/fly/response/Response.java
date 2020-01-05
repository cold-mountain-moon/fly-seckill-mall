package com.fly.response;

public class Response<T> {

    private int code;
    private String msg;
    private T data;





    private Response(CodeMsg codeMsg) {
        if(codeMsg == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    private Response(CodeMsg codeMsg, T data) {
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(CodeMsg.SUCCESS, data);
    }

    public static <T> Response<T> success() {
        return new Response<>(CodeMsg.SUCCESS, null);
    }

    public static Response fail(CodeMsg codeMsg) {
        return new Response(codeMsg);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
