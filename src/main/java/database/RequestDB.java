package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Entity.Request;


public class RequestDB extends SQLProvider <Request>  {

	Logger logger = LogManager.getLogger(RequestDB.class);
	public static final String TABLE_NAME = "Request";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(stu_ID  INTEGER PRIMARY KEY , Name VARCHAR(50), Location VARCHAR(50), snack VARCHAR(50))"))
			{
				logger.debug("Request table created");
			} 
			else
			{
				logger.debug("Request table does not need to be created");
			}
			logger.debug("Request table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Request Table not created ", e);
			}
	}

	@Override
	public int add(Request item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(stu_ID , Name, Location, snack)  VALUES (?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1, item.getstu_ID());
			ps.setString(2, item.getName());
			ps.setString(3, item.getLocation());
			
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add Request",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<Request> selectAll() {
		List<Request> items = new ArrayList<Request>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT stu_ID, Name, Location, snack  from  "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{			
					Request Request = new Request();		
					
					
					
								
					Request.setstu_ID(rs.getInt("stu_ID"));	
					
					Request.setName(rs.getString("Name"));
					Request.setLocation(rs.getString("Location"));
					Request.setsnack(rs.getString("snack"));
					
					
					items.add(Request);					
				}
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Request database",e);
			return null;
		}
		return items;
	}

	
	@Override
	public Request get(int id) {
		try
		{
			Statement stat;
			stat = connect.createStatement();			
			String query = "Select * from " +TABLE_NAME+ " WHERE stu_ID = "+id;   
			ResultSet rs= stat.executeQuery(query);
			if(rs != null)
			{
				while(rs.next())
				{					
					Request Request = new Request();
					Request.setstu_ID(rs.getInt("stu_ID"));		 				
					
					Request.setName(rs.getString("Name"));
					Request.setLocation(rs.getString("Location"));
					Request.setsnack(rs.getString("snack"));
					
					
					return Request;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Request recorf=d",e);
		}
		return null;
	}

	
	@Override
	public int update(Request item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET Name = ?, Location = ?, snack = ? , " +
					   " WHERE stu_ID = ?";
			
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setInt(1, item.getstu_ID());
		
			ps.setString(4, item.getName());
			ps.setString(5,item.getLocation());
			ps.setString(6,item.getsnack());
			
			ps.setInt(8,id);
			return ps.executeUpdate();
		} 		
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update Request record",e);
		}
		return 0;
	}
	

	@Override
	public int delete(int id) 
	{
		try 
		{
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1,id);
			return ps.executeUpdate();
		}
	
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("Unable to delete Request Manager with id "+id,e);

		}
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids)
	{
		try 
		{
			String groupedIds = Arrays.toString(ids).replace("[","").replace("]","");
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE id in ("+groupedIds+")";
			PreparedStatement ps = connect.prepareStatement(query);			
			return ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update",e);
		}
		return 0;
	}

	

}


