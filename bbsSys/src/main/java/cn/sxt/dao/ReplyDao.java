package cn.sxt.dao;

import java.util.List;

import cn.sxt.vo.Reply;

public interface ReplyDao {

	List<Reply> findByPostId(int postId);

	boolean addReply(Reply reply);

}
