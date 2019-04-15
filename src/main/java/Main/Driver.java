package Main;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import Entity.Cab;
//import Entity.CabManager;
import Entity.Snack;
//import Entity.RequestModel;
//import Entity.System1;
//import database.CabDb;
//import database.CabManagerDb;
import database.SnackDb;
import database.RequestDB;
import database.SQLProvider;
//import database.SystemDb;

//import Entity.Cab;
//import Entity.DistanceModel;
public class Driver 
{
	public static void main(String[] args) 
	{
		
		Logger logger = null;
		logger = LogManager.getLogger(Driver.class);
		
	//	SQLProvider<CabManager> db = new CabManagerDb();
	//	SQLProvider<Cab> db = new CabDb();
	//	SQLProvider<DistanceModel> db = new DistanceReportDb();		
	//	SystemDb db = new SystemDb();
	//	SQLProvider<RequestModel> db = new RequestModelDb();
		SnackDb db = new SnackDb();
/*int recordsAffected = db.add(new Customer(0,"nowhere","nowhere",2999, "lovely", 1,false,false));
		
		if(recordsAffected == 1)
		{
			logger.debug("records added successfully");
			System.out.println("records added successfully");
		}
		else
		{			
			logger.debug("records not added successfully");
			System.out.println("records not added successfully");
		}
		
		db.getByNumber(2999);
		*/
		Snack cn = new Snack(1,"cheetoes",true,50, 10, "images/cheetos.jpg");
		int id=1;
		int recordsAffected = db.update(cn,id);
		if(recordsAffected == 1)
			{
				logger.debug("records Updated successfully");
				System.out.println("--- Updated! -- ");			
			}
		else
			{			
				logger.error("records not Updated successfully");
				System.out.println("--- Update failed -- ");							
			}
		
				List<Snack> results = db.selectAll();
				System.out.println(SnackDb.TABLE_NAME);
				System.out.println("--- Retrieved -- ");
				
				for(Snack cm : results) 
					{
						System.out.println(cm);
					}
				
				
//
////				List<Customer> results = db.selectAll();
////				System.out.println(RequestModelDb.TABLE_NAME);
////				System.out.println("--- Retrieved -- ");
////				
////				for(Customer cm : results) 
////					{
////						System.out.println(cm);
////					}
//				
			
				
		/*
		int recordsAffected = db.add(new RequestModel(0,0,7,11,"yah suh","deh suh again",0,0.0));
		
		if(recordsAffected == 1)
		{
			logger.debug("records added successfully");
			System.out.println("records added successfully");
		}
		else
		{			
			logger.debug("records not added successfully");
			System.out.println("records not added successfully");
		}
		
		List<RequestModel> results = db.selectAll();
		System.out.println(RequestModelDb.TABLE_NAME);
		System.out.println("--- Retrieved -- ");
		
		for(RequestModel cm : results) 
			{
				System.out.println(cm);
			}*/
		
	/*	 //add
		int recordsAffected = db.add(new CabManager(34,"demarBlackgmail.com","demar"));
		
		if(recordsAffected == 1)
		{
			logger.debug("records added successfully");
			System.out.println("records added successfully");
		}
		else
		{			
			logger.debug("records not added successfully");
			System.out.println("records not added successfully");
		}
		
	

 		//get
	/*	CabManager cmm;
		cmm = db.get(21);
		System.out.println("Returning Cab Manager with the id of ",id);	
	
		if (cmm != null)
			{			
				System.out.println(cmm);
			}
		else
			{
				System.out.println("No records found");
				logger.error("object is empty");
			}*/
		
		
			
	/*	CabManager cn = new CabManager(0,"newwww@email","newpw");
		int id=21;
		int recordsAffected = db.update(cn,id);
		if(recordsAffected == 1)
			{
				logger.debug("records Updated successfully");
				System.out.println("--- Updated! -- ");			
			}
		else
			{			
				logger.error("records not Updated successfully");
				System.out.println("--- Update failed -- ");			
			}*/
			
	/*
	//	Delete 
		int id=21;
		int recordsAffected = db.delete(id);
		if(recordsAffected == 1)
		{
			logger.debug("record deleted successfully");
			System.out.println("--- deleted! -- ");			
		}
		else
		{			
			logger.error("record not deleted successfully");
			System.out.println("--- delete failed -- ");			
		}
		*/
		/*
		// Delete Multiple
		int id[]= {10,11,12};
		int recordsAffected = db.deleteMultiple(id);
		if(recordsAffected == 3)
		{
			logger.debug("records deleted successfully");
			System.out.println("--- deleted! -- ");			
		}
		else
		{			
			logger.error("records not deleted successfully");
			System.out.println("--- delete failed -- ");			
		}
		*/
		
		//selectAll
		/*
			List<CabManager> results = db.selectAll();
			System.out.println(CabManagerDb.TABLE_NAME);
			System.out.println("--- Retrieved -- ");
			
			for(CabManager cm : results) 
				{
					System.out.println(cm);
				}*/

			 //add Cab
			/*int recordsAffected = db.add(new CabManager(1,"Elliot","lean"));
			
			if(recordsAffected == 1)
			{
				logger.debug("Cab records added successfully");
				System.out.println(" Cab record added successfully");
			}
			else
			{			
				logger.debug(" Cab record not added successfully");
				System.out.println("Cab record not added successfully");
			}
			
		
			List<CabManager> results = db.selectAll();
			System.out.println(CabDb.TABLE_NAME);
			System.out.println("--- Retrieved -- ");
			*/
	/*		for(CabManager cm : results) 
				{
					System.out.println(cm);
				}*/
	/*	int max = 0;
		max = db.populateDb();
		if(max >= 25)
		{
			logger.info("System Database populated");			
		}
		else
		{		
		logger.info("System Database not populated");				
		}
		
		List<System1> results = db.selectAll();
		System.out.println(CabDb.TABLE_NAME);
		System.out.println("--- Retrieved -- ");
		
		for(System1 cm : results) 
			{
				System.out.println(cm);
			}
*/
		
	/*
		int recordsAffected = db.add(new DistanceModel());
		
		if(recordsAffected == 1)
		{
			logger.debug("DistanceModel record added successfully");
			System.out.println(" DistanceModel record added successfully");
		}
		else
		{			
			logger.debug(" DistanceModel record not added successfully");
			System.out.println("DistanceModel record not added successfully");
		}
		
		List<DistanceModel> results = db.selectAll();
		System.out.println(CabDb.TABLE_NAME);
		System.out.println("--- Retrieved -- ");
		
		for(DistanceModel cm : results) 
			{
				System.out.println(cm);
			}*/
		
	}	
}
