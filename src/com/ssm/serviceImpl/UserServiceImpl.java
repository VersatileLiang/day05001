package com.ssm.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.ssm.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import com.ssm.service.UserService;

/*用户名密码处理*/
@Service("UserService")
public class UserServiceImpl implements UserService{

	//如何调用dao层
	@Autowired
	private UserDao dao;

    @Override
    public String getAllUsers() {
        String result;
        List<User> users = dao.getAllUser();
        result = JSON.toJSON(users).toString();
        return result;
    }

    @Override
    public void updateUsser(String username, String password) {

    }
}
