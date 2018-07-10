package com.zhenghao.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// 定义异常与DuplicateSpittleException类似
// 在AppWideExceptionHandler中用@ExceptionHandler异常处理器来处理异常
public class SpittleNotFoundException2 extends RuntimeException {

    private long spittleId;
}