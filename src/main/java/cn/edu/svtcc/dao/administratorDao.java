package cn.edu.svtcc.dao;

import cn.edu.svtcc.pojo.administrator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface administratorDao {
    @Select("select from administrator where loginname=#{loginname} and loginpassword=#{loginpasssword}")
    administrator login(administrator administrator);
    @Insert("Insert into administrator(loginname,loginpassword) value(#{loginname},#{loginpassword})")
    administrator register(administrator administrator);
}
