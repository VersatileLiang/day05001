package com.ssm.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.ssm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.UserService;

import java.io.IOException;
import java.util.List;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping("login.do")
	public String login(String username, String password, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String result = null;
		System.out.println("tag0: username: " + username + "   " + "password:" + password);
		
		//调用service服务层验证用户名和密码
//		result = userService.findUser(username,password);
		//登录成功，及保存用户名到session中
		if(result.equals("success")) {
            session.setAttribute("username",username);
            return "登录成功";
		}else {
            return "登录失败，账号密码错误";
        }
	}

    @ResponseBody
    @RequestMapping("getUserInfo.do")
    public String getUserInfo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        String result = null;
//        List<User> user = userService.getAllUser();
//        result = JSON.toJSON(user).toString();
        System.out.println("tag3:"+result);
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteUser.do")
    public String deleteUser(String userid, HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
//        userService.deleteUser(userid);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("deleteUsavver.do")
    public String searchUsers(String username, HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        String result = null;
//        List<User> user = userService.searchUsers(username);
//        result = JSON.toJSON(user).toString();
        System.out.println("tag7:"+result);
        return result;
    }
}
