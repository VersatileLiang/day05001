package com.ssm.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.ssm.dao.EmailDao;
import com.ssm.dao.UserDao;
import com.ssm.entity.Email;
import com.ssm.entity.User;
import com.ssm.service.EmailService;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*用户名密码处理*/
@Service("EmailService")
public class EmailServiceImpl implements EmailService {

	//如何调用dao层
	@Autowired
	private EmailDao dao;

    @Override
    public String getAllEmails() {
        String result;
        List<Email> emailList = dao.getAllEmails();
        result = JSON.toJSON(emailList).toString();
        return result;
    }

    @Override
    public void deleteEmail(String emailid) {
        dao.deleteEmail(emailid);
    }
}
