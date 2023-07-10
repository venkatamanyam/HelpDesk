package com.app.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.bind.ChangePasswordData;
import com.app.bind.ConfirmPasswordData;
import com.app.bind.Employee;
import com.app.bind.MailORuserIDinfo;
import com.app.bind.OTPinfo;
import com.app.entity.EmployeeInfo;
import com.app.repo.EmployeeRepository;
import com.app.utils.EmailUtils;



@Service
public class EmployeeServiceImpl implements UserDetailsService{

	@Autowired
	private EmployeeRepository erepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private EmailUtils emailUtils;
	
	private  String uid;
	private  Integer otp;
	private  String pw;
	
	private EmployeeInfo emp;
	
public String saveUser(Employee user) {
		
	String msg="";
	
	
	EmployeeInfo empl = erepo.findByuserId(user.getUserId());
	
	 if(empl==null)
		{
		 System.out.println("ooooooooooooooooooooooooo");
		 System.out.println(user.getUserorg());
		 System.out.println("ooooooooooooooooooooooooo");
		 
			EmployeeInfo emp=new EmployeeInfo();
		
		    BeanUtils.copyProperties(user, emp);
		    
		    String pwd = encoder.encode(emp.getUserPassword());
		    
		    emp.setUserPassword(pwd);
		
		    erepo.save(emp);
		    
		   return  msg="success";
		   
		}
	  
	   return msg="Employee Existed";
		
		
		  
	}


public EmployeeInfo getEmployee(String id) {
	
EmployeeInfo demp = erepo.findByuserId(id);
System.out.println("---------**********");

System.out.println(demp);

System.out.println("---------**********");


return demp;


}




public EmployeeInfo findByuserId(String userId) {
	return erepo.findByuserId(userId);
}

@Override
public UserDetails loadUserByUsername(String userId)
		throws UsernameNotFoundException {

	System.out.println("#############################");
	System.out.println("value is: "+userId);
	System.out.println("###############################");
	EmployeeInfo opt = findByuserId(userId);
	System.out.println("hiiiiiii");
//	if(!opt.isPresent()) {
//		
//		System.out.println("hhhhhhhhhhhhhh");
//		throw new UsernameNotFoundException(userId + " not exist");
//	} 
	
	System.out.println("------------------------");
	EmployeeInfo user = opt;
	System.out.println(user.getUserEmail());
	System.out.println("------------------------");
	return new org.springframework.security.core.userdetails.User(
			user.getUserEmail(), 
			user.getUserPassword(), 
			Arrays.stream(user.getUserRole().split(","))
			.map(SimpleGrantedAuthority::new)
			.collect(Collectors.toSet())
			);
}



public List<EmployeeInfo> getAllEmployees() {
	List<EmployeeInfo> list = erepo.findAll();
	return list;
}

public String deleteEmployee(String id) {
	
	String msg="";
	EmployeeInfo deptemp= erepo.findByuserId(id);
	 
	      erepo.delete(deptemp);
	      
	      return msg="success";
	      
	      
	
	
}



public void updateEmployee( EmployeeInfo e) {
	
	
	EmployeeInfo emp = erepo.findByuserId(e.getUserId());
	
	Integer pki = emp.getPk();
	
	BeanUtils.copyProperties(e, emp);
	
	emp.setPk(pki);
		erepo.save(emp);
	
		
}

public void getPwd(String pwd) 
{
	
	 pw=pwd;

}


public  void getUid(String userId) {
uid=userId;	
System.out.println("&&&&&&&&"+uid+"&&&&&&&&&&&");
}


public boolean changePwddata(ChangePasswordData changepwdinfo) {
	
	String oldpwd= changepwdinfo.getOldpassword();
	String newpwd = changepwdinfo.getNewpassword();
	
	
	
	
	     EmployeeInfo demp = erepo.findByuserId(uid);
	     
	     String upw = demp.getUserPassword();
	    
	     boolean b = encoder.matches(oldpwd, upw);
	     
	                  System.out.println("*********  "+b+"  pppppppppppppp");
	     
	    // System.out.println("$$$$$$$ "+pwd+" &&&&");
	     
	     //System.out.println("***************"+demp+"********************");
	     
	     //System.out.println("----------"+pw+"--------------");
	                  
	               if(b)
	               {
	            	   demp.setUserPassword(encoder.encode(newpwd));
	            	   erepo.save(demp);
	            	   return true;
	               }
	                  
	     return false;
	
	}


public boolean confirmPwddata(ConfirmPasswordData confirmpwdinfo) {
	
	String confirmpwd= confirmpwdinfo.getConfirmpassword();
	String newpwd = confirmpwdinfo.getNewpassword();
	
	
	
	if(confirmpwd.equalsIgnoreCase(newpwd))
		{
		emp.setUserPassword(encoder.encode(newpwd));
		EmployeeInfo e = erepo.save(emp);
		System.out.println(e);
		return true;
		}
	
	else {return false;}
	
	
	
}


public boolean mailORuserIDCheck(MailORuserIDinfo data) {
	
	String input = data.getMailidORuserId();
	
	if(input.endsWith("@gmail.com"))
	
	emp = erepo.findByUserEmail(input).get();
	
	else
		
		emp = erepo.findByuserId(data.getMailidORuserId());
	

	
	
	//System.out.println("%%%%%%%%%%%%%%% "+deptempl+"  *******************");
	
	if(emp!=null)
	{
		
		
			String subject = "OTP  For Reset  Password";
			String body = "OTP ---> "+generateOTP();
			emailUtils.sendEmail(emp.getUserEmail(), subject, body);
		    return true;	
		
	}
	return false;
	
}

public String getEmpId()
{
	
	return emp.getUserId();


}


public Integer generateOTP() {
	 Random rd = new Random(); 
	 
     otp = rd.nextInt(10000);
     return otp;
     
}


public boolean otpCheck(OTPinfo otpinfo) {
	
	//System.out.println("zzzzzzz "+otpinfo.getOtp()+"  qqqqqqqqqqq  "+otp);
	
	int otpnum =otpinfo.getOtp();
	
	if(otpnum==otp)
	{
		return true;

	}
	
	else
	{
		return false;
	
	}
	
}



	

	
	
}
