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
@CrossOrigin("http://localhost:4200/")
public class userController {

	@Autowired
	private userService userService;
	
	@PostMapping("/user/upload")
	public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file){
		
		//delay given only to testing uploading message in frontend 
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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









//
//
//@RequestParam("file"):
//
//@RequestParam is used to extract the value of the "file" parameter from the request.
//The parameter value is expected to be part of the request URL (query parameter) or submitted as part of a form.
//In this case, it is used to extract the uploaded file from a form submission where the input field name is "file."
//MultipartFile file:
//
//The extracted parameter value (in this case, the uploaded file) is then bound to the method parameter file of type MultipartFile.
//MultipartFile is a Spring interface representing a file received in a multipart request. It provides methods to access information about the file, such as its name, size, content type, and the actual file content.
