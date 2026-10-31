package com.rays.test;

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

		TestUser test = context.getBean(TestUser.class);

//		test.add();
//      test.update();

//		test.delete();
//		test.findById();
//		test.findByLogin();
//		test.authenticate();
		test.search();
	}

	public void add() {

		UserDTO dto = new UserDTO();

		dto.setId(2);
		dto.setFirstName("ahsdhb");
		dto.setLastName("sndcbkd");
		dto.setLogin("hy");
		dto.setPassword("123");

		int id = service.add(dto);

		System.out.println("Added ID: " + id);
		System.out.println("Record Added");
	}

	public void update() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Tanisha Updated");
		dto.setLastName("Rambadia");
		dto.setLogin("tanisha");
		dto.setPassword("123");

		service.update(dto);

		System.out.println("Record Updated");
	}

	public void delete() {

		service.delete(3);

		System.out.println("Record Deleted");
	}

	public void findById() {

		UserDTO dto = service.findById(1);

		System.out.println("ID: " + dto.getId());
		System.out.println("First Name: " + dto.getFirstName());
		System.out.println("Last Name: " + dto.getLastName());
		System.out.println("Login: " + dto.getLogin());
		System.out.println("Password: " + dto.getPassword());

	}

	public void findByLogin() {

		UserDTO dto = service.findByLogin("tanisha");

		System.out.println("ID: " + dto.getId());
		System.out.println("First Name: " + dto.getFirstName());
		System.out.println("Last Name: " + dto.getLastName());
		System.out.println("Login: " + dto.getLogin());
		System.out.println("Password: " + dto.getPassword());

	}

	public void authenticate() {

		UserDTO dto = service.authenticate("h", "123");

		if (dto != null) {
			System.out.println("Authentication Successful");
		} else {
			System.out.println("Authentication Failed");
		}

		System.out.println("ID: " + dto.getId());
		System.out.println("First Name: " + dto.getFirstName());
		System.out.println("Last Name: " + dto.getLastName());
		System.out.println("Login: " + dto.getLogin());
		System.out.println("Password: " + dto.getPassword());

	}

	public void search() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("ahsdhb");

		for (UserDTO user : service.search(dto, 0, 0)) {
			System.out.println("ID: " + user.getId());
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Login: " + user.getLogin());
			System.out.println("Password: " + user.getPassword());
			System.out.println("-----------------------------");
		}

	}

}