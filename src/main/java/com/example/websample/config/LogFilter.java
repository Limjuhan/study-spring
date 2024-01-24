package com.example.websample.config;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

//필터 추가 실습
@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("Hello Logfilter: " + Thread.currentThread());
        // 외부 -> filter -> controller(처리) -> filter -> 외부
        chain.doFilter(request, response);//chain이 controller처리부분 작업을 위해서는 연결해줘야된다.
        log.info("Bye Logfilter: " + Thread.currentThread());

    }
}
