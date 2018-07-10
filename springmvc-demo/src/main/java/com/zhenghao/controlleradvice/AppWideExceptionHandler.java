package com.zhenghao.controlleradvice;

import com.zhenghao.exception.Error;
import com.zhenghao.exception.SpittleNotFoundException;
import com.zhenghao.exception.SpittleNotFoundException2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.zhenghao.exception.DuplicateSpittleException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppWideExceptionHandler {

    // 异常处理器
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle(DuplicateSpittleException e) {
        // 返回逻辑视图名
        return "error/duplicate";
    }


    @ExceptionHandler(SpittleNotFoundException2.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 指定返回的状态码
    // 如果控制器上有@RestController，可以省略@ResponseBody
    public @ResponseBody Error spittleNotFound(SpittleNotFoundException2 exception) {
        long id = exception.getSpittleId();
        Error error = new Error(4, "Spittle [" + id + "] not found" );
        // 因为返回状态始终是404，所以可以用@ResponseBody Error代替
        // 使用ResponseEntity的一个原因是可以设置状态码，但可以通过@ResponseStatus(HttpStatus.NOT_FOUND)注解来设置状态吗
//        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
        return error;// 放在响应体中
    }

}
