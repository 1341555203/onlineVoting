package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.dto.UserDto;
import cn.qtech.xf.modules.entity.User;
import cn.qtech.xf.modules.entity.User_Temp;
import cn.qtech.xf.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by mtf81 on 2016/11/2.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("currentUser")
public class UserController {
	@Autowired
	private UserService userService;
	/*
	user/sign in
	 */
	@RequestMapping(value = "/signin",method = RequestMethod.GET)
	public String signInInit(){

		return "user/signin";
	}
	@RequestMapping(value = "/signin",method = RequestMethod.POST)
	public String signIn(@Valid UserDto userDto, Errors errors,HttpSession httpSession){

//		User_Temp currentUser=new User_Temp(1,"mtf","mtf917@gmail.com");
//		httpSession.setAttribute("currentUser",currentUser);
		System.out.println(userDto.getEmail());
		if(errors.hasErrors()){
			return "user/signin";
		}
		User currentUser=userService.selectByEmailPassword(userDto);
		if(currentUser!=null){
			httpSession.setAttribute("currentUser",currentUser);
			return "redirect:/user/account";
		}
		return "user/signin";
	}

	/*
	user/sign up
	 */
	@RequestMapping(value = "/signup",method = RequestMethod.GET)
	public String signUpInit(){

		return "user/signup";
	}
	@RequestMapping(value="/signup",method = RequestMethod.POST)
	public String signUp(@Valid User user, Errors errors, ModelMap modelMap){
		if(errors.hasErrors()){
			return "user/signup";
		}
		else if(userService.selectByEmail(user.getEmail())!=null){
			modelMap.put("errorMessage","该邮箱已被注册!");
			return "user/signup";
		}
		userService.register(user);
		modelMap.addAttribute("userDto",user);
		return "redirect:/user/signupSuccess";
	}
	/*
	user/signupSuccess
	 */
	@RequestMapping(value = "/signupSuccess",method = RequestMethod.GET)
	public String signupSuccess(){
		return "user/signupSuccess";
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
