package cn.qtech.xf.modules.web;

import cn.qtech.xf.modules.dto.OptionDto;
import cn.qtech.xf.modules.dto.ResultDto;
import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mtf81 on 2017/6/8.
 */
@RestController
@RequestMapping("/result")
public class ResultController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/get/{menuId}",method = RequestMethod.GET)
	public List<OptionDto> getResult(@PathVariable Integer menuId){

		Menu menu=menuService.getMenuById(menuId);
		//获取结果
		List<OptionDto> optionDtos=menuService.getRecordCount(menu.getOptions());

		return optionDtos;
	}
}
