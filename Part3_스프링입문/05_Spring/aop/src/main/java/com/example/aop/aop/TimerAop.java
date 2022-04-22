package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/* AOP 활용용도 두번째.
* 메소드의 실행시간을 가지고, 서버의 부하나 상태 등을 로그로 남길 수 있다 */
@Aspect
@Component  // 스프링에서 관리
public class TimerAop {     // 특정 메소드의 실행시간을 찍음

    // 첫번째 pointcut은 controller패키지 하위의 메소드들에 걸음
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){

    }

    // 두번째 pointcut은 annotation패키지의 Timer어노테이션에 설정된 메소드에 걸음
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){

    }

    // 시간을 재야해서 전후가 필요.
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        // (실행전) 시간재기 시작
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // (기준점) 메소드 실행후 반환값은 result에 저장
        Object result = joinPoint.proceed();

        // (실행후) 시간재기 중단
        stopWatch.stop();

        // 시간 기록 출력
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());  // 초단위 출력
    }
}
