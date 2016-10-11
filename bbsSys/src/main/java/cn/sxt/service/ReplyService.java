package cn.sxt.service;

import java.util.List;

import cn.sxt.vo.Reply;

public interface ReplyService {

	List<Reply> findByPostId(int postId);

	boolean addReply(Reply reply);

}
