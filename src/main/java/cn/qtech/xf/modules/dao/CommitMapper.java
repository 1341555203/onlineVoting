package cn.qtech.xf.modules.dao;

import cn.qtech.xf.common.persistence.annotation.MyBatisDao;
import cn.qtech.xf.modules.entity.Commit;

import java.util.List;
@MyBatisDao
public interface CommitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commit record);

    int insertSelective(Commit record);

    Commit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Commit record);

    int updateByPrimaryKey(Commit record);
    List<Commit> findCommitByMenuId(Integer id);
}