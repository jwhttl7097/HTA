package sample4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App2 {
	
//	1. 상품조회
//	   - products 배열에 저장된 모든 상품을 출력한다.
//	2. 상품구매
//	   - 상품번호와 수량을 입력받는다.
//	   - 상품번호에 해당하는 상품정보를 조회한다.
//	   - 상품번호에 해당하는 상품이 존재하면, 구매정보객체에 상품정보와 구매수량을 저장한다.
//	   - 구매정보 배열에 구매정보객체를 저장한다.
//	3. 구매내역조회
//	   - 구매정보 배열에 저장된 모든 구매정보를 출력한다.
//	4. 총계조회
//	   - 구매정보 배열에 저장된 구매정보를 사용해서, 총 주문금액, 총 적립포인트를 출력한다.
//	   - 총주문금액은 상품가격*구매수량의 총합이다.
//	   - 총적립포인트는 상품포인트*구매수량의 총합이다.
	
	private static DecimalFormat numberFormat = new DecimalFormat("#,###");
	private static String numberToCurrency(int number) {
		return App2.numberFormat.format(number);
	}
	
	private static Product findProduct(Product[] products, int productNo) {
		Product foundProduct = null;
		for (Product product : products) {
			if(product.getNo() == productNo) {
				foundProduct = product;
			}
		}
		return foundProduct;
	}
	
	private static void printProduct(Product[] products) {
		for (Product product : products) {
			System.out.println("상품번호 : " + product.getNo());
			System.out.println("상품명 : " + product.getName());
			System.out.println("상품가격 : " + App2.numberToCurrency(product.getPrice()));
			System.out.println("적립포인트 : " + product.getPoint());
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		// 상품정보를 조회할 수 있다.
		// 상품을 구매할 수 있다.
		// 상품구매내역을 출력할 수 있다.
		// 총 구매금액, 총 적립포인트를 출력할 수 있다.
		
		// 상품정보가 저장된 배열
		Product[] products = new Product[10];
		products[0] = new Product(10, "맥북프로", 2600000, 2600);
		products[1] = new Product(20, "애플워치", 600000, 600);
		products[2] = new Product(30, "갤럭시워치", 450000, 450);
		products[3] = new Product(40, "아이패드", 800000, 800);
		products[4] = new Product(50, "TV", 400000, 400);
		products[5] = new Product(60, "냉장고", 2000000, 2000);
		products[6] = new Product(70, "건조기", 1400000, 1400);
		products[7] = new Product(80, "세탁기", 1500000, 1500);
		products[8] = new Product(90, "소파", 1000000, 1000);
		products[9] = new Product(100, "침대", 1700000, 1700);
		
		
		// 구매정보가 저장된 배열
		Order[] orders = new Order[100];
		int position = 0;
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while (flag) {
			System.out.println("--------------------------------------------");
			System.out.println("1.상품조회  2.구매  3.구매내역조회  4.총계조회  0.종료");
			System.out.println("--------------------------------------------");
			
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = sc.nextInt();
			switch (menuNo) {
			case 1:
				System.out.println("상품을 조회합니다.");
				App2.printProduct(products);
				break;
				
			case 2:
//				2. 상품구매
//				   - 상품번호와 수량을 입력받는다.
//				   - 상품번호에 해당하는 상품정보를 조회한다.
//				   - 상품번호에 해당하는 상품이 존재하면, 구매정보객체에 상품정보와 구매수량을 저장한다.
//				   - 구매정보 배열에 구매정보객체를 저장한다.
				System.out.println("상품을 구매합니다.");
				System.out.print("구매하실 상품의 번호를 입력하세요 : ");
				int productNo = sc.nextInt();
				System.out.print("구매하실 상품 갯수를 입력하세요 : ");
				int amount = sc.nextInt();
				if(amount == 0) {
					System.out.println("수량을 잘못 입력하셨습니다.");
					break;
				}
				Product product = App2.findProduct(products, productNo);
				if(product == null) {
					System.out.println("[안내] 상품번호에 해당하는 상품이 없습니다.");
				} else {
					// 주문정보 생성
					Order order = new Order();
					order.setItem(product);
					order.setAmount(amount);
					
					// 주문배열에 저장하기
					orders[position++] = order;
					System.out.println("[안내] 주문이 완료되었습니다.");
				}
				System.out.println();
				
				break;
				
			case 3:
//				3. 구매내역조회
//				   - 구매정보 배열에 저장된 모든 구매정보를 출력한다.
				System.out.println("구매내역을 조회합니다.");
				if(position == 0) {
					System.out.println("[안내] 주문내역이 존재하지 않습니다.");
				} else {
					for (Order order : orders) {
						if (order == null) {
							break;
						}
						System.out.println("주문상품이름: " + order.getItem().getName());
						System.out.println("주문상품가격: " + App2.numberToCurrency(order.getItem().getPrice()));
						System.out.println("주문상품수량: " + order.getAmount());
						System.out.println();
					}
				}
				break;
				
			case 4:
//				4. 총계조회
//				   - 구매정보 배열에 저장된 구매정보를 사용해서, 총 주문금액, 총 적립포인트를 출력한다.
//				   - 총주문금액은 상품가격*구매수량의 총합이다.
//				   - 총적립포인트는 상품포인트*구매수량의 총합이다.
				System.out.println("[구매내역 총계 조회]");
				
				int totalOrderPrice = 0;
				int totalOrderCount = 0;
				int totalSavedPoint = 0;
				
				if(position > 0) {
					for (Order order : orders) {
						if(order == null) {
							break;
						}
						totalOrderPrice += order.getOrderPrice();
						totalSavedPoint += order.getSavedPoint();
						totalOrderCount++;
					}
				}
				System.out.println("총 구매금액 : " + numberToCurrency(totalOrderPrice)+ "원");
				System.out.println("총 적립포인트 : " + numberToCurrency(totalSavedPoint)+ "원");
				System.out.println("총 구매건수 : " + numberToCurrency(totalOrderCount)+ "건");
				
				break;
				
			case 0:
				System.out.println("프로그램 종료");
				flag = false;
				break;

			default:
				break;
			}
			System.out.println();
			System.out.println();
		}
		
		sc.close();
	}
}
