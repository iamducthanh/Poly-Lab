package lab8Bai1;

class ProductManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product("iPhone9", 1000.0);
		Product p2 = new Product("Samsung Start", 3000.0);
		ProductDAO dao = new ProductDAO();
		dao.list.add(p1);
		dao.list.add(p2);
		
		dao.list.forEach((dao1) -> {
			System.out.println(dao1);
		});
		
		
		
		
//		dao.store("c:/temp/prod.dat");
//		ProductDAO dao2 = new ProductDAO();
//		dao2.load("c:/temp/dat");
//		Product p = dao2.find("iPhone9");
//		System.out.println(">Name: " + p.name);
//		System.out.println(">Price: " + p.price);
	}

}
