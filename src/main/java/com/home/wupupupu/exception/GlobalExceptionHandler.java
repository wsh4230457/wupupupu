package com.home.wupupupu.exception;

import com.home.wupupupu.pojo.Result;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(Exception.class)
    public Result handlerException(Exception e){
    e.printStackTrace();
    return Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"数据错误");
}
}
