package cn.qtech.xf.modules.dao;

import cn.qtech.xf.common.persistence.annotation.MyBatisDao;
import cn.qtech.xf.modules.entity.Menu;

import java.util.List;

@MyBatisDao
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAllMenu();

    List<Menu> getMenuByUser(Integer id);

    void setStatus(Integer id);

}