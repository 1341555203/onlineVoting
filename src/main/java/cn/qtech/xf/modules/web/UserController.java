package cn.qtech.xf.modules.web;

import cn.qtech.xf.common.utils.EncodeUtil;
import cn.qtech.xf.modules.dto.UserDto;
import cn.qtech.xf.modules.entity.User;
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

		userDto.setPassword(EncodeUtil.EncodeByMd5(userDto.getPassword()));
//		System.out.println(userDto.getPassword());
		System.out.println(userDto.getEmail()+"-----Login request");
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
	public String signUp(@Valid UserDto userDto, Errors errors, ModelMap modelMap){
		if(errors.hasErrors()){
			return "user/signup";
		}
		else if(userService.selectByEmail(userDto.getEmail())!=null){
			modelMap.put("errorMessage","该邮箱已被注册!");
			return "user/signup";
		}
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(EncodeUtil.EncodeByMd5(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
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

	/*
	user/account
	 */
//	TODO replace the user/account logic in Filter
	@RequestMapping(value = "/account",method = RequestMethod.GET)
	public String account(HttpSession httpSession,Model model){
		User currentUser=(User)httpSession.getAttribute("currentUser");
		if(currentUser!=null) {
			model.addAttribute(currentUser);
			return "user/account";
		}
		return "redirect:/user/signin";
	}
}
