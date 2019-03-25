package snack.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import snack.model.snack;
import snack.service.snackservice;

@RestController
@RequestMapping("/api")
public class snackresource {
	private snackservice Snackservices;
	
	public snackresource (snackservice Snackservices)
	{
		this.Snackservices= Snackservices;
	}
	
@RequestMapping(value="snack",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)

public List<snack> getALLSnacks()
{
	return Snackservices.findall();
}

@RequestMapping(value="snack",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<snack> createsnack(@RequestBody snack Snack)throws URISyntaxException
{
	try
	{
		snack result= Snackservices.save(Snack);
		return ResponseEntity.created(new URI("/api/snack/"+ result.getId())).body(result);
	}catch(Exception e)
	{
		return new ResponseEntity<snack>(HttpStatus.CONFLICT);
	}
}
@RequestMapping(value="snack",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<snack> updatesnack(@RequestBody snack Snack)throws URISyntaxException
{
	if(Snack.getId() == 0)
	{
		return new ResponseEntity<snack>(HttpStatus.NOT_FOUND );
	}
	try
	{
		snack result= Snackservices.update(Snack);
		return ResponseEntity.created(new URI("/api/snack/"+ result.getId())).body(result);
	}catch(Exception e){
		return new ResponseEntity<snack>(HttpStatus.NOT_FOUND );
	}
	
	
}
@RequestMapping(value="/snack/{id",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> deletesnack(@PathVariable Integer id)
{
	Snackservices.delete(id);
	return ResponseEntity.ok().build()
;}

}
