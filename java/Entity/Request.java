package Entity;


public class Request 
{
	private int stu_ID;
	private String snack;
	private String Location;
	private String Name;
	

	public Request()
	{
		this(0,"cheese","civic","John Jones");
	}

		
	public Request(int stu_ID,  String snack, String Location, String Name) {
		super();
		this.stu_ID = stu_ID;
		
		this.snack = snack;
		this.Location = Location;
		this.Name = Name;
		
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
	
	
	


	@Override
	public String toString() 
	{
		return "Snacks [stu_ID=" + stu_ID +  ", snack=" + snack + ", Location=" + Location
				+ ", Name=" + Name +  "]";
	}



}


