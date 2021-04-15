package collection;

import java.util.ArrayList;
import java.util.Collections;


public class ArrayListApp5 {
	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(10, "핸드폰", 1200000, 120));
		products.add(new Product(20, "태블릿", 600000, 120));
		products.add(new Product(30, "스마트워치", 500000, 70));
		products.add(new Product(40, "애플펜슬", 160000, 30));
		
		// 오름차순 정렬
		Collections.sort(products);
		// 순서를 뒤집는다
		// Collections.reverse(products);
		
		for (Product item : products) {
			System.out.println(item.getNo() + "\t" + item.getName() + "\t" + item.getPrice());
			
		}
		
	}

}
