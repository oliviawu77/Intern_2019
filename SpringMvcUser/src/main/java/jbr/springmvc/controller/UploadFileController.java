package jbr.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

import jbr.springmvc.dao.UserDaoImpl;
import jbr.springmvc.model.Employee;
import jbr.springmvc.service.UserService;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.poi.hssf.record.CellRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;

@Controller
public class UploadFileController{
	  @Autowired
	  public UserService userService;

	  //private static final String SAMPLE_CSV_FILE_PATH = "C:\\workspace_sts4\\SpringMvcUser\\WalkData.csv";
	  
	  @RequestMapping(value = "/upload", method = RequestMethod.GET)
	  public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) {
	    
		ModelAndView mav = new ModelAndView("uploadFile");
	    return mav;
	  }

	  @RequestMapping(value = "/uploadfileProcessing", method = RequestMethod.POST)
	  public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("Employee") Employee employee, @RequestParam("file") MultipartFile file,
			  HttpSession session){ 
		  		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		  		MultipartFile multipartFile = multipartRequest.getFile("file");
		  		String path = session.getServletContext().getRealPath("/");  
		  		System.out.println(file.getOriginalFilename());
		  	    String rootPath = request.getSession().getServletContext().getRealPath("/");
		  	    // 先讀入檔案
		  	    File dir = new File(rootPath + File.separator + "uploadedfile");
		  	    if (!dir.exists()) {
		  	        dir.mkdirs();
		  	    }
		  	  File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
		  	  System.out.println( dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
		  	  try {
		  		  InputStream is = file.getInputStream();
		  		  BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		            int i;
		            //write file to server
		            while ((i = is.read()) != -1) {
		                stream.write(i);
		            }
		            stream.flush();		  		  
		  	  }
		  	  	catch(Exception e) {
		  	  }
		  	  //處理csv檔案
		  	  try  {
			  int i = 0;
			  DataInputStream in = new DataInputStream(new FileInputStream(serverFile));
			  CSVReader reader = new CSVReader(new InputStreamReader(in,"UTF-8"));
			  String [] nextLine; 
			  while ((nextLine = reader.readNext()) != null) {
				  if (i == 0) //忽略header
				  {
					  i++;
					  continue;
				  }
			      // nextLine[] is an array of values ​​from the line 
			      //System.out.println(nextLine[0] +  "\t" + nextLine[1] +  "\t" + nextLine[2] + "\t" + nextLine[3] +  "\t" + nextLine[4] +  "\t" + nextLine[5] +  "\t" + nextLine[6] + "\n"); 
			      i++;
			      employee.setId(nextLine[0]);
			      employee.setJob_grade(nextLine[1]);
			      employee.setJob_position(nextLine[2]);
			      employee.setWork_shift(nextLine[3]);
			      employee.setExercise_date(nextLine[4]);
			      employee.setExercise_week(nextLine[5]);
			      employee.setStep(nextLine[6]);
			      userService.updateEmployee(employee);
			  }
			 }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        ModelAndView mav = new ModelAndView("uploadStatus");
		  mav.addObject("message", "Uploading..");
		  
		  return mav; 
	  }
	}