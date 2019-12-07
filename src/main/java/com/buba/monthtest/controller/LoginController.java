package com.buba.monthtest.controller;


import com.buba.monthtest.dao.RedisMapper;
import com.buba.monthtest.dao.impl.redisDaoImpl;
import com.buba.monthtest.pojo.Book;
import com.buba.monthtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chang
 * @since 2019-08-26
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    redisDaoImpl redisDao;

    @RequestMapping("Register")
    //注册
    public  Map register (String name ,String password){
        String s = redisDao.get(name);
        Map map=new HashMap();
        if(s==null){
            String s1= redisDao.set(name,password);
            //System.out.println("注册成功!"+s1);
            map.put("msg","注册成功!");

        }else {
            //System.out.println("用户名已存在,请重新输入!");
            map.put("msg","用户名已存在,请重新输入!");
        }
        return map;

    }
    //登录
    @RequestMapping("loginOne")
    public Map login (String name , String password, HttpSession session){
        String s = redisDao.get(name);
        System.out.println(s);
        Map map=new HashMap();
        if(s.equals(password)){
            map.put("msg","登录成功！");

            session.setAttribute("name",name);

        }else {
            map.put("msg","登录失败");

        }

        return map;

    }

}
