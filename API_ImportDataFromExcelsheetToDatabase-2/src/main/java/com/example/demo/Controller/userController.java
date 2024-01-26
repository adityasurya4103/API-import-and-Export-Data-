package com.example.demo.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

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
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/user")
	public List<user> getAllUsers(){
		return this.userService.getAllUSers();
	}
	
	@GetMapping("/excel") 
	public ResponseEntity<Resource> download() throws IOException{
		
		String filename = "users.xlsx";
		
		// // Retrieve user data as an InputStream
		ByteArrayInputStream byteArrayInputStream = userService.getData();
		
		
		// Wrap the InputStream in an InputStreamResource . 
		//This is done to create a Resource object that can be used in the ResponseEntity
		InputStreamResource file = new InputStreamResource(byteArrayInputStream);
		
		ResponseEntity<Resource> body = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename = "+filename)
		.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
		
		
		// Content-Disposition header is used to suggest a default filename for the downloaded file.
		// it suggests that the browser should treat the response as an attachment (attachment;) and provides the suggested filename (filename=users.xlsx).
		// Content-Type header specifies the media type of the resource being sent.
		// In this case, it specifies that the content is of type "application/vnd.ms-excel," indicating that the response contains Excel file data.
		return body;
	
	}
}








//@RequestParam("file"):
//
//@RequestParam is used to extract the value of the "file" parameter from the request.
//The parameter value is expected to be part of the request URL (query parameter) or submitted as part of a form.
//In this case, it is used to extract the uploaded file from a form submission where the input field name is "file."
//MultipartFile file:
//
//The extracted parameter value (in this case, the uploaded file) is then bound to the method parameter file of type MultipartFile.
//MultipartFile is a Spring interface representing a file received in a multipart request. It provides methods to access information about the file, such as its name, size, content type, and the actual file content.
