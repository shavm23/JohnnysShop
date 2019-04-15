package database;

import static org.junit.Assert.assertEquals;

import Entity.Request;
import org.junit.Test;

public class RequestDbTest extends RequestDB{
	
	@Test
	public void shouldAddToDatabase()
	{
		int deff = 1;
		Request cm = new Request(5612314,"cheese","civic","John Jones","2,3");
		RequestDB db = new RequestDB();
		int success = db.add(cm); 
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldGetItem()
	{
		Request cm = new Request(5612314,"cheese","civic","John Jones","2,3");
		int id = 111; 
		RequestDB db = new RequestDB();
		Request success = db.get(id);
		assertEquals(cm,success);
	}
	
	
	@Test
	public void shouldPrintObject()
	{
		Request pr = new Request(5612314,"cheese","civic","John Jones","2,3"); 
	
		Request Display = new Request();
		int vr;
		vr = Display.getstu_ID();
		System.out.println(vr);
	
	
		String mod_l;
		mod_l = Display.getsnack();
		System.out.println(mod_l);
	
		String loc;
		loc = Display.getLocation();
		System.out.println(loc);
	
		String name;
		name = Display.getName();
		System.out.println(name);
		
		String QTY;
		QTY = Display.getQty();
		System.out.println(QTY);

	}

}
