package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.user;
import com.example.demo.Service.userService;
import com.example.demo.helper.userHelper;

@RestController
@CrossOrigin("*")
public class userController {

	@Autowired
	private userService userService;
	
	@PostMapping("/user/upload")
	public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
		
		if (userHelper.checkExcelFormat(file)) {
			
			this.userService.save(file);
			
			return ResponseEntity.ok(Map.of("message","file is uploaded"));
			
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid File Format");
		
		
	}
	@GetMapping("/user")
	public List<user> getAllUsers(){
		return this.userService.getAllUSers();
	}
}
