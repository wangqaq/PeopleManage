package cn.edu.svtcc.service;

import cn.edu.svtcc.pojo.User;

import java.util.List;

/**
 * @author Daved
 * @title UserService
 * @description
 * @date 2020/06/10/21:14
 */

public interface UserService {

  User login(User user);

  User queryById(long id);

  List<User> getList();

  List<User> queryByName(String userName);

  int addUser(User user);

  int updateUser(User user);

  int deleteById(long id);
}
