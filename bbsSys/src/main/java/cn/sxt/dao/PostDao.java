package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Post;

public interface PostDao {

	List<Post> list();

	boolean add(Post post);

	Post findById(int id);

	boolean addCount(Post post);

}
