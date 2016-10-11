package cn.sxt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.sxt.service.PostServie;
import cn.sxt.service.ReplyService;
import cn.sxt.service.UserService;
import cn.sxt.vo.Post;
import cn.sxt.vo.Reply;
import cn.sxt.vo.User;
@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostServie postService;
	@Autowired
	private ReplyService replyServie;
	@RequestMapping("/login.do")
	public String login(User user,HttpSession session,HttpServletRequest req){
		System.out.println("name="+user.getName());
		System.out.println("pwd="+user.getPwd());
		user = userService.login(user);
		
		if(user != null){
			session.setAttribute("currentUser", user);
			return list(req);
		}
		
		return "redirect:/login.jsp";
	}
	@RequestMapping("/list.do")
	public String list(HttpServletRequest req){
		List<Post> posts = postService.list();
		req.setAttribute("posts", posts);
		return "forward:/main.jsp";
	}
	
	@RequestMapping("/addPost.do")
	public String addPost(Post post,HttpServletRequest req){
		post.setUser((User)req.getSession().getAttribute("currentUser"));
		boolean flag = postService.addPost(post);
		return list(req);
	}
	@RequestMapping("/checkPost.do")
	public String checkPost(Post post,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//点击量+1
		boolean flag = postService.addCount(post);
		//查询出该帖子的所有回复
		post = postService.findById(post.getId());
		System.out.println("post:::==="+post);
		List<Reply> replys = replyServie.findByPostId(post.getId());
		req.setAttribute("post", post);
		req.setAttribute("replys", replys);
		req.getRequestDispatcher("/reply/show.jsp").forward(req, resp);
		return null;
	}
	@RequestMapping("/addReply.do")
	public String addReply(Reply reply,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		reply.setUser((User)req.getSession().getAttribute("currentUser"));
		boolean flag = replyServie.addReply(reply);
		Post post = postService.findById(reply.getPost().getId());
		return checkPost(post, req, resp);
	}
	@RequestMapping("/signin.do")
	public String upload(@RequestParam("file")CommonsMultipartFile file,User user,HttpServletRequest req) throws Exception{
		String path=req.getServletContext().getRealPath("/upload");
		InputStream is = file.getInputStream();
		OutputStream os = new FileOutputStream(new File(path,user.getName()+".jpg"));
		byte[] buffer = new byte[400];
		int len=0;
		while((len=is.read(buffer))!=-1){
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
		String head = "upload/"+user.getName()+".jpg";
		user.setHead(head);
		boolean flag = userService.signin(user);
		return "redirect:/login.jsp";
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public PostServie getPostService() {
		return postService;
	}
	public void setPostService(PostServie postService) {
		this.postService = postService;
	}
	public ReplyService getReplyServie() {
		return replyServie;
	}
	public void setReplyServie(ReplyService replyServie) {
		this.replyServie = replyServie;
	}
	
}
