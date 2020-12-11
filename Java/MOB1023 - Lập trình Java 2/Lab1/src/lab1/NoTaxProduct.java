package lab1;

public class NoTaxProduct extends Product{

	public NoTaxProduct() {
		// TODO Auto-generated constructor stub
	}

	public NoTaxProduct(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getImportTax() {
		return 0;		
	}
	
}
