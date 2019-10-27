package com.ssm.service;

import com.ssm.entity.User;

import java.util.List;

//用户服务的接口
public interface EmailService {

    String getAllEmails();

    void deleteEmail(String emailid);
}
