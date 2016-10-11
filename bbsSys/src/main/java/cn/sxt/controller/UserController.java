package cn.sxt.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sxt.service.UserService;
import cn.sxt.vo.User;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/login.do")
	public String login(User user,HttpSession session){
		System.out.println("name="+user.getName());
		System.out.println("pwd="+user.getPwd());
		user = userService.login(user);
		
		if(user != null){
			session.setAttribute("currentUser", user);
			return "redirect:/main.jsp";
		}
		
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/signin.do")
	public String signin(File file,User user,HttpServletRequest req){
		String path = req.getServletContext().getRealPath("/head");
		String name = file.getName();
		System.out.println("name================="+name);
		return null;
	}
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
