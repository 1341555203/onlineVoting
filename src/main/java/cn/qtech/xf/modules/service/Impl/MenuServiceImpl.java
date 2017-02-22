package cn.qtech.xf.modules.service.Impl;

import cn.qtech.xf.modules.dao.MenuMapper;
import cn.qtech.xf.modules.dao.OptionMapper;
import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.entity.Option;
import cn.qtech.xf.modules.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public List<Menu> getAllMenu() {
		return menuMapper.getAllMenu();
	}

	@Override
	public void saveMenu(Menu menu) {
		menuMapper.insertSelective(menu);
		int menuId=menu.getId();
		System.out.println(menuId);
		for (Option o:menu.getOptions()) {
			if(o.getOptionTitle()!=null) {
				o.setMenuId(menuId);
				optionMapper.insertSelective(o);
			}
		}
	}

	@Override
	public List<Menu> getMenuByUser(Integer id) {
		return menuMapper.getMenuByUser(id);
	}
}
