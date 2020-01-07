package com.fly.exception.handler;


import com.fly.exception.GlobalException;
import com.fly.response.CodeMsg;
import com.fly.response.Response;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response<CodeMsg>> handlerException(Exception ex) {
        ex.printStackTrace();
        ResponseEntity<Response<CodeMsg>> entity = null;
        Response<CodeMsg> response = null;

        if(ex instanceof GlobalException) {
            response = Response.fail(((GlobalException) ex).getCodeMsg());
        } else if(ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = e.getBindingResult();
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            String defaultMessage = objectError.getDefaultMessage();
            response = Response.fail(CodeMsg.format(CodeMsg.PARAMS_ERROR, defaultMessage));
        } else {
            response = Response.fail(CodeMsg.SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
