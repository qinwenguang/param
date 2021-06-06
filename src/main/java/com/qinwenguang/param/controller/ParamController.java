package com.qinwenguang.param.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qinwenguang.param.util.JsonUtil;
import com.qinwenguang.param.util.User;

@RestController
@RequestMapping("/param")
public class ParamController {

	@RequestMapping(value= {"/get"},method={RequestMethod.GET})
	public Object get(@RequestParam("userId")Integer userId,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password){
		User user = new User();
		user.setUserId(userId).setPassword(password).setUserName(userName);
		return JsonUtil.beanToJson(user);
	}

	/**
	 * post请求：请求参数必须为JSON
	 * 	{
    		"userId":1,
    		"userName":"wenguang",
    		"password":"123"
		}
	 */
	@PostMapping("/post")
	public void addAddr(@RequestBody User user,HttpServletResponse resp) throws Exception {
		//自己设定编码，防止输出中文乱码
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String jsonString = JsonUtil.beanToJson(user);
		out.println(jsonString);
	}
}
