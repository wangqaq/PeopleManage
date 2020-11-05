package cn.edu.svtcc.service;

import cn.edu.svtcc.pojo.employee;

import java.util.List;

/**
 * @author Daved
 * @title UserService
 * @description
 * @date 2020/06/10/21:14
 */

public interface employeeService {

  employee login(employee employee);

  employee queryById(long id);

  List<employee> getList();

  List<employee> queryByName(String userName);

  int addUser(employee employee);

  int updateUser(employee employee);

  int deleteById(long id);
}
