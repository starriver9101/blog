package com.starriver.blog.api;

/**
 * 封装API的错误码
 * @author chen
 * @date 2020/12/18
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
