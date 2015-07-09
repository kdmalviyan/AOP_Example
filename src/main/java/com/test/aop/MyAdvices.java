package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAdvices
{
  private long startTime;
  private long endTime;

  @Before("execution(* *.*.*.*.createDTOFromUserInfo(..))")
  public void before1(JoinPoint joinPoint)
  {
    startTime = System.nanoTime();
    System.out.println("Before");
  }

  @After("execution(* *.*.*.*.createDTOFromUserInfo(..))")
  public void after1(JoinPoint joinPoint)
  {
    endTime = System.nanoTime();
    System.out.println("After");
    System.out.println("Execution time taken:" + (endTime - startTime) + " nano seconds");
  }
}
