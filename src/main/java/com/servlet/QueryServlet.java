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
/**
 * 查询操作的瑟喔雷特
 */
@WebServlet(name = "QueryServlet", value = "/QueryServlet")
public class QueryServlet extends HttpServlet {
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
        //获取表单参数
        String QueryUserName=request.getParameter("UserName");
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取豆子user
        User user= (User) applicationContext.getBean("user");
        //为豆子赋值
        user.setUsername(QueryUserName);
        //获取豆子userDao
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        //调用方法
        user=userDao.QueryForName(user);
        if(user==null){
            out.print("没找到信息，检查你输入的用户姓名是否正确！");
        }
        else{
            out.print("用户姓名："+user.getUsername()+"用户密码："+user.getPassword());
        }
        doGet(request,response);

    }
}
