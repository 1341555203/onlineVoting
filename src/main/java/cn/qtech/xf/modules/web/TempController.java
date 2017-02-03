package cn.qtech.xf.modules.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/temp")
public class TempController {

	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String homePage(){
		return "sys/home";
	}
	@RequestMapping(value="/vote/view",method = RequestMethod.GET)
	public String voteView(){
		return "vote/view";
	}
}
