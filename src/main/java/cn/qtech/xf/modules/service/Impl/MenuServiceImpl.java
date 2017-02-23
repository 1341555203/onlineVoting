package cn.qtech.xf.modules.service.Impl;

import cn.qtech.xf.modules.dao.MenuMapper;
import cn.qtech.xf.modules.dao.OptionMapper;
import cn.qtech.xf.modules.dao.RecordMapper;
import cn.qtech.xf.modules.dto.OptionDto;
import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.entity.Option;
import cn.qtech.xf.modules.entity.Record;
import cn.qtech.xf.modules.entity.User;
import cn.qtech.xf.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtf81 on 2017/2/22.
 */
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private OptionMapper optionMapper;
	@Autowired
	private RecordMapper recordMapper;
	@Override
	public List<Menu> getAllMenu() {
		return menuMapper.getAllMenu();
	}

	@Override
	public int saveMenu(Menu menu) {
		menuMapper.insertSelective(menu);
		int menuId=menu.getId();
		System.out.println(menuId);
		for (Option o:menu.getOptions()) {
			if(o.getOptionTitle()!=null) {
				o.setMenuId(menuId);
				optionMapper.insertSelective(o);
			}
		}
		return menuId;
	}

	@Override
	public List<Menu> getMenuByUser(Integer id) {
		return menuMapper.getMenuByUser(id);
	}

	@Override
	public Menu getMenuById(Integer id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	public void commitARecord(Record record) {
		recordMapper.insertSelective(record);
	}

	@Override
	public Record getRecordByUserMenu(Record record) {

		return recordMapper.selectByUserMenu(record);
	}

	@Override
	public List<OptionDto> getRecordCount(List<Option> optionList) {
		List<OptionDto> optionDtos=new ArrayList<OptionDto>();

		for(Option o:optionList){
			OptionDto optionDto=new OptionDto();
			optionDto.setOption(o);
			optionDto.setCount(recordMapper.getRecordCount(o));
			optionDtos.add(optionDto);
		}
		return optionDtos;
	}

	@Override
	public void setMenuStatus(Integer id) {
		menuMapper.setStatus(id);
	}

	@Override
	public void delMenuById(Integer id) {
		menuMapper.deleteByPrimaryKey(id);
	}


}
