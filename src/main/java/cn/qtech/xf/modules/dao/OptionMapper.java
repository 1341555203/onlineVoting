package cn.qtech.xf.modules.dao;

import cn.qtech.xf.common.persistence.annotation.MyBatisDao;
import cn.qtech.xf.modules.entity.Option;
import cn.qtech.xf.modules.entity.Record;

@MyBatisDao
public interface OptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Option record);

    int insertSelective(Option record);

    Option selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);

}