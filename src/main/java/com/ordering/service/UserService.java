package com.ordering.service;

import java.util.List;

import com.ordering.model.User;

public interface UserService {
	public void add(User user);
	public void edit(User user);
	public void delete(String username);
	public User getUser(String username);
	public List getAllUser();
}
