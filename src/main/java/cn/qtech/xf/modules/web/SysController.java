package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.entity.User;
import cn.qtech.xf.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mtf81 on 2016/11/2.
 */
@Controller
@RequestMapping("/sys")
public class SysController {
	@Autowired
	private MenuService menuService;
	/*
	sys/home
	 */
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(Model model, HttpSession httpSession){
		User currentUser=(User) httpSession.getAttribute("currentUser");
		model.addAttribute("currentUser",currentUser);

		List<Menu> menuList=menuService.getAllMenu();
		model.addAttribute("menuList",menuList);
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
