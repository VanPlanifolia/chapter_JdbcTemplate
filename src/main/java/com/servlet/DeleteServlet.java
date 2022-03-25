package com.servlet;

import com.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
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
        //获取参数
        int id= Integer.parseInt(request.getParameter("DelUserId"));
        //加载斯普林文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取UserDao对象
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        if(userDao.DeleteForId(id)!=0){
            out.print("id为"+id+"的用户删除成功！,即将跳转到主页！"+"<script>window.location.href='index.jsp'</script>");
        }else {
            out.print("删除失败，检查是否有该用户！");
        }



        doGet(request,response);

    }
}
