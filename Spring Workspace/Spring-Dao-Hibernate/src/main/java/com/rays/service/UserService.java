package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int add(UserDTO dto) {

		return dao.add(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int update(UserDTO dto) {

		return dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(int id) {

		return dao.delete(id);

	}

	public UserDTO findById(int id) {

		return dao.findById(id);
	}

	public UserDTO findByLogin(String login) {

		return dao.findByLogin(login);
	}

	public UserDTO authenticate(String login, String password) {

		return dao.authenticate(login, password);

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
}