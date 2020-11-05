package cn.edu.svtcc.service;

import cn.edu.svtcc.pojo.employeeSalary;

public interface employeeSalaryService {
    employeeSalary findEmployeeSalary(long epyid);
    employeeSalary insertEmployeeSalary(employeeSalary employeeSalary);
    employeeSalary changeEmployeeSalary(employeeSalary employeeSalary);
    employeeSalary totalEmployeeSalary(employeeSalary employeeSalary);
}
