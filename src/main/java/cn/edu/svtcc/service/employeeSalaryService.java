package cn.edu.svtcc.service;

import cn.edu.svtcc.pojo.employeeSalary;

public interface employeeSalaryService {
    employeeSalary findEmployeeSalary(long epyid);
    int insertEmployeeSalary(employeeSalary employeeSalary);
    int changeEmployeeSalary(employeeSalary employeeSalary);
    employeeSalary totalEmployeeSalary(employeeSalary employeeSalary);
}
