package lab1;

public class Product implements DAO{
	private String name;
	private int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}	
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}



	public double getImportTax() {
		return price * 0.1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert thanh cong!");

		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("update thanh cong!");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("delete thanh cong!");
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("select thanh cong!");
		
	}
	
	
	
	
	
}
