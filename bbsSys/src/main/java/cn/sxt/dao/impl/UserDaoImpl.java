package cn.sxt.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.UserDao;
import cn.sxt.vo.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public User login(User user) {
		System.out.println("进入到这");
		User u = (User) sessionFactory.getCurrentSession()
				.createQuery("from User where name=? and pwd=? ")
				.setString(0, user.getName())
				.setString(1, user.getPwd())
				.uniqueResult();
		return u != null?u:null;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean signin(User user) {
		try {
			sessionFactory.getCurrentSession()
			.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

}
