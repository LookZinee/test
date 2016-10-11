package cn.sxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.PostDao;
import cn.sxt.service.PostServie;
import cn.sxt.vo.Post;
@Service("postService")
public class PostServiceImpl implements PostServie{
	@Autowired
	private PostDao postDao;

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	@Override
	public List<Post> list() {
		
		return postDao.list();
	}

	@Override
	public boolean addPost(Post post) {
		return postDao.add(post);
	}

	@Override
	public Post findById(int id) {
		return postDao.findById(id);
	}
	@Override
	public boolean addCount(Post post) {
		return postDao.addCount(post);
	}
}
