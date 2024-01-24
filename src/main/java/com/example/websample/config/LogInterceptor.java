package com.example.websample.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j //롬복의 log기능 사용위해 정의
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle LogInterceptor : " + Thread.currentThread());
        log.info("preHandle handler : " + handler);//client로부터요청을 dispatcherServlet이 처리하고 interceptor에서 handler통해 데이터 확인.

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle LogInterceptor : " + Thread.currentThread());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion LogInterceptor : " + Thread.currentThread());

        if (ex != null) {
            log.error("afterCompletion exception : " + ex.getMessage());
        }
    }
}
