package cn.qtech.xf.modules.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mtf81 on 2016/10/28.
 */
@Controller
@RequestMapping("/temp")
public class TempController {

	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String homePage(){
		return "sys/home";
	}
}
