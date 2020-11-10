package cn.edu.svtcc.dao;

import cn.edu.svtcc.pojo.employeeSalary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface employeeSalaryDao {
    @Select("select * from employeeSalary where epyid=#{epyid}")
    employeeSalary findEmployeeSalary(long epyid);
    @Insert("insert into")
    int insertEmployeeSalary(employeeSalary employeeSalary);
    @Update()
    int changeEmployeeSalary(employeeSalary employeeSalary);
    List<employeeSalary> totalEmployeeSalary();

}
