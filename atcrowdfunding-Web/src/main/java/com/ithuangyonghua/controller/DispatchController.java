package com.ithuangyonghua.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuangyonghua.bean.AjaxResult;
import com.ithuangyonghua.bean.User;
import com.ithuangyonghua.service.UserService;
/**
 * 登陆 && 退出
 * @author Hyh
 *
 */
@Controller
public class DispatchController {
	@Autowired
	UserService userService;

	/**
	 * 跳转到登陆
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * 跳转到主页面
	 * 
	 * @return
	 */
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	/**
	 * 执行登陆
	 * 
	 * @return
	 */
	@RequestMapping("/dologin")
	public String doLogin(User user, Model model) {
		// (1)获取表单数据
		// (1-1) HttpServletRequest
		// (1-2) 在方法参数列表中增加表单对应的参数,名称相同(即就是前端的name属性值与方法参数一致)
		// (1-3) 将表单数据封装为实体类对象(即就是前端的name属性值与实体属性一致)

		// (2)查询用户信息
		User dbuser = userService.queryForLogin(user);
		// (3)判断用户是否存在
		if (dbuser != null) {
			// 登陆成功,跳转到主页面
			return "main";// 默认是转发的方式
		} else {
			// 登陆失败,跳转回登陆页面,并提示错误信息
			String message = "登陆的账号或密码错误,请重新输入";
			model.addAttribute("msg", message);
			return "redirect:login";
		}

	}

	/**
	 * Ajax 登陆处理
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAjaxLogin")
	public Object doAjaxLogin(User user,HttpSession session) {
		AjaxResult ajaxResult = new AjaxResult();
		User dbuser = userService.queryForLogin(user);
		if (dbuser != null) {
			// 登陆成功,跳转到主页面
			ajaxResult.setSuccess(true);
			session.setAttribute("loginUser", dbuser);
			return ajaxResult;// 默认是转发的方式
		} else {
			// 登陆失败,跳转回登陆页面,并提示错误信息
			// String message = "登陆的账号或密码错误,请重新输入";
			// model.addAttribute("msg", message);
			ajaxResult.setSuccess(false);
			return ajaxResult;
		}
	}
	/**
	 * 退出系统
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String Logout(HttpSession session){
//		session.removeAttribute("loginUser");
		session.invalidate();
		return "redirect:login";//重定向到登录页面就是浏览器路径也会变成login
	}

}
