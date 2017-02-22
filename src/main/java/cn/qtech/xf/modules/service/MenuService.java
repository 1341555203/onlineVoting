package cn.qtech.xf.modules.service;

import cn.qtech.xf.modules.entity.Menu;

import java.util.List;

/**
 * Created by mtf81 on 2017/2/22.
 */
public interface MenuService {
	List<Menu> getAllMenu();
	void saveMenu(Menu menu);
	List<Menu> getMenuByUser(Integer id);
}
