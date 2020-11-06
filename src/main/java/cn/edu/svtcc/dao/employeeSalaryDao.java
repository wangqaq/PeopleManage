package cn.edu.svtcc.dao;

import cn.edu.svtcc.pojo.employeeSalary;

public interface employeeSalaryDao {
    employeeSalary findEmployeeSalary(long epyid);
    employeeSalary insertEmployeeSalary(employeeSalary employeeSalary);
    employeeSalary changeEmployeeSalary(employeeSalary employeeSalary);
    employeeSalary totalEmployeeSalary(employeeSalary employeeSalary);

}
