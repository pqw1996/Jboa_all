package com.accp.pqw.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.accp.pqw.pojo.Employee;

public class LoginCheck implements HandlerInterceptor {

	// 处理器方法映射之前执行
	// 返回true，放行；false，不放行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Employee emp = (Employee) request.getSession().getAttribute("emp");
		if (emp != null) {
			return true;
		}
		request.getRequestDispatcher("/c/Employee/loginOut").forward(request, response);
		return false;
	}

	// 处理器方法映射执行之后会自动调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	// 所有请求完成之后调用
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
