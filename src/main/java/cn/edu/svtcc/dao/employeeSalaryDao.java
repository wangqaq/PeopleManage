package cn.edu.svtcc.dao;

import cn.edu.svtcc.pojo.employeeSalary;
import org.apache.ibatis.annotations.Insert;

public interface employeeSalaryDao {
    employeeSalary findEmployeeSalary(long epyid);
    @Insert("")
    int insertEmployeeSalary(employeeSalary employeeSalary);
    int changeEmployeeSalary(employeeSalary employeeSalary);
    employeeSalary totalEmployeeSalary(employeeSalary employeeSalary);

}
