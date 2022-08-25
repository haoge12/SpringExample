package com.xuhao;

import com.xuhao.dao.UserDao;
import com.xuhao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //传入对应配置文件的输入流，读取配置文件获得SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过SQLSessionFactory获取SqlSession（理解为是一个数据库连接）
        SqlSession session = sqlSessionFactory.openSession(true);
        //通过SqlSessionFactory获取dao接口的实现类对象
        UserDao userDao = session.getMapper(UserDao.class);

//        List<User> users = userDao.findAll();
//        System.out.println(users);

//        System.out.println(userDao.findById(1));

//        Map map = new HashMap();
//        map.put("id", 2);
//        map.put("username", "PDD");
//        map.put("age", 25);
//        map.put("address", "杭州");
//        System.out.println(userDao.findByMap(map));

//        List<User> users = userDao.findByCondition(null, 22);
//        for (User user : users) {
//            System.out.println(user);
//        }
        Integer[] ids = {1,2,3,4,5};
        List<User> byIds = userDao.findByIds(ids);
        for (User byId : byIds) {
            System.out.println(byId);
        }
//        System.out.println(userDao.findByIds(ids));
//        System.out.println(byIds);
//        System.out.println(users);
//        System.out.println(userDao.findByCondition("xuhao", 22));
//        userDao.insertUser(new User(14, "gyz", 23, "杭州"));
//        userDao.updateUser(new User(12, "hhh", 12, "jinhua"));
        //释放资源
//        session.commit();
        session.close();
    }
}
