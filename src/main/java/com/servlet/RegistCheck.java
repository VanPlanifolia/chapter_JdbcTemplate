package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Servlet implementation class RegistCheck
 */
@WebServlet("/RegistCheck")
public class RegistCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		int nub=0;
		//获取参数
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		String userPassCheck=request.getParameter("userPassCheck");
		//判断两次密码是否一致
		if(!userPass.equals(userPassCheck)){
			out.print("<p>两次的密码不相同请重新输入!</p><a href='regist.jsp'>返回注册</a>");
		}
		else{
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			//获取豆子user
			User user=(User) applicationContext.getBean("user");
			//为豆子user赋值
			user.setPassword(userPass);
			user.setUsername(userName);
			//获取豆子 userdao
			UserDao userdao=(UserDao) applicationContext.getBean("userDao");
			nub=userdao.Regist(user);
			if(nub!=0){
				out.print("<p>注册成功！"+user.getUsername()+"用户</p>"+"<a href='index.jsp'>登录？</a>");
			}
			else {
				out.print("<p>注册失败,请返回注册！</p>"+"<a href='regist.jsp'>注册？</a>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
