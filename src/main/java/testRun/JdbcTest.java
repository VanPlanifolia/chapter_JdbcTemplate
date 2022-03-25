package testRun;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        User user1= (User) applicationContext.getBean("user");
        User user2= (User) applicationContext.getBean("user");
        user1.setUsername("123");
        user1.setPassword("123");
        user2.setUsername("234");
        user2.setUsername("234");
        try {
            userDao.AddUser(user1,user2);
        } catch (Exception e) {
            System.out.println("被除数不能为0！");
        }
    }
}
