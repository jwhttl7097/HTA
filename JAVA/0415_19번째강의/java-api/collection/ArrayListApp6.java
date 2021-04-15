package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ArrayListApp6 {
	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(10, "핸드폰", 1200000, 120));
		products.add(new Product(20, "태블릿", 600000, 120));
		products.add(new Product(30, "스마트워치", 500000, 70));
		products.add(new Product(40, "애플펜슬", 160000, 30));
		
		System.out.println("### 상품번호순으로 정렬하기");
		Collections.sort(products);						// Collections.sort(정렬할 리스트, 정렬방법comparator로직);
		for (Product item : products) {
			System.out.println(item.getNo() + "\t" + item.getName() + "\t" + item.getPrice());
		}
		System.out.println();
		
		System.out.println("### 이름순으로 정렬하기");
		
		// Comparator<E> 인터페이스 int compare(T t1, T t2)메소드를 익명객체로 구현하기
		Comparator<Product> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
//		Comparator<Product> nameComparator = new Comparator<Product>() {
//			@Override
//			public int compare(Product o1, Product o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		};
		Collections.sort(products, nameComparator);		// Collections.sort(정렬할 리스트, 정렬방법comparator로직);
		for (Product item : products) {
			System.out.println(item.getNo() + "\t" + item.getName() + "\t" + item.getPrice());
		}
		
		System.out.println("### 가격순으로 정렬하기");
		Comparator<Product> priceComparator = (o1, o2) -> o1.getPrice() - o2.getPrice();
//		Comparator<Product> priceComparator = new Comparator<Product>() {
//			@Override
//			public int compare(Product o1, Product o2) {
//				return o1.getPrice() - o2.getPrice();
//			}
//		};
		Collections.sort(products, priceComparator);	// Collections.sort(정렬할 리스트, 정렬방법comparator로직);
		for (Product item : products) {
			System.out.println(item.getNo() + "\t" + item.getName() + "\t" + item.getPrice());
		}
		System.out.println();
		
		System.out.println("### 적립포인트순으로 정렬하기");
//		Comparator<Product> pointComparator = (o1, o2) -> o1.getPoint() - o2.getPoint();	// 람다식
		Collections.sort(products, (o1, o2) -> o1.getPoint() - o2.getPoint());				// 람다식으로 코드 낭비최소화
		for (Product item : products) {
			System.out.println(item.getNo() + "\t" + item.getName() + "\t" + item.getPoint());
		}
		System.out.println();
				
		
		
	}

}
