package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("test")
public class TestUser {

	@Autowired
	private UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("test", TestUser.class);

//		test.testAdd();
//		test.testUpdate();
//		test.testDelete();
//		test.testfindByPk();
//		test.testfindByLogin();
//		test.authenticate();
		test.testSearch();

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();
//		dto.setId(1);
		dto.setFirstName("Tanisha");
		dto.setLastName("Rambadia");
		dto.setLogin("t@gmail.com");
		dto.setPassword("123");

		int id = service.add(dto);

		System.out.println("data inserted successfully: " + id);
	}

	private void testUpdate() {

		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Utkarsh");
		dto.setLastName("Rambadia");
		dto.setLogin("u@gmail.com");
		dto.setPassword("123");

		service.update(dto);

	}

	private void testDelete() {

		service.delete(2);

	}

	private void testfindByPk() {

		UserDTO dto = service.findByPk(1);

		System.out.println("ID: " + dto.getId());
		System.out.println("First Name: " + dto.getFirstName());
		System.out.println("Last Name: " + dto.getLastName());
		System.out.println("Login: " + dto.getLogin());
		System.out.println("Password: " + dto.getPassword());

	}

	private void testfindByLogin() {

		UserDTO dto = service.findByLogin("t@gmail.com");

		System.out.println("ID: " + dto.getId());
		System.out.println("First Name: " + dto.getFirstName());
		System.out.println("Last Name: " + dto.getLastName());
		System.out.println("Login: " + dto.getLogin());
		System.out.println("Password: " + dto.getPassword());

	}

	private void authenticate() {

		UserDTO dto = service.authenticate("u@gmail.com", "123");

		System.out.println("ID: " + dto.getId());
		System.out.println("First Name: " + dto.getFirstName());
		System.out.println("Last Name: " + dto.getLastName());
		System.out.println("Login: " + dto.getLogin());
		System.out.println("Password: " + dto.getPassword());
	}

	private void testSearch() {

		UserDTO dto = new UserDTO();
		dto.setFirstName("U");

		List<UserDTO> list = service.search(dto, 1, 10);

		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {

			UserDTO user = it.next();

			System.out.println("ID: " + user.getId());
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Login: " + user.getLogin());
			System.out.println("Password: " + user.getPassword());

			System.out.println("--------------------");
		}
	}
}
