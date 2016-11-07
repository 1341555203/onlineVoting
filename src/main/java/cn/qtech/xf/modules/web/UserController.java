package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * Created by mtf81 on 2016/11/2.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("currentUser")
public class UserController {
	/*
	user/sign in
	 */
	@RequestMapping(value = "/signin",method = RequestMethod.GET)
	public String signInInit(){

		return "user/signin";
	}
	@RequestMapping(value = "/signin",method = RequestMethod.POST)
	public String signIn(HttpSession httpSession){
		User currentUser=new User(1,"mtf","mtf917@gmail.com");
		httpSession.setAttribute("currentUser",currentUser);
		return "redirect:/sys/home";
	}

	/*
	user/sign up
	 */
	@RequestMapping(value = "/signup",method = RequestMethod.GET)
	public String signUpInit(){

		return "user/signup";
	}
	/*
	user/sign out
	 */
	@RequestMapping(value = "/signout",method = RequestMethod.GET)
	public String signOut(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:/sys/home";
	}
}
