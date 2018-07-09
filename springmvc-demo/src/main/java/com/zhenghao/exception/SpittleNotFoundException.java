package com.zhenghao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
reason = "Spittle Not FOund")
public class SpittleNotFoundException extends RuntimeException {
}
