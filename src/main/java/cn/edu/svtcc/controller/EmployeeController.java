package cn.edu.svtcc.controller;
import cn.edu.svtcc.pojo.employee;
import cn.edu.svtcc.service.employeeService;
import com.alibaba.fastjson.JSON;
import jdk.internal.instrumentation.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Daved
 * @title UserController
 * @description
 * @date 2020/06/10/21:21
 */
@Controller
@Slf4j
@Transactional(rollbackFor = Exception.class)
@RequestMapping("employee")
public class EmployeeController {
  @Autowired
  private employeeService service;

  /*
  显示所有用户
   */
  @RequestMapping(value="/list",method=RequestMethod.GET)
  public String list(Model model,HttpServletRequest request) {
      List<employee> list = service.getList();
      model.addAttribute("list", list);
      return "userList";
  }

  /**
   * 显示添加用户页面
   */
  @RequestMapping("showAddUser")
  public String showAddUser(HttpServletRequest request) {
      return "addUser";

  }

  /**
   * 显示编辑用户页面
   */
  @RequestMapping("showEditUser")
  public String showEditUser(@NonNull Model model, @NonNull Integer userId) {
    employee employee = service.queryById(userId);
    model.addAttribute("user", employee);
    return "editUser";
  }

  /**
   * 添加用户-ajax
   */
  @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String addUser(Model model, @RequestBody String json) {
    employee employee = JSON.parseObject(json, employee.class);
    int i = service.addUser(employee);
    if (i > 0) {
      return "success";
    } else {
      return "添加用户失败";
    }
  }


  /**
   * 编辑用户-ajax
   */
  @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
  @ResponseBody
  public String editUser(Model model, @RequestBody employee employee) {
    if (service.updateUser(employee) == 1) {
      return "success";
    } else {
      return "修改用户信息失败";
    }
  }

  /**
   * 删除用户-ajax
   */
  @RequestMapping(value="/deleteUser",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
  @ResponseBody
  public String deleteUser(Model model,@RequestBody employee employee) {
    if(service.deleteById(employee.getUserId())==1){
      return "success";
    }else{
      return "删除用户["+ employee.getUserName()+"]失败";
    }
  }
  /**
   * 搜索用户
   */
  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public String findUser(Model model, String userName,HttpServletRequest request) {
    List<employee> list = service.queryByName(userName);
    model.addAttribute("list", list);
    model.addAttribute("findKey", userName);
    return "userList";
  }

  // @ResponseBody 之后就不能页面跳转 ，但是可以通过js 跳转
  /*
  登录
   */
  @ResponseBody
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(Model model, @RequestBody String json, HttpServletRequest request) {
    Logger log = null;
    employee employee = JSON.parseObject(json, employee.class);
    employee login = service.login(employee);
    String username = employee.getUserName();
    request.getSession().setAttribute("user", username);
    if (login != null) {
      return "success";
    } else {
      return "false";
    }

  }

  /*
  登出
   */
  @ResponseBody
  @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
  public String loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getSession().setAttribute("user", null);
    request.setAttribute("msg","退出成功");
    request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
    return "true";
  }
  /*
  管理员注册


  待写
   */
  @ResponseBody
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public  String register(Model model,@RequestBody String json){

    return "success";
  }

  @RequestMapping("showRegister")
  public String showRegister(){
    return "register";
  }
  @RequestMapping("index")
  public String index() {
    return "index";
  }
}
