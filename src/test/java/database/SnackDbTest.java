package database;

import static org.junit.Assert.*;

import org.junit.Test;

import Entity.Snack;

public class SnackDbTest extends SnackDb {
	
	@Test
	public void shouldAddToDatabase()
	{
		int deff = 1;
		Snack cm = new Snack(1652323, "Cheetos", true, 50, 1,"cheetos.img");
		SnackDb db = new SnackDb();
		int success = db.add(cm);
		assertEquals(deff,success,0);
		
	}
	
	@Test
	public void ShouldGetItem()
	{
		Snack cm = new Snack(1652323, "Cheetos", true, 50, 1,"cheetos.img");
		int id = 111;
		SnackDb db = new SnackDb();
		Snack success = db.get(id);
		assertEquals(cm,success);
	}
	
	@Test
	public void shouldPrintObject()
	{
		Snack pr = new Snack(1652324,"cheetos",true,50,1, "cheetos.img"); 
		Snack Display = new Snack();
		int vr;
		vr = Display.getID();
		System.out.println(vr);
		
		
		String mod_l;
		mod_l = Display.getName();
		System.out.println(mod_l);
		
		boolean ava;
		ava = Display.isAVL();
		System.out.println(ava);
		
		int price;
		price = Display.getPrice();
		System.out.println(price);
		
		int qty;
		qty = Display.getQTY();
		System.out.println(qty);
	}
}
