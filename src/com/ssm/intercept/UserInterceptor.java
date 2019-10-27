package com.ssm.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器：拦截未登录的用户
public class UserInterceptor implements HandlerInterceptor{
	
	/*数据处理后运行*/
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
	/*数据传输果成中运行*/
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {		
	}
	/*用于用户登入前，判断用户是否登录过*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		boolean result = false;
		//判断是否登录过，登录就让其访问
        StringBuffer url = request.getRequestURL();
        if(url.indexOf("login")!=-1 || url.indexOf("index")!=-1) {
            result = true;
        }
		if(request.getSession().getAttribute("username")!=null) {
			result = true;
		}
		if(!result) {
			//若没有登录，跳转至登录页面
			request.getRequestDispatcher("login.jsp").forward(request,response);
			result = false;
		}
		return result;
	}
}
