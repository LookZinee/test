package cn.sxt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.ReplyDao;
import cn.sxt.service.ReplyService;
import cn.sxt.vo.Reply;

@Service("replyServie")
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;

	public ReplyDao getReplyDao() {
		return replyDao;
	}

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<Reply> findByPostId(int postId) {
		return replyDao.findByPostId(postId);
	}

	@Override
	public boolean addReply(Reply reply) {
		reply.setReplytime(new Date());
		return replyDao.addReply(reply);
	}
	
	
}
