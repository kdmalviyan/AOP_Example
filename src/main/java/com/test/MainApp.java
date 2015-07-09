/**
 * 
 */
package com.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.entities.UserInfo;
import com.test.helper.UserDTO;
import com.test.process.UserProcess;
import com.test.spring.config.SpringConfig;

/**
 * @author kuldeep.singh
 */
public class MainApp
{
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    @SuppressWarnings("resource")
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
      SpringConfig.class);
    ctx.scan("com.test");
    UserProcess userProcess = ctx.getBean(UserProcess.class);
    userProcess.getAllUserInfos();
    userProcess.getUserInfoById(1l);
    UserDTO userDTO = userProcess.createDTOFromUserInfo();
    System.out.println(userDTO.getFirstName() + " " + userDTO.getLastName());
  }

  /**
   * Call this API from main function at least one time so that it could insert
   * records in database
   * 
   * @return
   */
  private static UserInfo createUserInfo()
  {
    UserInfo userInfo = new UserInfo();
    userInfo.setFirstName("Kuldeep");
    userInfo.setLastName("Singh");
    userInfo.setAddress("Greater Noida");
    userInfo.setCompanyLocation("Noida");
    Calendar calendar = GregorianCalendar.getInstance();
    calendar.set(Calendar.YEAR, 1987);
    calendar.set(Calendar.MONTH, 1);
    calendar.set(Calendar.DATE, 20);
    userInfo.setDob(calendar.getTime());
    userInfo.setCompanyName("Impetus");
    return userInfo;
  }
}
