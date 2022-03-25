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
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		//获取参数
		String name=request.getParameter("userName");
		String pass=request.getParameter("userPass");
		//加载配置文件
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取bean user
		User user=(User) applicationContext.getBean("user");
		//为bean user赋值
		user.setUsername(name);
		user.setPassword(pass);
		//获取bean userdao
		UserDao userdao=(UserDao) applicationContext.getBean("userDao");
		//判断查询结果

		if(userdao.login(user)==null){
			out.print("登录失败！请输入正确的账号与密码！"+"<a href='index.jsp'>返回？</a>");
		}else{
			out.print("<p>用户"+user.getUsername()+"登陆成功</p>");
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
