package com.zhenghao.controlleradvice;

import com.zhenghao.exception.Error;
import com.zhenghao.exception.SpittleNotFoundException;
import com.zhenghao.exception.SpittleNotFoundException2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.zhenghao.exception.DuplicateSpittleException;

@ControllerAdvice
public class AppWideExceptionHandler {

    // 异常处理器
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle(DuplicateSpittleException e) {
        // 返回逻辑视图名
        return "error/duplicate";
    }


    @ExceptionHandler(SpittleNotFoundException2.class)
    public ResponseEntity<Error> spittleNotFound(SpittleNotFoundException2 exception) {
        long id = exception.getSpittleId();
        Error error = new Error(4, "Spittle [" + id + "] not found" );
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

}
