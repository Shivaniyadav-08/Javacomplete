package com.example.employee.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CustomLoggerFactory {

    public static CustomLogger getLogger(Class<?> clas){
        Logger slf4jLogger  = LoggerFactory.getLogger(clas);
        return  new CustomLogger(slf4jLogger,clas);
    }

}
