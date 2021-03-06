package com.ordering.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordering.dao.UserDao;
import com.ordering.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(User user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void edit(User user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void delete(String username) {		
		session.getCurrentSession().delete(getUser(username));
	}

	@Override
	public User getUser(String username) {
		return (User)session.getCurrentSession().get(User.class, username);
	}

	@Override
	public List getAllUser() {
		return session.getCurrentSession().createQuery("from User").list();
	}

}
