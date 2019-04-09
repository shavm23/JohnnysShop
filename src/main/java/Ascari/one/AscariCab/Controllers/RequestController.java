package Ascari.one.AscariCab.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Request;
import Exceptions.ResourceNotFound.ResourceNotFoundException;
import database.RequestDB;


@RestController
@RequestMapping("/api/request/")

public class RequestController {

RequestDB requestDB = new RequestDB();
Logger logger = LogManager.getLogger(RequestController.class);

@GetMapping("/all")
public List<Request> getAll()
{
	return requestDB.selectAll();			
}                           
                           
@PostMapping("/add")           
public Request create(@Valid @RequestBody Request item )
{             
	 requestDB.add(item);
	 return item;
}                          



@GetMapping("/{id}")
public Request get(@PathVariable(value="id") int id) 
{
	Request item = new Request();	
	
	item = requestDB.get(id);	 
	try 
	{		
		if (item != null )	
		{
			logger.info("item exits");				
		}	
		return item;
		
	}
catch(ResourceNotFoundException e ) 
	{
	e.printStackTrace();
	return null;
	}
}

/*
@PutMapping("/{id}")
public Request update(@PathVariable(value = "id") int id,@Valid @RequestBody Request details) 
{

	Request request = RequestDB.get(id);	
	try
	{		
		 if (request != null)
		 {
			 request.setC_number(details.getC_number());			
			 request.setLocation(details.getLocation());
			 request.setDestination(details.getDestination());
			 request.setC_id(details.getC_id());
			 request.setFare(details.getFare());
			 request.setReq_id(details.getReq_id());
			 request.setDistance(details.getDistance());
			 			
			 RequestDB.add(request);			 
		 }	 
			return request; 
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}
 
}
*/


@PutMapping("/{id}")
public Request update(@PathVariable(value = "id") int id,@Valid @RequestBody Request details) 
{
	
	try
	{				
		requestDB.update(details, id);			
		return details;
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}

}



@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
	Request request = requestDB.get(id);
           
			try
			{				
				 if (request != null)
				 {
					 requestDB.delete(id);
				 }
				  return ResponseEntity.ok().build();
			}
	catch(ResourceNotFoundException e )
	{
		e.printStackTrace();
		return null;
	}
  
}

}
