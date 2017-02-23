package cn.qtech.xf.modules.dao;

import cn.qtech.xf.common.persistence.annotation.MyBatisDao;
import cn.qtech.xf.modules.entity.Option;
import cn.qtech.xf.modules.entity.Record;
import cn.qtech.xf.modules.entity.User;

@MyBatisDao
public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    Record selectByUserMenu(Record record);

    int getRecordCount(Option option);
}