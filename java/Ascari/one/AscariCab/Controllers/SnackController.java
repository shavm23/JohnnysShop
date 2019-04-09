package Ascari.one.AscariCab.Controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import database.SnackDb;
import Entity.Snack;
import Exceptions.ResourceNotFound.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/Snack")
public class SnackController {

Logger logger = LogManager.getLogger(SnackController.class);

SnackDb Snackdb = new SnackDb();


@GetMapping("/all")
public List<Snack> getAll()
{
	return Snackdb.selectAll();			
}                           
                           
@PostMapping("/add")           
public Snack create(@Valid @RequestBody Snack item )
{             
	 Snackdb.add(item);
	 return item;
}                          



@GetMapping("/{id}")
public Snack get(@PathVariable(value="id") int id) 
{
	Snack item = new Snack();	
	
	item = Snackdb.get(id);	 
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


@PutMapping("/{id}")
public Snack update(@PathVariable(value = "id") int id,@Valid @RequestBody Snack details) 
{

	Snack Snack = Snackdb.get(id);	
	
	try
	{		
		 if (Snack != null)
		 {
			 Snack.setName(details.getName());
			 Snack.setPrice(details.getPrice());
			 Snack.setQTY(details.getQTY());
			 			 
			
			 Snack.setAVL(details.isAVL());			 
			 Snackdb.add(Snack);			 
		 }	 
			return Snack;  
	}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}

}


@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
	Snack Snack = Snackdb.get(id);
           
			try
			{				
				 if (Snack != null)
				 {
					 Snackdb.delete(id);
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
