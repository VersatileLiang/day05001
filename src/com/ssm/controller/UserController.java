package com.ssm.controller;

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

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

    @ResponseBody
    @RequestMapping("/getAllUsers.do")
    public String getAllUsers(HttpSession session){
        String result;
        String a = "\"code\": 0, \"msg\": \"\",\"count\" :10,\"data\" ";
        result = userService.getAllUsers();
        result = "{" + a + ":" + result;
        result = result + "}";
        //System.out.println("getAllUsers:" + result);
        return result;
    }

    @ResponseBody
    @RequestMapping("/updateUsser.do")
    public String updateUsser(String username, String password, HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        userService.updateUsser(username, password);
        return "删除成功";
    }

}
