package cn.sxt.loginInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse resp, Object handler) throws Exception {
		System.out.println("��¼������ִ����");
		req.setCharacterEncoding("utf-8");
		//�ж������ַ�Ƿ�Ϊ��¼��ַ
		String uri = req.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		if(uri.equals("login.do")){
			return true;
		}
		if(uri.equals("signin.do")){
			return true;
		}
		//�жϵ�ǰsession ���Ƿ���name
		if(req.getSession().getAttribute("currentUser") != null){
			return true;
		}
		String path = req.getContextPath();
		resp.sendRedirect(path+"/login.jsp");
		
		return false;
	}

	
}
