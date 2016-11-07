package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Contended;

import javax.annotation.Resources;
import javax.servlet.http.HttpSession;

/**
 * Created by mtf81 on 2016/11/2.
 */
@Controller
@RequestMapping("/sys")
public class SysController {
	/*
	sys/home
	 */
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(Model model, HttpSession httpSession){
		User currentUser=(User)httpSession.getAttribute("currentUser");
		model.addAttribute("currentUser",currentUser);
		return "sys/home";
	}
	/*
	sys/help
	 */
	@RequestMapping(value = "/help",method = RequestMethod.GET)
	public String help(){

		return "sys/help";
	}
}
