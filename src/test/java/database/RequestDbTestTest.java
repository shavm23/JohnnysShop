package database;

import static org.junit.Assert.*;

import org.junit.Test;

import Entity.Request;


public class RequestDbTestTest extends RequestDB{
	
	@Test
	public void shouldAddToDatabase()
	{
		int deff = 1;
		Request cm = new Request(0,"cheese","a","John Jones","q","3","1",3);
		RequestDB db = new RequestDB();
		int success = db.add(cm); 
		assertEquals(deff,success,0);
	}
	
	@Test
	public void shouldGetItem()
	{
		Request cm = new Request(0,"cheese","a","John Jones","q","3","2",3);
		int id = 111; 
		RequestDB db = new RequestDB();
		Request success = db.get(id);
		assertEquals(cm,success);
	}
	
	
	@Test
	public void shouldPrintObject()
	{
		Request pr = new Request(0,"cheese","a","John Jones","q","3","",3); 
	
		Request Display = new Request();
		int vr;
		vr = Display.getStu_ID();
		System.out.println(vr);
	
	
		String mod_l;
		mod_l = Display.getSnack();
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


