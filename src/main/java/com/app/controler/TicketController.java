package com.app.controler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.bind.TicketBindData;
import com.app.entity.TicketCategory;
import com.app.entity.TicketInfo;
import com.app.repo.TicketRepo;
import com.app.serviceimpl.TicketServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketServiceImpl service;
	
	@Autowired
	private TicketRepo repo;
	

	
@PostMapping(value="/saveticket") 
    
	public ResponseEntity<String> saveticket( @RequestBody TicketBindData ht)
	{
		   
		
	    	Integer tid = service.saveTicket(ht);
	    	
	    	System.out.println("5555555555555555555: "+tid);
		    
	        return new ResponseEntity<String>(String.valueOf(tid),HttpStatus.OK);
	    
			
	}



@PostMapping(value="/upload/{ticketId}", consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
public ResponseEntity<String> upload(@PathVariable("ticketId") String id,HttpServletRequest req)throws IOException
{   
	  String storageDirectoryPath = "D:\\Mytickets\\tickets";
	  
	  
	  //System.out.println("---------------- "+ fb" ===================");
	  
	int idnum = Integer.parseInt(id);
	  TicketInfo ticket = service.getTicket(idnum);
	                   
	                   
	    MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)req;
        Iterator<String> it=multipartRequest.getFileNames();
        
        MultipartFile file=multipartRequest.getFile(it.next());
        String fileName=file.getOriginalFilename();
        System.out.println("----------"+fileName+"--------------");
        
        

        
           ticket.setTicketfilename(fileName);

        
        
        Path storageDirectory = Paths.get(storageDirectoryPath);
        
        if(!Files.exists(storageDirectory)){ 
            
                Files.createDirectories(storageDirectory); //create the directory in the given storage directory path
            
        }

        Path destination = Paths.get(storageDirectory.toString() + "\\" + fileName);

      
          Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        
       System.gc();
        
           String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/getticketfile/")
	                .path(ticket.getTicketfilename())
	                .toUriString();
            
            
               ticket.setTicketstoredlocation(fileDownloadUri);
            
                repo.save(ticket);
        
        
        return new ResponseEntity<String>("success",HttpStatus.OK);

    
   
}




@GetMapping(
        value = "getticketfile/{ticketfileName:.+}",
        produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.ALL_VALUE, MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE}
)
public @ResponseBody byte[] getTicketFileInfo(@PathVariable(name = "ticketfileName") String fileName) throws IOException {
    return service.getTicketFile(fileName);
}



@GetMapping("/allTicketCategories")
public ResponseEntity<List<TicketCategory>> getTicketCategoryData()
{
	List<TicketCategory> mainTypeData = service.getMainTypeData();
//String subTypeData = service.getSubTypeData();
//String[] s= {mainTypeData, subTypeData};

return new ResponseEntity<List<TicketCategory>>(mainTypeData,HttpStatus.OK);

}







@GetMapping(value="/alltickets", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<TicketInfo>> showAllTickets() 
		{
			
			
			  
			
			List<TicketInfo> la = service.getAllTickets();
			
			return  new ResponseEntity<List<TicketInfo>>(la,HttpStatus.OK);
		}
		
		
		
		
@GetMapping(value="/getticket/{hrticketId}",  produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TicketInfo> showTicket(@PathVariable("hrticketId") Integer id)
				
	{
	              TicketInfo hrTicket = service.getTicket(id);
			    
			    return new ResponseEntity<TicketInfo>(hrTicket,HttpStatus.OK);
				
	}









@DeleteMapping(value="/deleteticket/{hrticketId}")
public ResponseEntity<String> deleteticket(
		@PathVariable("hrticketId") Integer id
		) 
{
	
		
		service.deleteTicket(id);
		

	
	
	return new ResponseEntity<String>("success",HttpStatus.OK);
}








@PutMapping(value="/updateticket/{hrticketId}", consumes={MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<String> updateticket(@RequestBody TicketInfo ht,@PathVariable("hrticketId") Integer id)
		
{
	
	                       
	
	service.updateTicket(ht);
	
	return new ResponseEntity<String>("success",HttpStatus.OK);
}
	
	
	
	
	
	
	
}
