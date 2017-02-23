package cn.qtech.xf.modules.service;

import cn.qtech.xf.modules.entity.Commit;

import java.util.List;

/**
 * Created by mtf81 on 2017/2/23.
 */
public interface CommitService {
	List<Commit> findCommitByMenuId(Integer id);
	void addCommit(Commit commit);
}
