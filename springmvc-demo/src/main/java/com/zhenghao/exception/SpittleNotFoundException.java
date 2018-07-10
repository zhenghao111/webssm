package com.zhenghao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle Not FOund")
// 直接抛出异常，返回相关错误状态
public class SpittleNotFoundException extends RuntimeException {
}
