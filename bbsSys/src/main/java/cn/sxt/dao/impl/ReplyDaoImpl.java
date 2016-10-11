package cn.sxt.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.ReplyDao;
import cn.sxt.vo.Reply;
@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {
	@Autowired
	private SessionFactory sessionFactory;

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Reply> findByPostId(int postId){
		return sessionFactory.getCurrentSession()
				.createQuery("from Reply where postid=?")
				.setInteger(0, postId)
				.list();
	}

	@Override
	public boolean addReply(Reply reply) {
		try {
			sessionFactory.getCurrentSession()
			.save(reply);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
