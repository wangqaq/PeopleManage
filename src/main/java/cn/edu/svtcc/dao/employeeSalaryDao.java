package cn.edu.svtcc.dao;

import cn.edu.svtcc.pojo.employeeSalary;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface employeeSalaryDao {
    employeeSalary findEmployeeSalary(long epyid);
    @Insert("")
    int insertEmployeeSalary(employeeSalary employeeSalary);
    int changeEmployeeSalary(employeeSalary employeeSalary);
    List<employeeSalary> totalEmployeeSalary();

}
