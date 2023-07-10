package com.app.serviceimpl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bind.TicketBindData;
import com.app.controler.EmployeeController;
import com.app.entity.TicketCategory;
import com.app.entity.TicketInfo;
import com.app.exception.EmployeeNotFoundException;
import com.app.repo.TicketCategoryRepo;
import com.app.repo.TicketRepo;


@Service
public class TicketServiceImpl {

	
	@Autowired
	private TicketRepo repo;
	
	@Autowired
	private TicketCategoryRepo tcrepo;
	@Autowired
	private EmployeeController ec;
	
	
	public final String storageDirectoryPath = "D:\\Mytickets\\tickets";
	
public Integer saveTicket(TicketBindData td) {
		
		
	TicketInfo ti = new TicketInfo();
	
	
	BeanUtils.copyProperties(td, ti);
	
	
	String tid="";
    
    for(int i=1;i<=4;i++)
    {
    	tid+=(int)(Math.random()*10);
    	
    	
    
    }   
    
    ti.setTicketId(Integer.parseInt(tid));
    
    ti.setStatus("OPEN");
    
    ti.setTicketcreatedbyuid(ec.userId);
	
    ti.setAssignedtouid(302);
    
   
	
    TicketInfo tc = repo.save(ti);
	  
	  
	  
		return tc.getTicketId();
	}



public  byte[] getTicketFile(String ticketfileName) throws IOException {
    
	Path destination =   Paths.get(storageDirectoryPath+"\\"+ticketfileName);// retrieve the image by its name
    
    return IOUtils.toByteArray(destination.toUri());
}



public List<TicketCategory> getMainTypeData() 
{
	
List<TicketCategory> l = tcrepo.findAll();

return l;


}









public TicketInfo getTicket(Integer id) {
	
	return repo.findByticketId(id);
}


public List<TicketInfo> getAllTickets() {
	List<TicketInfo> list = repo.findAll();
	return list;
}

public void deleteTicket(Integer id) {
	
	repo.delete(getTicket(id));
}



public void updateTicket(TicketInfo tinfo) {
	
	if(tinfo.getTicketId()!=null && repo.existsById(tinfo.getTicketId()))
		repo.save(tinfo);
	else 
		throw new EmployeeNotFoundException("EMPLOYEE '"+tinfo.getTicketId()+"' NOT EXIST");
}
}
