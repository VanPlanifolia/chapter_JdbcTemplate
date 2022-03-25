package com.dao;

import com.bean.User;

import java.util.List;

public interface UserDao {
	public int Regist(User user);
	public User login(User user);
	public User QueryForName(User user);
	public List<User> FindAllUser();
	public int DeleteForId(int id);
	public int AddUser(User user1,User user2)throws Exception;
}
