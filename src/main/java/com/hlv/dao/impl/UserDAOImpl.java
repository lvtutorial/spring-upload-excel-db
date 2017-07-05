package com.hlv.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import com.hlv.dao.UserDAO;
import com.hlv.entity.Users;

@Repository
public class UserDAOImpl extends GenericDAOImpl<Users, Long> implements UserDAO {

	// private static final Logger logger =
	// LoggerFactory.getLogger(UserDAOImpl.class);

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * @Autowired public void setSessionFactory(SessionFactory sf){
	 * this.sessionFactory = sf; }
	 */

	@Override
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
		
	@Override
	public void addUser(Users p) {
		// Session session = this.getSessionFactory().getCurrentSession();
		// session.persist(p);
		//has not solution for 2 case in here ????????????????
		//this.save(p); //should not use save in insert, so if exists id then insert become update	
		this._persist(p);  //if use _persist: when create new user and has roles then error, so at that time id null and can not reference in user_role table
		// logger.info("Users saved successfully, Users Details="+p);
	}

	@Override
	public void updateUser(Users p) {
		// Session session = this.getSessionFactory().getCurrentSession();
		// session.update(p);
		//this.save(p);
		this._update(p);  //should not use save in update, so if not exists id then update become to insert
		// logger.info("Users updated successfully, Users Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listUsers() {
		// Session session = this.getSessionFactory().getCurrentSession();
		// List<Users> UserssList =
		// session.createQuery("from Users order by id desc").list();
		// return UserssList;
		return findAll();
	}
}
