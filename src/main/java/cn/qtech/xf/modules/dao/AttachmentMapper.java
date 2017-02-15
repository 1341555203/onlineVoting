package cn.qtech.xf.modules.dao;

import cn.qtech.xf.common.persistence.annotation.MyBatisDao;
import cn.qtech.xf.modules.dto.AttachmentDto;
import cn.qtech.xf.modules.entity.Attachment;
@MyBatisDao
public interface AttachmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);

    Attachment selectByTypeId(AttachmentDto attachmentDto);
}