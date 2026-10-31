package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public int add(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();

		session.save(dto);

		return dto.getId();

	}

	public int update(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();

		session.update(dto);

		return dto.getId();

	}

	public int delete(int id) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = session.get(UserDTO.class, id);

		session.delete(dto);

		return id;

	}

	public UserDTO findById(int id) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = session.get(UserDTO.class, id);

		return dto;

	}

	public UserDTO findByLogin(String login) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = null;

		Criteria criteria = session.createCriteria(UserDTO.class);

		// and login = ?;
		criteria.add(Restrictions.eq("login", login));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);

		}

		return dto;

	}

	public UserDTO authenticate(String login, String password) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = null;

		Criteria criteria = session.createCriteria(UserDTO.class);

		// and login = ?;
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));

		List<UserDTO> list = criteria.list();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);

		}

		return dto;

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		Session session = sessionFactory.getCurrentSession();
		List<UserDTO> list = new ArrayList<UserDTO>();

		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
		}

		if (pageSize > 0) {
			// limit index, totalRecord;
			criteria.setFirstResult((pageNo - 1) * pageSize); // index
			criteria.setMaxResults(pageSize); // total number of records;
		}

		list = criteria.list();

		return list;

	}
}