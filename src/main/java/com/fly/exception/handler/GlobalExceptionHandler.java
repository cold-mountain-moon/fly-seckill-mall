package com.fly.exception.handler;


import com.fly.exception.GlobalException;
import com.fly.response.CodeMsg;
import com.fly.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = Exception.class)
    public Response<CodeMsg> handlerException(Exception ex) {
        if(ex instanceof GlobalException) {
            return Response.fail(((GlobalException) ex).getCodeMsg());
        }
        return Response.fail(CodeMsg.SERVER_ERROR);
    }

}
