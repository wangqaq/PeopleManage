package cn.edu.svtcc.pojo;

import lombok.*;


/**
 * @author Daved
 * @title User
 * @description
 * @date 2020/06/10/20:58
 */

@Getter
@Setter
@ToString
public class User {
  private long userId;

  private String userName;

  private String sex;

  private int age;

  private String department;

  private String password;

}
