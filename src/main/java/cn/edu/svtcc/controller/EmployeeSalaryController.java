package cn.edu.svtcc.controller;


import cn.edu.svtcc.pojo.employeeSalary;
import cn.edu.svtcc.service.employeeSalaryService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
@Transactional(rollbackFor = Exception.class)
@RequestMapping("employeeSalary")
public class EmployeeSalaryController {
    @Autowired
    private employeeSalaryService service;


    @RequestMapping(value = "show",method = RequestMethod.POST)
    public String showEmployeeSalary(Model model, HttpServletRequest request, @RequestBody Long epyid){
        employeeSalary employeeSalary = service.findEmployeeSalary(epyid);
        model.addAttribute("employeeSalary",employeeSalary);
        return "employeeSalary";
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
        public String insertEmployeeSalary(HttpServletRequest request,@RequestBody String json) {
        employeeSalary employeeSalary = JSON.parseObject(json, employeeSalary.class);
        int i = service.insertEmployeeSalary(employeeSalary);
        if (i > 0) {
            return "Success";
        } else {
            return "False";
        }
    }

        @RequestMapping(value = "change",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
        public String changeEmployeeSalary(HttpServletRequest request,@RequestBody employeeSalary employeeSalary){
            if(service.changeEmployeeSalary(employeeSalary)==1){
                return "Success";
            }
            else {
                return "False";
            }
        }

    @RequestMapping(value = "total",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
        public String totalEmployeeSalary(HttpServletRequest request,Model model){
            List<employeeSalary> employeeSalaryList=service.totalEmployeeSalary();
            model.addAttribute("list",employeeSalaryList);
            return "totalEmployeeSalary";
        }
        @RequestMapping(value = "")
}
