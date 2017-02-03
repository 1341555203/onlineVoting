package cn.qtech.xf.modules.service;

import cn.qtech.xf.modules.dto.UserDto;
import cn.qtech.xf.modules.entity.User;

/**
 * Created by mtf81 on 2017/2/3.
 */
public interface UserService {
	User selectByEmailPassword(UserDto userDto);
	User selectByEmailUsername(UserDto userDto);
	void register(User user);
	void update(User user);
	User selectByEmail(String email);
}
