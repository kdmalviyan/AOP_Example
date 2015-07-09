/**
 * 
 */
package com.test.helper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.test.entities.UserInfo;

/**
 * @author kuldeep.singh
 */
@SuppressWarnings("deprecation")
public class HibernateUtils
{
  private static SessionFactory sessionFactory;
  static
  {
    try
    {
      sessionFactory = new AnnotationConfiguration().configure().
        addAnnotatedClass(UserInfo.class).buildSessionFactory();
    }
    catch (Throwable ex)
    {
      // Log exception!
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static Session getSession() throws HibernateException
  {
    return sessionFactory.openSession();
  }
}
