package com.example.demo.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.user;
import com.example.demo.Repository.userRepository;
import com.example.demo.helper.userHelper;

@Service
public class userService {

	@Autowired
	private userRepository userRepository;
	
	public void save (MultipartFile file) {
		
//		The getInputStream() method is used to obtain 
//				an InputStream that represents the contents of the uploaded file.
		
		try{
		List<user> user = 	userHelper.convertToList(file.getInputStream());
		this.userRepository.saveAll(user);
		
		}catch(IOException e){
			
			e.printStackTrace();
			
			
		}
	}
	
	public List<user> getAllUSers (){
		return this.userRepository.findAll();
	}
	
	public ByteArrayInputStream getData() throws IOException {
		List<user> all = userRepository.findAll();
		ByteArrayInputStream byteArrayInputStream = userHelper.dataToExcel(all);
		return byteArrayInputStream;
	}
}
