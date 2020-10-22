package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.dao.UserDao;
import cn.edu.svtcc.pojo.User;
import cn.edu.svtcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Daved
 * @title UserServiceImpl
 * @description
 * @date 2020/06/10/21:15
 */
@Service("UserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

  private UserDao dao;

  @Autowired
  public void setDao(UserDao dao) {
    this.dao = dao;
  }

  public User login(User user) {
    return dao.login(user);
  }

  public User queryById(long id) {
    return dao.queryById(id);
  }

  public List<User> queryAll() {
    List<User> users = dao.queryAll();
    return users;
  }

  public List<User> queryByName(String userName) {
    return dao.queryByName(userName);
  }

  public int addUser(User user) {
    return dao.addUser(user);
  }
  public List<User> getList() {
    return dao.queryAll();
  }
  public int updateUser(User user) {
    return dao.updateUser(user);
  }

  public int deleteById(long id) {
    return dao.deleteById(id);
  }
}

