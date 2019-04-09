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


import Entity.Snack;


public class SnackDb extends SQLProvider <Snack>
{

	Logger logger = LogManager.getLogger(SnackDb.class);
	public static final String TABLE_NAME = "Snack";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(ID INTEGER PRIMARY KEY AUTOINCREMENT, Price	INTEGER, QTY INTEGER, Name VARCHAR(50),  AVL BOOLEAN)"))
			{
				logger.debug("Snack table created");
			} 
			else
			{
				logger.debug("Snack table does not need to be created");
			}
			logger.debug("Snack table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Snack Table not created ", e);
			}
	}

	@Override
	public int add(Snack item) 
	{
		try{
			String query = "INSERT INTO "+TABLE_NAME
					       + "(Price,QTY,Name,AVL)  VALUES (?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1, item.getPrice());
			ps.setInt(2, item.getQTY());
			ps.setString(3, item.getName());
			
			ps.setBoolean(5,item.isAVL());
			
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add Snack",e);
		}
		
		return 0;
		
	}
	
	@Override
	public List<Snack> selectAll() {
		List<Snack> items = new ArrayList<Snack>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT ID, Price,QTY,Name,AVL from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					Snack Snack = new Snack();
					Snack.setID(rs.getInt("ID"));					
					Snack.setPrice(rs.getInt("Price"));
					Snack.setQTY(rs.getInt("QTY"));
					Snack.setName(rs.getString("Name"));
					
					Snack.setAVL(rs.getBoolean("AVL"));
					
					items.add(Snack);					
				}
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Snack database",e);
			return null;
		}
		return items;
	}

	
	@Override
	public Snack get(int id) {
		try
		{
			Statement stat;
			stat = connect.createStatement();			
			String query = "Select * from " +TABLE_NAME+ " WHERE ID = "+id;   
			ResultSet rs= stat.executeQuery(query);
			if(rs != null)
			{
				while(rs.next())
				{					
					Snack Snack = new Snack();
					Snack.setID(rs.getInt("ID"));					
					Snack.setPrice(rs.getInt("Price"));
					Snack.setQTY(rs.getInt("QTY"));
					Snack.setName(rs.getString("Name"));
					Snack.setAVL(rs.getBoolean("AVL"));
					
					return Snack;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Snack recorf=d",e);
		}
		return null;
	}

	
	@Override
	public int update(Snack item, int id) 
	{		
		try 
		{	
			String query = " UPDATE " +TABLE_NAME+ " SET  Price = ?, QTY = ?, Name = ?, AVL = ? " +
					   " WHERE ID = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setInt(1, item.getPrice());
			ps.setInt(2, item.getQTY());
			ps.setString(3, item.getName());
			ps.setString(4, item.getName());
			ps.setBoolean(5,item.isAVL());
			
			ps.setInt(8,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update Snack record",e);
		}
		return 0;
	}
	

	@Override
	public int delete(int id) 
	{
		try 
		{
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE ID = ?";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1,id);
			return ps.executeUpdate();
		}
	
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("Unable to delete Snack Manager with ID "+id,e);

		}
		return 0;
	}

	@Override
	public int deleteMultiple(int[] ids)
	{
		try 
		{
			String groupedIds = Arrays.toString(ids).replace("[","").replace("]","");
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE ID in ("+groupedIds+")";
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
