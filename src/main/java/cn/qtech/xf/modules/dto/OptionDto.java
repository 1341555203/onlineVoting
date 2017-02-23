package cn.qtech.xf.modules.dto;

import cn.qtech.xf.modules.entity.Option;

/**
 * Created by mtf81 on 2017/2/23.
 */
public class OptionDto {
	private Option option;
	private Integer count;

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
