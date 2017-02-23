package cn.qtech.xf.modules.service.Impl;

import cn.qtech.xf.modules.dao.CommitMapper;
import cn.qtech.xf.modules.entity.Commit;
import cn.qtech.xf.modules.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mtf81 on 2017/2/23.
 */
@Service
public class CommitServiceImpl implements CommitService{
	@Autowired
	private CommitMapper commitMapper;
	@Override
	public List<Commit> findCommitByMenuId(Integer id) {
		return commitMapper.findCommitByMenuId(id);
	}

	@Override
	public void addCommit(Commit commit) {
		commitMapper.insertSelective(commit);
	}
}
