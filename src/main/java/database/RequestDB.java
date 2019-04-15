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
							"( ID INTEGER PRIMARY KEY AUTOINCREMENT ,stu_ID  INTEGER  , Name VARCHAR(50), Location VARCHAR(50), snack VARCHAR(50), qty INTEGER, pic VARCHAR(50),total INTEGER)"))
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
					       + "(stu_ID , Name, Location, snack, qty,pic,total)  VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1, item.getstu_ID());
			ps.setString(2, item.getName());
			ps.setString(3, item.getLocation());
			ps.setString(4, item.getsnack());
			ps.setInt(5, item.getQty());
			ps.setString(6, item.getPic());
			ps.setInt(7, item.getTotal());
			
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
			String sql = "SELECT stu_ID, Name, Location, snack, qty,pic,total  from  "+TABLE_NAME;
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
					Request.setQty(rs.getInt("qty"));
					Request.setPic(rs.getString("pic"));
					Request.setTotal(rs.getInt("total"));
					
					
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
					Request.setQty(rs.getInt("qty"));
					Request.setPic(rs.getString("pic"));
					Request.setTotal(rs.getInt("total"));
					
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
			String query = " UPDATE " +TABLE_NAME+ " SET Name = ?, Location = ?, snack = ? ,qty = ?,pic=?,total=? " +
					   " WHERE stu_ID = ?";
			
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setInt(1, item.getstu_ID());
			ps.setString(2, item.getName());
			ps.setString(3, item.getLocation());
			ps.setString(4, item.getsnack());
			ps.setInt(5, item.getQty());
			ps.setString(6, item.getPic());
			ps.setInt(7, item.getTotal());
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


