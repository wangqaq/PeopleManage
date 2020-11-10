package cn.edu.svtcc.service;

import cn.edu.svtcc.pojo.employeeSalary;

import java.util.List;

public interface employeeSalaryService {
    employeeSalary findEmployeeSalary(long epyid);
    int insertEmployeeSalary(employeeSalary employeeSalary);
    int changeEmployeeSalary(employeeSalary employeeSalary);
    List<employeeSalary> totalEmployeeSalary();
}
