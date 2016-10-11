package cn.sxt.service;

import cn.sxt.vo.User;

public interface UserService {

	User login(User user);

	boolean signin(User user);

}
