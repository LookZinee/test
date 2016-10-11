package cn.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.UserDao;
import cn.sxt.service.UserService;
import cn.sxt.vo.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean signin(User user) {
		return userDao.signin(user);
	}

}
