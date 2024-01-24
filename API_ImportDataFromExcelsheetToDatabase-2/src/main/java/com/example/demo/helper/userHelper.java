package com.example.demo.helper;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.user;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;


public class userHelper {

	
		// checking the type of the file: whether the uploaded file is an excel File ?
		public static boolean checkExcelFormat(MultipartFile file) {
			
			String contentType= file.getContentType();
			
			if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				return true;
			}
			else {
				return false;
			}
		
		}
		
		
		// converting into a list from Excel 
		
		public static List<user> convertToList(InputStream input){ 
			
			List <user> list = new ArrayList<>();
			
			try {
				
				
				// here workbook is whole excel 
				 XSSFWorkbook workbook = new XSSFWorkbook(input);
				 
				 // getting the particular sheet from excel (excel contains number of sheets) 
		            XSSFSheet sheet = workbook.getSheet("data");
		            
		            int rowNumber = 0;
		            Iterator<Row> iterator = sheet.iterator();

		            while (iterator.hasNext()) {
		                Row row = iterator.next();

		                if (rowNumber == 0) {
		                    rowNumber++;
		                    continue;
		                }

		                Iterator<Cell> cells = row.iterator();

		                int cid = 0;

		                user u = new user();

		                while (cells.hasNext()) {
		                    Cell cell = cells.next();

		                    switch (cid) {
		                    	case 0:
		                    		u.setContactNo((long) cell.getNumericCellValue());
		                    		break;
	                        
		                    
		                    	case 1:
		                            u.setAccountNo(cell.getStringCellValue());
		                            break;
		                        case 2:
		                            u.setUserName(cell.getStringCellValue());
		                            break;
		                        case 3:
		                            u.setDebitCardNo(cell.getStringCellValue());
		                            break;
		                        case 4:
		                            u.setAccountType(cell.getStringCellValue());
		                            break;
			                    case 5:
			                    	 Date dateValue = cell.getDateCellValue();

			                         // Convert java.util.Date to java.time.LocalDate
			                         LocalDate localDate = dateValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			                         u.setExpiryDate(localDate);
			                        break;		                        
		                        default:
		                            break;
		                    }
		                    cid++;

		                }

		                list.add(u);
		                workbook.close();

				
		            }} catch (Exception exception) {
				exception.printStackTrace();
			}
			
			
				
			
			return list;
			
			
		}

}
