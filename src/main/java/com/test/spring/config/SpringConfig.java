package com.test.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.test.aop.MyAdvices;
import com.test.process.UserProcess;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig
{
  @Bean
  public UserProcess userProcessBean()
  {
    return new UserProcess();
  }

  @Bean
  public MyAdvices beforeAdvice()
  {
    return new MyAdvices();
  }
}
