package cn.sxt.dao;

import cn.sxt.vo.User;

public interface UserDao {

	User login(User user);

	boolean signin(User user);

}
