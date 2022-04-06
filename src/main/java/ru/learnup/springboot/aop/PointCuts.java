package ru.learnup.springboot.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* ru.learnup.springboot.service.EventService.add*(..))")
    public void allAdd(){};

    @Pointcut("execution(* ru.learnup.springboot.service.EventService.buyTicket(..))")
    public void buyTicketPointCut(){};

}
