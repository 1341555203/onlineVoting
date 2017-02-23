package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.entity.User;
import cn.qtech.xf.modules.service.MenuService;
import cn.qtech.xf.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resources;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mtf81 on 2017/2/23.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public String adminUsers(HttpSession httpSession,Model model){
		User admin=(User)httpSession.getAttribute("admin");
		if((admin!=null)&&(admin.getUserType().equals("1"))){
			List<User> userList=userService.findAllUser();
			List<Menu> menuList=menuService.getAllMenu();
			model.addAttribute(userList);
			model.addAttribute(menuList);
			return "sys/adminUser";
		}
		return "redirect:/user/account";
	}
	@RequestMapping(value = "/del/{userId}",method = RequestMethod.GET)
	public String delUser(@PathVariable Integer userId,HttpSession httpSession){

		User admin=(User)httpSession.getAttribute("admin");
		if((admin!=null)&&(admin.getUserType().equals("1"))){
			userService.delUser(userId);
			return "redirect:/admin/users";
		}
		return "redirect:/user/account";
	}
	@RequestMapping(value = "/del2/{menuId}",method = RequestMethod.GET)
	public String delMenu(@PathVariable Integer menuId,HttpSession httpSession){

		User admin=(User)httpSession.getAttribute("admin");
		if((admin!=null)&&(admin.getUserType().equals("1"))){
			menuService.delMenuById(menuId);
			return "redirect:/admin/users";
		}
		return "redirect:/user/account";
	}
}
