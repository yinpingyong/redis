package cn.com.bestpay.redisdemo.setters.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * Created by Howell on 30/12/16.
 */
@Slf4j
public class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.error("Exception message - " + throwable.getMessage());
        log.error("Method name - " + method.getName());
        for (Object param : obj) {
            log.error("Parameter value - " + param);
        }
    }
}
