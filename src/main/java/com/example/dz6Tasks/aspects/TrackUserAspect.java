package com.example.dz6Tasks.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
@Aspect
public class TrackUserAspect {
    private final Logger logger = Logger.getLogger(TrackUserAspect.class.getName());

    public TrackUserAspect() {
        try {
            FileHandler fileHandler = new FileHandler("myApp.txt", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }
    }

    @AfterReturning(pointcut = "@annotation(com.example.dz6Tasks.annotations.TrackUserAction)", returning = "info")
    public void logExecutionTime(JoinPoint joinPoint, Object info) {

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] methodArgs = joinPoint.getArgs();

        logger.info("Вызванный метод: " + methodName + " Класс: " + className + "Аргументы: "
                + Arrays.toString(methodArgs) + " Метод отработал и вернул значение: " + info);
    }
}
