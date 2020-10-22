package cn.edu.svtcc.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Daved
 * @title Message
 * @description
 * @date 2020/06/10/20:58
 */

@Setter
@Getter
@ToString
public class Message {
  private int errCode;//错误码
  private String msg;//返回信息
  private boolean success;//是否成功


  public Message(boolean success, String msg) {
    super();
    this.success = success;
    this.msg = msg;
  }


  public Message(boolean success, String msg, int errCode) {
    super();
    this.success = success;
    this.msg = msg;
    this.errCode = errCode;
  }
}
