/**
 * 
 */
package com.test.process;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.test.entities.UserInfo;
import com.test.helper.HibernateUtils;
import com.test.helper.UserDTO;

/**
 * @author kuldeep.singh
 */
public class UserProcess
{

  private Session session;

  public List<UserInfo> getAllUserInfos()
  {
    session = HibernateUtils.getSession();
    Criteria criteria = session.createCriteria(UserInfo.class);
    @SuppressWarnings("unchecked")
    List<UserInfo> userInfos = criteria.list();
    session.close();
    return userInfos;
  }

  public UserInfo getUserInfoById(long id)
  {
    session = HibernateUtils.getSession();
    UserInfo userInfo = (UserInfo) session.get(UserInfo.class, id);
    return userInfo;
  }

  public void saveUserInfo(UserInfo userInfo)
  {
    session = HibernateUtils.getSession();
    Transaction transaction = session.beginTransaction();
    session.merge(userInfo);
    transaction.commit();
    session.flush();
    session.close();
  }

  @SuppressWarnings("unchecked")
  public UserDTO createDTOFromUserInfo()
  {
    session = HibernateUtils.getSession();
    Criteria criteria = session.createCriteria(UserInfo.class);
    ProjectionList proList = Projections.projectionList();
    proList.add(Projections.property("firstName"), "firstName");
    proList.add(Projections.property("lastName"), "lastName");
    criteria.setProjection(proList);
    List<UserDTO> list = criteria.setResultTransformer(Transformers.aliasToBean(UserDTO.class))
      .list();

    return list.get(0);
  }
}
