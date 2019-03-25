package snack.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snack.model.snack;
import snack.repository.snackrepo;

@Service
public class snackservice {
	private snackrepo  snackrepository;

@Autowired
 public snackservice(snackrepo snackrepository)
{
	this.snackrepository = snackrepository;
}

public snack save(snack snacks)
{
	if(snacks.getId() != 0 && snackrepository.exists(snacks.getId()))
	{
		throw new EntityExistsException("There is already an entity with such id in database");
	}
	return snackrepository.save(snacks);
}

	public snack update(snack snacks)
	{
		if(snacks.getId() != 0 && snackrepository.exists(snacks.getId()))
		{
			throw new EntityExistsException("There is already an entity with such id in database");
		}
		return snackrepository.save(snacks);
	}
	public List<snack> findall()
	{
		return snackrepository.findAll();
	}
	
	public snack findOne(int id)
	{
		return snackrepository.findById(id).orElse(null);
	}
	
	public void delete(int id)
	{
		snackrepository.deleteById(id);
	}
}
