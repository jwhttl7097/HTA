package collection;

import java.util.ArrayList;
import java.util.Iterator;


public class ArrayListApp4 {
	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(10, "핸드폰", 1200000, 120));
		products.add(new Product(20, "태블릿", 600000, 120));
		products.add(new Product(30, "스마트워치", 500000, 70));
		products.add(new Product(40, "애플펜슬", 160000, 30));
		
		System.out.println("### Iterator를 사용해서 ArrayList객체에 저장된 Product객체 조회하기");
		Iterator<Product> iter =  products.iterator();
		while(iter.hasNext()) {
			Product p = iter.next();
			System.out.println("번호 : " + p.getNo());
			System.out.println("이름 : " + p.getName());
			System.out.println("가격 : " + p.getPrice());
			System.out.println("포인트 : " + p.getPoint());
			System.out.println();
		}
		
	}

}
