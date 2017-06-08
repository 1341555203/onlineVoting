package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.dto.OptionDto;
import cn.qtech.xf.modules.dto.ResultDto;
import cn.qtech.xf.modules.entity.*;
import cn.qtech.xf.modules.service.CommitService;
import cn.qtech.xf.modules.service.Impl.MenuServiceImpl;
import cn.qtech.xf.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/voting")
public class VotingController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private CommitService commitService;
	/*
	voting/startup
	 */
	@RequestMapping(value = "/startup",method = RequestMethod.GET)
	public String startUpInit(){

		return "voting/startup";
	}
	@RequestMapping(value = "/createMenu",method = RequestMethod.POST)
	public String create(Menu menu, HttpSession httpSession){
		int menuId=0;
		if(menu!=null) {
			User currentUser=(User)httpSession.getAttribute("currentUser");
			if(currentUser!=null){
			menu.setCreatedBy(currentUser.getId());
			menuId=menuService.saveMenu(menu);
			}
		}
		return "redirect:/voting/result/"+menuId;
	}

	@RequestMapping(value = "/myVoting",method = RequestMethod.GET)
	public String myVoting(Model model, HttpSession httpSession){
		User currentUser=(User)httpSession.getAttribute("currentUser");
		List<Menu> menuList=menuService.getMenuByUser(currentUser.getId());
		model.addAttribute("menuList",menuList);
		return "voting/myVoting";
	}
	@RequestMapping(value = "/setStatus/{menuId}",method = RequestMethod.GET)
	public String setStatus(@PathVariable Integer menuId, HttpSession httpSession){
//		User currentUser =(User)httpSession.getAttribute("currentUser");
//		if(currentUser!=null){
//		}
		menuService.setMenuStatus(menuId);
		return "redirect:/voting/myVoting";
	}
	@RequestMapping(value = "/view/{menuId}",method = RequestMethod.GET)
	public String menuDetail(@PathVariable Integer menuId,Model model,HttpSession httpSession){
		User currentUser=(User)httpSession.getAttribute("currentUser");
		Menu menu=menuService.getMenuById(menuId);
		Record recordTmp=new Record();
		recordTmp.setMenuId(menuId);
		if(currentUser!=null) {
			recordTmp.setUserId(currentUser.getId());
			Record record = menuService.getRecordByUserMenu(recordTmp);

			if (record != null) {
				return "redirect:/voting/result/" + record.getMenuId();
			}
		}
		if(menu!=null) {
			if(menu.getMenuStatus().equals("1")){
				return "redirect:/voting/result/" + menu.getId();
			}
			model.addAttribute(menu);
			return "voting/view";
		}
		return "redirect:/sys/home";
	}
	/*
	提交选择
	 */
	@RequestMapping(value = "/view/commitVoting",method = RequestMethod.POST)
	public String commitVoting(Record record){
		if (record.getUserId()==null){
			return "redirect:/user/signin";
		}
		menuService.commitARecord(record);
		return "redirect:/voting/result/"+record.getMenuId();
	}

	@RequestMapping(value = "/result/{menuId}",method = RequestMethod.GET)
	public String votingResult(@PathVariable Integer menuId,Model model ,HttpSession httpSession){
		ResultDto resultDto=new ResultDto();
		Menu menu=menuService.getMenuById(menuId);
		//获取结果
		List<OptionDto> optionDtos=menuService.getRecordCount(menu.getOptions());
		resultDto.setMenu(menu);
		resultDto.setOptionDtos(optionDtos);
//		resultDto.setCreatedBy((User)httpSession.getAttribute("currentUser"));
		//获取评论
		List<Commit> commits=commitService.findCommitByMenuId(menuId);

		model.addAttribute(resultDto);

		model.addAttribute("commits",commits);
		return "voting/result";
	}

	@RequestMapping(value = "/addCommit",method = RequestMethod.POST)
	public String addCommit(Commit commit){
		commitService.addCommit(commit);
		return "redirect:/voting/result/"+commit.getMenuId();
	}
}
