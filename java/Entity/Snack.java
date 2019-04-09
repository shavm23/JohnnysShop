package Entity;


public class Snack 
{
	private int ID;
	private String Name;
	private boolean AVL;
	private int Price;
	private int QTY;

	public Snack()
	{
		this(0,"cheetos",true,50,1);
	}

		
	public Snack(int id, String Name, boolean AVL, int Price, int QTY) {
		super();
		this.ID= id;
		this.Name = Name;
		this.AVL = AVL;
		this.Price = Price;
		this.QTY = QTY;
	}

	public int getID() {
		return ID;
	}

	public void setID(int c_id) {
		this.ID = c_id;
	}
	

	

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	
	
	public boolean isAVL() {
		return AVL;
	}

	public void setAVL(boolean AVL) {
		this.AVL = AVL;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int Price) {
		this.Price = Price;
	}

	public int getQTY() 
	{
		return QTY;
	}


	public void setQTY(int QTY) 
	{
		this.QTY = QTY;
	}


	@Override
	public String toString() 
	{
		return "Snack [ID=" + ID + ", Name=" + Name + ", AVL=" + AVL + ", Price=" + Price + ", QTY=" + QTY + "]";
	}



}


