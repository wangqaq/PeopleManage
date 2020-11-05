package cn.edu.svtcc.dao;

import cn.edu.svtcc.pojo.employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Daved
 * @title UserDao
 * @description
 * @date 2020/06/10/20:58
 */
@Repository
public interface EmployeeDao {

  @Select("select * from administrator where loginname=#{userName} and loginpasssword=#{password}")
  employee login(employee employee);

  @Select("select * from user where userId = #{userId}")
  employee queryById(long id);

  @Select("select * from user where userName = #{userName}")
  List<employee> queryByName(@Param(value = "userName") String userName);

  @Select("select * from user")
  List<employee> queryAll();

  @Insert("insert into user(userName,sex,age,department) values(#{userName},#{sex},#{age},#{department})")
  int addUser(employee employee);

  @Update("UPDATE user SET userName=#{userName},sex=#{sex},age=#{age},department=#{department} WHERE userId=#{userId}")
  int updateUser(employee employee);

  @Delete("DELETE FROM user WHERE userId = #{userId} ")
  int deleteById(long id);
}
