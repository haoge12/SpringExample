package com.xuhao.dao;

import com.xuhao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();
    User findById(Integer id);
    User findByMap(Map map);
    List<User> findByCondition(@Param("id") Integer id, @Param("age") Integer age);
    List<User> findByIds(@Param("ids") Integer[] ids);
    void insertUser(User user);
    void updateUser(User user);
}
