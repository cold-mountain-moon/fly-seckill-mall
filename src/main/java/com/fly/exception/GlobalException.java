package com.fly.exception;

import com.fly.response.CodeMsg;

public class GlobalException extends RuntimeException {


    private CodeMsg codeMsg;

    private GlobalException() {}

    public GlobalException(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

}
