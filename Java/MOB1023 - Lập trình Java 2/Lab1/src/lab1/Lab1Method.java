package lab1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab1Method {
	String name;
	int price;

	Scanner sc = new Scanner(System.in);
	ArrayList<Product> listSP = new ArrayList<Product>();
	DecimalFormat fm = new DecimalFormat("#,###");
	String temp;
	Product product = new Product();


	public void nhap() {
		String rePrice = "[0-9]{0,50}";
		for (int i = 0; i < 3; i++) {
			System.out.printf("Nhap san pham so %d: \n", i + 1);
			System.out.print("\tNhap name: ");
			name = sc.nextLine();
			System.out.print("\tNhap price: ");
			while(true) {
				temp = sc.nextLine();
				if(!temp.matches(rePrice)) {
					System.out.print("\tNhap sai gia roi nhap lai: ");
				} else {
					price = Integer.parseInt(temp);
					break;
				}
			}
			System.out.print("\t\t1. San pham thong thuong\n \t\t2. San pham van hoa nha nuoc\n \tChon loai san pham: ");

			while (true) {
			    temp = sc.nextLine();
				switch (temp) {
				case "1":
					listSP.add(new Product(name, price));
					break;
				case "2":
					listSP.add(new NoTaxProduct(name, price));
					break;
				default:
					System.out.print("\tChon sai loai san pham, chon lai: ");
				}
				if(temp.equals("1") || temp.equals("2")) {
					break;
				}
			}

		}
	}

	public void xuat() {
		System.out.printf("\n\n%20s %16s %16s\n", "name", "price", "thue");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%20s %15s$ %15s$\n", listSP.get(i).getName(), fm.format(listSP.get(i).getPrice()),
					fm.format(listSP.get(i).getImportTax()));
		}
		product.insert();
		product.update();
		product.delete();
		product.select();
	}
}
