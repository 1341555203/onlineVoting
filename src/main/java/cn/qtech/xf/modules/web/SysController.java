package cn.qtech.xf.modules.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Contended;

import javax.annotation.Resources;

/**
 * Created by mtf81 on 2016/11/2.
 */
@Controller
@RequestMapping("/sys")
public class SysController {
	/*
	sys/help
	 */
	@RequestMapping(value = "/help",method = RequestMethod.GET)
	public String help(){

		return "sys/help";
	}
}
