package day4;

import java.util.Scanner;

public class ItemApp {

	public static void main(String[] args) {

		final int ALLSEARCH = 1;
		final int CATEGORY_SEARCH = 2;
		final int NAME_SEARCH = 3;
		final int PRICE_SEARCH = 4;
		final int NO_SEARCH = 5;
		final int INSERT_INFO = 6;
		final int DELETE_INFO = 7;
		final int EXIT = 0;
		
		
		
		Scanner sc = new Scanner(System.in);
		
		// Item객체에 대한 조회/검색/추가/삭제 기능을 제공하는 객체 생성
		ItemService service = new ItemService();
		boolean flag = true;
		
		while(flag) {
			System.out.println("==================================================================");
			System.out.println("1.전체조회  2.카테고리  3.이름조회  4.가격조회  5.번호조회  6.등록  7.삭제  0.종료");
			System.out.println("==================================================================");
			
			System.out.println("메뉴번호를 선택하세요 : ");
			int menuNo = sc.nextInt();
			
			switch (menuNo) {
			case ALLSEARCH:
				service.printAllItems();
				break;
				
			case CATEGORY_SEARCH:
				System.out.print("조회할 카테고리를 입력하세요. : ");
				String category = sc.next();
				service.printItemsByCategory(category);
				break;
				
			case NAME_SEARCH:
				System.out.print("조회할 상품명을 입력하세요. : ");
				String name = sc.next();
				service.printItemsByName(name);
				break;
				
			case PRICE_SEARCH:
				System.out.print("조회할 상품가격의 최저가격을 입력하세요. : ");
				int minPrice = sc.nextInt();
				System.out.print("조회할 상품가격의 최대가격을 입력하세요. : ");
				int maxPrice = sc.nextInt();
				System.out.println();
				service.printItemsByPrice(minPrice, maxPrice);
				break;
				
			case NO_SEARCH:
				System.out.print("조회할 상품번호를 입력하세요. : ");
				int no = sc.nextInt();
				service.printItemDetail(no);
				break;
				
			case INSERT_INFO:
				System.out.print("등록할 상품의 상품번호를 입력해 주세요.");
				int itemNo = sc.nextInt();
				System.out.print("등록할 상품의 카테고리를 입력해 주세요.");
				String itemCategory = sc.next();
				System.out.print("등록할 상품의 상품명을 입력해 주세요.");
				String itemName = sc.next();
				System.out.print("등록할 상품의 브랜드 입력해 주세요.");
				String itemMaker = sc.next();
				System.out.print("등록할 상품의 가격을 입력해 주세요.");
				int itemPrice = sc.nextInt();
				Item item = new Item(itemNo, itemCategory, itemName, itemMaker, itemPrice);
				
				service.insertItem(item);
				break;
				
			case DELETE_INFO:
				System.out.print("삭제할 상품의 상품번호를 입력 하세요.");
				int deleteNo = sc.nextInt();
				service.deleteItem(deleteNo);
				break;
				
			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				flag =false;
				break;

			default:
				System.out.println("잘못 누르셨습니다");
				break;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
		}
		
		sc.close();
		
	}

}
