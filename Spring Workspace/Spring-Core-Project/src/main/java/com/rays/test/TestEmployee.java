package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestEmployee {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("employee.xml"));

		Employee p = factory.getBean("employee", Employee.class);

		System.out.println(p.getEmployeeName());
		System.out.println(p.getEmployeeSalary());
	}
	
}
