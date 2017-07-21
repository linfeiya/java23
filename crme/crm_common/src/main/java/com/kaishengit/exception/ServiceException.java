package com.kaishengit.exception;

/**
 * Created by linfeiya on 2017/7/19 0019.
 */
public class ServiceException extends RuntimeException{
    public ServiceException(){}

    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Throwable throwable){
        super(throwable);
    }
    public ServiceException(String message,Throwable throwable){
        super(message,throwable);
    }

}
