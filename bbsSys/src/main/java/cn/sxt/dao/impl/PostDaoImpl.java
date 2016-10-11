package cn.sxt.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.PostDao;
import cn.sxt.vo.Post;
@Repository("postDao")
public class PostDaoImpl implements PostDao{
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Post> list() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Post.class)
				.list();
	}

	@Override
	public boolean add(Post post) {
		try {
			post.setCreatetime(new Date());
			sessionFactory.getCurrentSession().save(post);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public Post findById(int id) {
		Post post = (Post) sessionFactory.getCurrentSession()
				.get(Post.class, id);
		return post !=null?post:null;
	}

	@Override
	public boolean addCount(Post post) {
		try {
			
			Post p = (Post) sessionFactory.getCurrentSession()
					.get(Post.class, post.getId());
			System.out.println("当前点击量："+p.getCount());
			p.setCount(p.getCount()+1);
			System.out.println("+1 之后的点击量:"+p.getCount());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
