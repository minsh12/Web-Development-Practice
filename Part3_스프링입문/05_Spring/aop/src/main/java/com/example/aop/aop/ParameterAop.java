package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect     // aop
@Component  // spring에서 관리하도록
public class ParameterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")   // aop 프로젝트에 controller 패키지에 있는 모든 메소드를 aop로 설정
    private void cut() {}

    @Before("cut()")        // cut()이 실행되는 시점(Pointcut이 실행되는 지점) 전(before)에 실행
    public void before(JoinPoint joinPoint) {

        // 메소드 이름 출력
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();
        for(Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")   // cut()이 정살실행후 리턴하면 해당 object값을 returnObj에서 확인 가능
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
