package cn.qtech.xf.modules.service;

import cn.qtech.xf.modules.dto.OptionDto;
import cn.qtech.xf.modules.entity.Menu;
import cn.qtech.xf.modules.entity.Option;
import cn.qtech.xf.modules.entity.Record;
import cn.qtech.xf.modules.entity.User;

import java.util.List;


public interface MenuService {
	List<Menu> getAllMenu();
	int saveMenu(Menu menu);
	List<Menu> getMenuByUser(Integer id);
	Menu getMenuById(Integer id);
	void commitARecord(Record record);
	Record getRecordByUserMenu(Record record);
	List<OptionDto> getRecordCount(List<Option> optionList);
	void setMenuStatus(Integer id);
	void delMenuById(Integer id);
//	List<OptionDto> getResultByMenuId(Integer id);
}
