package Entity;


public class Request 
{
	private int stu_ID;
	private String snack;
	private String pic;
	public int getStu_ID() {
		return stu_ID;
	}





	public void setStu_ID(int stu_ID) {
		this.stu_ID = stu_ID;
	}





	public String getSnack() {
		return snack;
	}





	public void setSnack(String snack) {
		this.snack = snack;
	}





	public String getPic() {
		return pic;
	}





	public void setPic(String pic) {
		this.pic = pic;
	}





	public String getLocation() {
		return Location;
	}





	public void setLocation(String location) {
		Location = location;
	}





	public String getName() {
		return Name;
	}





	public void setName(String name) {
		Name = name;
	}





	public String getQty() {
		return qty;
	}





	public void setQty(String qty) {
		this.qty = qty;
	}





	public int getTotal() {
		return total;
	}





	public void setTotal(int total) {
		this.total = total;
	}





	public int getSum() {
		return sum;
	}





	public void setSum(int sum) {
		this.sum = sum;
	}









	private String Location;
	private String Name;
	private String qty;
	private int total;
	private int sum;
	
public Request()
	{
		this(0,"cheese","a","John Jones","q","3",4,3);
	}

		



	public Request(int stu_ID,  String snack, String pic, String Location, String Name, String qty,int total, int sum) {
		super();
		this.stu_ID = stu_ID;
		this.pic = pic;
		this.snack = snack;
		this.Location = Location;
		this.Name = Name;
		this.qty = qty;
		this.total= total;
		
	}

	


	




	@Override
	public String toString() 
	{
		return "Snacks [stu_ID=" + stu_ID +  ", snack=" + snack + ", Location=" + Location
				+ ", Name=" + Name +  "]";
	}



}


