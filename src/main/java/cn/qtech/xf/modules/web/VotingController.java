package cn.qtech.xf.modules.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mtf81 on 2017/2/9.
 */
@Controller
@RequestMapping(value = "/voting")
public class VotingController {
	/*
	voting/startup
	 */
	@RequestMapping(value = "/startup",method = RequestMethod.GET)
	public String startUpInit(){

		return "voting/startup";
	}
}
