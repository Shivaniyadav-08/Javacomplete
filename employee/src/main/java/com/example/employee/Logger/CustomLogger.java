package com.example.employee.Logger;


import org.slf4j.Logger;

public class CustomLogger {
    private final Logger logger;
    private  final String className;

    public CustomLogger(Logger logger, Class<?> clas) {
        this.logger = logger;
        this.className = clas.getSimpleName();
    }

    public void info(String message){
        logger.info("[{}] {}" , className,message);
        System.out.println("[{"+className+"}]"+" { "+message+"}");
    }


    public void debug(String message) {
        logger.debug("[{}] {}", className, message);
    }
    
    public void warn(String message){
        logger.warn("[{}] {}", className,message);
    }

    public void error(String message){
        logger.error("[{}] {}",className,message);
    }

    public void trace(String message){
        logger.trace("[{}] {}",className,message);
    }

}
