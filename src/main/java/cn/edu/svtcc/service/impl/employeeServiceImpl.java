package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.dao.EmployeeDao;
import cn.edu.svtcc.pojo.employee;
import cn.edu.svtcc.service.employeeService;
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
@Service("employeeService")
@Transactional(rollbackFor = Exception.class)
public class employeeServiceImpl implements employeeService {

  private EmployeeDao dao;

  @Autowired
  public void setDao(EmployeeDao dao) {
    this.dao = dao;
  }

  public employee login(employee employee) {
    return dao.login(employee);
  }

  public employee queryById(long id) {
    return dao.queryById(id);
  }

  public List<employee> queryAll() {
    List<employee> employees = dao.queryAll();
    return employees;
  }

  public List<employee> queryByName(String userName) {
    return dao.queryByName(userName);
  }

  public int addUser(employee employee) {
    return dao.addUser(employee);
  }
  public List<employee> getList() {
    return dao.queryAll();
  }
  public int updateUser(employee employee) {
    return dao.updateUser(employee);
  }

  public int deleteById(long id) {
    return dao.deleteById(id);
  }
}

