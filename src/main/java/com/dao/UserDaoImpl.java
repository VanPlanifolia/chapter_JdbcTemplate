package com.dao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.User;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemlate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemlate){
		this.jdbcTemlate=jdbcTemlate;
	}
	@Override
	@Transactional
	public int Regist(User user) {
		// TODO Auto-generated method stub
		//定义sql
		String SqlForRegist="insert into user(username,password) values(?,?)";
		//定义数组来保存需要复制的参数
		Object [] object=new Object[]{
				user.getUsername(),
				user.getPassword()
		};
		int nub=this.jdbcTemlate.update(SqlForRegist,object);
		System.out.println(nub);
		return nub;
	}

	@Override
	public User login(User user) {
		//定义sql
		String SqlForLogin="select username from user where username=? and password=? ";
		//定义数组来保存需要复制的参数
		Object [] object=new Object[]{
				user.getUsername(),
				user.getPassword()
		};
		//创建rowMap实现对数据库的映射
		RowMapper<User>rowMapper=new BeanPropertyRowMapper<User>(User.class);
		//为问号赋值并且执行sql查询
		User user1;
		//当查找不到并且报错时候证明本次查询没查到或者查到多行数据则通过异常返回null
		try{
			user1=this.jdbcTemlate.queryForObject(SqlForLogin, rowMapper,object);
			System.out.println("u1:"+user1.getUsername());
		}catch (Exception e){
			return null;
		}
		//但是当正好查到一行时就返回查到的这个对象
		return user1;
	}

	@Override
	public User QueryForName(User user) {
		//定义sql
		String SqlForQuery="select * from user where username=?";
		//创建rowMap实现对数据库的映射
		RowMapper<User>rowMapper=new BeanPropertyRowMapper<User>(User.class);
		User user1;
		try{
			user1=this.jdbcTemlate.queryForObject(SqlForQuery,rowMapper,user.getUsername());
		}catch (Exception e){
			return null;
		}
		return user1;
	}
	@Override
	public List<User> FindAllUser(){
		//定义sql
		String SqlForFindAll="select * from user";
		//创建映射
		RowMapper<User>rowMapper=new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemlate.query(SqlForFindAll,rowMapper);

	}

	@Override
	public int DeleteForId(int id) {
		//定义sql
		String SqlForDeleteId="delete from user where id=?";
		//执行sql
		return this.jdbcTemlate.update(SqlForDeleteId,id);
	}
@Transactional
	@Override
	public int AddUser(User user1, User user2) {
		this.Regist(user1);
		int i=1/0;
		this.Regist(user2);
		return 0;
	}
}
