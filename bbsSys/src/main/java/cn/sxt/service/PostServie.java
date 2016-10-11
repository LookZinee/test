package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.Post;

public interface PostServie {

	List<Post> list();

	boolean addPost(Post post);

	Post findById(int id);

	boolean addCount(Post post);

}
