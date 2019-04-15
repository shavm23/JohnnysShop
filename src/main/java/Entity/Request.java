package Entity;


public class Request 
{
	private int stu_ID;
	private String snack;
	private String pic;
	private String Location;
	private String Name;
	private int qty;
	private int total;
	
public Request()
	{
		this(0,"cheese","a","John Jones","q",3,4);
	}

		
	public Request(int stu_ID,  String snack, String pic, String Location, String Name, int qty,int total) {
		super();
		this.stu_ID = stu_ID;
		this.pic = pic;
		this.snack = snack;
		this.Location = Location;
		this.Name = Name;
		this.qty = qty;
		this.total= total;
		
	}

	public int getQty() {
		return qty;
	}


	public int getstu_ID() {
		return stu_ID;
	}

	public void setstu_ID(int stu_ID) {
		this.stu_ID = stu_ID;
	}
	

	



	public String getsnack() {
		return snack;
	}

	public void setsnack(String snack) {
		this.snack = snack;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String Location) {
		this.Location = Location;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}



	@Override
	public String toString() 
	{
		return "Snacks [stu_ID=" + stu_ID +  ", snack=" + snack + ", Location=" + Location
				+ ", Name=" + Name +  "]";
	}



}


