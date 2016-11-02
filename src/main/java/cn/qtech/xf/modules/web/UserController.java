package cn.qtech.xf.modules.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mtf81 on 2016/11/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
	/*
	user/sign in
	 */
	@RequestMapping(value = "/signin",method = RequestMethod.GET)
	public String signIn(){

		return "user/signin";
	}

	/*
	user/sign up
	 */
	@RequestMapping(value = "signup",method = RequestMethod.GET)
	public String signUp(){

		return "user/signup";
	}
}
