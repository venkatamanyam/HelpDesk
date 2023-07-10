package com.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.bind.ChangePasswordData;
import com.app.bind.ConfirmPasswordData;
import com.app.bind.Employee;
import com.app.bind.LoginRequest;
import com.app.bind.MailORuserIDinfo;
import com.app.bind.OTPinfo;
import com.app.entity.EmployeeInfo;
import com.app.serviceimpl.EmployeeServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	public String userId;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping(value="/users/signin") 
	
	   public ResponseEntity<String> getLoginRequest( @RequestBody LoginRequest credentials)
		{
		  
		  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		  
		  System.out.println(credentials.getUserId());
		  
		  System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		
	      Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUserId(), credentials.getUserPassword()));
			
		    if(authenticate.isAuthenticated())
		    {   
		    	EmployeeInfo demp = service.findByuserId(credentials.getUserId());
		    	            
		    	              String userPassword = demp.getUserPassword();
		    	              userId = demp.getUserId();
		    	              
		    	              System.out.println("-------------"+userPassword+"-----------------------");
		    	              System.out.println("-------------"+userId+"-----------------------");
		    	              service.getPwd(userPassword);
		    	              service.getUid(userId);
		    	              
		    	              
		    	System.out.println("hiiiiiiiiiiiiiiiiii ******************* hiiiiiiiiiiiiiiiiiii");
		        
		    	return new ResponseEntity<String>(demp.getUserName(),HttpStatus.OK);
		    }
		   
		    else
		    	
		    	return new ResponseEntity<String>("Invalid user",HttpStatus.BAD_REQUEST);
				
		}
	
	@PostMapping(value="/users/changepassword") 
	public ResponseEntity<String> changepwdRequest (@RequestBody ChangePasswordData changepwdinfo)
	{
		
		          boolean changePwddata = service.changePwddata(changepwdinfo);
		          
		          
		              if(changePwddata)   
		    		  {
		    		     return  new ResponseEntity<String>("success",HttpStatus.OK);
		    		  }
		    		  
		    		 else
		    		  {
		    			  return  new ResponseEntity<String>("failure",HttpStatus.BAD_REQUEST);
		    		  }
	}
	
	@PostMapping(value="/users/confirmpwd") 
	public ResponseEntity<String> confirmpwdRequest (@RequestBody ConfirmPasswordData confirmpwdinfo)
	{
		System.out.println("HHHHHHHHHH "+confirmpwdinfo+" KKKKKKKKKKKKKKKKKKKKKKK");
		
		System.out.println("$$$$$$$$$  "+confirmpwdinfo.getConfirmpassword()+"  GGGGGGGGGGGGGGGG      ");
		
		
		boolean confirmPwddata = service.confirmPwddata(confirmpwdinfo);
		System.out.println(confirmPwddata);
		 
		
		
		 if(confirmPwddata)   
		  {
		     return  new ResponseEntity<String>("success",HttpStatus.OK);
		  }
		 
		  
		 else
		  {
			  return  new ResponseEntity<String>("failure",HttpStatus.BAD_REQUEST);
		  }
		 
		 
		 
	}
	
	@PostMapping(value="/users/validatemailoruserid") 
	public ResponseEntity<String> mailORuserIDValidationRequest (@RequestBody MailORuserIDinfo data)
	{
		
		System.out.println("TTTTTTTTTT "+data.getMailidORuserId()+" ---------------");
		
		          boolean mailORuserIDCheck = service.mailORuserIDCheck(data);
		          
			         if(mailORuserIDCheck)
			         {
			        	 String empId = service.getEmpId();
			        	 String uid = empId.toString();
			     		return  new ResponseEntity<String>(uid,HttpStatus.OK);
			         }
			     		          else
			     		        	 return  new ResponseEntity<String>("failure",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value="/users/validateotp") 
	public ResponseEntity<String> otpValidationRequest (@RequestBody OTPinfo otpinfo)
	{
		//System.out.println(otpinfo);
		//System.out.println(otpinfo.getOtp());
		          boolean otpCheck = service.otpCheck(otpinfo);
		          //System.out.println("CCCCCCCCCCCCCC "+otpCheck+" kkkkkkkkkkkkkk");
		         if(otpCheck)
		return  new ResponseEntity<String>("success",HttpStatus.OK);
		          else
		        	 return  new ResponseEntity<String>("failure",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value="/users/save") 
	   public ResponseEntity<String> saveEmp( @RequestBody Employee emp)
		{
			   
			System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			System.out.println(emp.getUserorg());
			System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			
			
		    	String msg = service.saveUser(emp);
			    
		        return new ResponseEntity<String>(msg,HttpStatus.OK);
		    
				
		}
			
@GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_VALUE)
			

public ResponseEntity<List<EmployeeInfo>> showAllEmp() 
			{
				
				
				  
				
				List<EmployeeInfo> la = service.getAllEmployees();
				
				return  new ResponseEntity<List<EmployeeInfo>>(la,HttpStatus.OK);
			}


			
@GetMapping(value="/users/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeInfo> showEmp(@PathVariable("userId") String id)
					
		{      
	                     System.out.println("abc:  "+id);
	                     System.out.println("%%%%%%%%%%%%%%%%%%%:  ");
	
	
		              EmployeeInfo employee = service.getEmployee(id);
		              
		              System.out.println("%%%%%%%%%%%%%%%%%%%:  "+ employee);
		              
		              
				    
				    return new ResponseEntity<EmployeeInfo>(employee,HttpStatus.OK);
					
		}


@DeleteMapping(value="users/{userId}")
	public ResponseEntity<String> deleteEmp(
			@PathVariable("userId") String id
			) 
	{
		
			
			service.deleteEmployee(id);
			

		
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}








	@PutMapping(value="/users/{userId}", consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> updateEmp(@RequestBody EmployeeInfo employee,@PathVariable("userId") String id)
			
	{
		                  
		
	    service.updateEmployee(employee);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

}
