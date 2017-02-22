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
 * Created by mtf81 on 2017/2/9.
 */
@Controller
@RequestMapping(value = "/voting")
public class VotingController {
	@Autowired
	private MenuService menuService;
	/*
	voting/startup
	 */
	@RequestMapping(value = "/startup",method = RequestMethod.GET)
	public String startUpInit(){

		return "voting/startup";
	}
	@RequestMapping(value = "/createMenu",method = RequestMethod.POST)
	public String create(Menu menu, HttpSession httpSession){
		if(menu!=null) {
			User currentUser=(User)httpSession.getAttribute("currentUser");
			if(currentUser!=null){
			menu.setCreatedBy(currentUser.getId());
			menuService.saveMenu(menu);
			}
		}
		return "redirect:/user/account";
	}

	@RequestMapping(value = "/myVoting",method = RequestMethod.GET)
	public String myVoting(Model model, HttpSession httpSession){
		User currentUser=(User)httpSession.getAttribute("currentUser");
		List<Menu> menuList=menuService.getMenuByUser(currentUser.getId());
		model.addAttribute("menuList",menuList);
		return "voting/myVoting";
	}
}
