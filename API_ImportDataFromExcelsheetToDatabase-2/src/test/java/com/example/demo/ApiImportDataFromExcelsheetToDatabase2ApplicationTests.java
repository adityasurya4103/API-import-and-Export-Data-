package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.userRepository;

@SpringBootTest
class ApiImportDataFromExcelsheetToDatabase2ApplicationTests {
	
	@Autowired
	private userRepository userRepository;

	@Test
	void contextLoads() {
	}
	

	@Test
	public void testUserRepo() {
		
		System.out.println("Test started");
		
		userRepository.findAll().forEach(u->System.out.println(u.getContactNo()));
		
		
	}

}
