package cn.qtech.xf.modules.dto;

import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.entity.User;

import javax.swing.*;
import java.util.List;

/**
 * Created by mtf81 on 2017/2/23.
 */
public class ResultDto {
	private Menu menu;
	private List<OptionDto> optionDtos;
	private User createdBy;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<OptionDto> getOptionDtos() {
		return optionDtos;
	}

	public void setOptionDtos(List<OptionDto> optionDtos) {
		this.optionDtos = optionDtos;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public void addOptionDto(OptionDto optionDto){
		this.optionDtos.add(optionDto);
	}
}
