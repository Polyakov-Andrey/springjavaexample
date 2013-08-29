package com.epam.springmvcexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.springmvcexample.dao.UserDAO;
import com.epam.springmvcexample.persistence.User;

@Service
public class UserService {
	@Autowired
	UserDAO dao;
	

	  public List<User> getUsers() {
	    return (List) dao.findAll();
	  }
	  
}
