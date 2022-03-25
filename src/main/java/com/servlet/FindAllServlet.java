package com.servlet;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FindAllServlet", value = "/FindAllServlet")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        //获得查询到的信息
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        if(userDao.FindAllUser().size()==0){
            out.print("目前没有任何记录！");
            out.print("<br>");
        }
        for(User user: userDao.FindAllUser()){
            out.print("用户id:"+user.getId()+" 用户姓名:"+user.getUsername()+" 用户密码:"+user.getPassword());
            out.print("<br>");
        }
        out.print("请输入你要删除的用户id"+"<br>");
        out.println("  <form action=\"DeleteServlet\" method=\"post\">" +
                "    <input type=\"text\" name=\"DelUserId\">\n" +
                "    <input type=\"submit\" value=\"删除\">\n" +
                "  </form>");

        doGet(request,response);
    }
}
