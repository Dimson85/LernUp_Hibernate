package ru.learnup.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Notifier {

    @Before("execution(* ru.learnup.springboot.service.EventService.buyTicket(..))")
    public void beforeBuyTicketAspect (){
        System.err.println("beforeBuyTicketAspect: Статус Вашего заказа отправлен на почту.");
    }
}
