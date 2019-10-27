package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.entity.User;
import com.ssm.service.EmailService;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;

    @ResponseBody
    @RequestMapping("/getAllEmails.do")
    public String getAllUsers(HttpSession session){
        String result;
        String a = "\"code\": 0, \"msg\": \"\",\"count\" :10,\"data\" ";
        result = emailService.getAllEmails();
        result = "{" + a + ":" + result;
        result = result + "}";
        //System.out.println("getAllUsers:" + result);
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteEmail.do")
    public String deleteEmail(String t_id, HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        System.out.println(t_id);
        emailService.deleteEmail(t_id);
        return "删除成功";
    }

}
