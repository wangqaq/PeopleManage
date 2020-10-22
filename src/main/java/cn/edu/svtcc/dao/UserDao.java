package cn.edu.svtcc.dao;

import cn.edu.svtcc.pojo.User;
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
public interface UserDao {

  @Select("select * from root_user where username=#{userName} and userpassword=#{password}")
  User login(User user);

  @Select("select * from user where userId = #{userId}")
  User queryById(long id);

  @Select("select * from user where userName = #{userName}")
  List<User> queryByName(@Param(value = "userName") String userName);

  @Select("select * from user")
  List<User> queryAll();

  @Insert("insert into user(userName,sex,age,department) values(#{userName},#{sex},#{age},#{department})")
  int addUser(User user);

  @Update("UPDATE user SET userName=#{userName},sex=#{sex},age=#{age},department=#{department} WHERE userId=#{userId}")
  int updateUser(User user);

  @Delete("DELETE FROM user WHERE userId = #{userId} ")
  int deleteById(long id);
}
