package day4;


public class ItemService {
	
	Item item = new Item();
	
	Item[] items = new Item[100];
	int position = 0;
	
	ItemService() {
		// items 배열에 Item객체 5개 등록하기
		// items[position++] = new Item(100, "노트북", "맥북", "애플", 1900000);
		System.out.println("서비스 생성자 생성 확인 출력");
		items[position++] = new Item(100, "노트북", "MACBOOK", "애플", 1900000);
		items[position++] = new Item(200, "컴퓨터", "IMAC", "애플", 3000000);
		items[position++] = new Item(300, "휴대폰", "IPHONE", "애플", 1400000);
		items[position++] = new Item(400, "휴대폰", "Galaxy", "삼성", 1250000);
		items[position++] = new Item(500, "노트북", "Galaxy북 FLEX2", "삼성", 2690000);
	}
	
	// items 배열에 저장된 모든 Item객체의 번호, 상품명, 가격을 출력한다.
	void printAllItems() {
		System.out.printf("%-5s%10s%10s%15s%10s\n", "상품번호", "카테고리", "상품명", "브랜드", "가격");
		for (Item item : items) {
			if(item == null) break;
			System.out.printf("%-5d%10s%17s%10s%10d\n", item.no, item.category, item.name, item.maker, item.price);
		}
	}
	
	// item 배열에 저장된 Item객체 중에서 전달받은 category에 속하는 Item객체의 번호, 상품명, 가격을 출력한다.
	void printItemsByCategory(String category) {
		Item foundCategory = null;
		
		for (Item item : items) {
			if(item == null) break;
			
			if(item.category.equals(category)) {
				System.out.printf("%-5s에 속하는 상품정보 : 상품번호  %5d, 상품명  %5s, 가격  %10d\n", category, item.no, item.name, item.price);
				foundCategory = item;
			}
		}
		if(foundCategory == null) {
			System.out.println("해당 카테고리는 존재하지 않습니다.");
		}
	}
	
	// item 배열에 저장된 Item객체 중에서 전달받은 상품명을 포함하는 Item객체의 번호, 상품명, 가격을 출력한다.
	// .equals(name)은 상품명이 name과 일치하면 true
	// .contains(name)은 상품명에 name이 포함되어 있으면 true
	void printItemsByName(String name) {
		Item foundName = null;
		
		for (Item item : items) {
			if(item == null) break;
			
			if(item.name.contains(name)) {
				System.out.printf("%-5s 상품명을 포함하는 상품정보 : 상품번호  %2d, 상품명  %5s, 가격  %5d\n", name, item.no, item.name, item.price);
				foundName = item;
			}
		}
		if(foundName == null) {
			System.out.println("해당 상품명은 존재하지 않습니다.");
		}
	}
	
	// items 배열에 저장된 Item객체 중에서 전달받은 가격범위에 속하는 Item객체의 번호, 상품명, 가격을 출력한다.
	void printItemsByPrice(int minPrice, int maxPrice) {
		Item foundPrice = null;
		
		for (Item item : items) {
			if(item == null) break;
			
			if(item.price >= minPrice && item.price <= maxPrice) {
				System.out.printf("%d~%d원의 범위 가격 조회 결과 : %2d, %5s, %d\n", minPrice, maxPrice, item.no, item.name, item.price);
				foundPrice = item;
			}
		}
		if(foundPrice == null) {
			System.out.println("해당 범위의 가격을 가진 상품은 존재하지 않습니다.");
		}
	}
	
	// items 배열에 저장된 Item객체 중에서 전달받은 번호와 일치하는 Item객체의 모든 정보를 출력한다.
	void printItemDetail(int no) {
		Item foundNo = null;
		
		for (Item item : items) {
			if(item == null) break;
			
			if(item.no == no) {
				foundNo = item;
			}
		}
		if(foundNo == null) {
			System.out.println("해당 상품번호는 존재하지 않습니다.");
		} else {
			System.out.printf("%-5s%10s%10s%15s%7s\n", "상품번호", "카테고리", "상품명", "브랜드", "가격");
			System.out.printf("%-5d%10s%17s%10s%10d\n", foundNo.no, foundNo.category, foundNo.name, foundNo.maker, foundNo.price);
		}
	}
	
	// items 배열에 전달받은 Item 객체를 등록한다.
	void insertItem(Item item) {
			items[position++] = item;
			System.out.println("등록 완료 되었습니다");
		
	}
	
	// items 배열에서 전달받은 번호에 해당하는 Item 객체를 삭제한다.
	// 제거된 자리에는 맨마지막번째에 저장된 Item객체를 옮긴다.
	void deleteItem(int no) {
		int indexNo = 0;
		int itemNo = 0;
		
		// 전달받은 번호에 해당하는 인덱스 번호와 전달받은 번호를 또다른 변수에 저장(비교하기 위해)
		for(int i = 0; i < items.length; i++) {
			// 배열에 null값 제거
			if(items[i] == null) break;
			
			if(items[i].no == no) {
				indexNo = i;
				itemNo = items[i].no;
				break;
			}
		}
		
		// 전달받은 번호와 저장한 번호 비교 후(if문으로 해당번호존재 확인을 위해)
		// for문을 이용해 번호에 해당 하는 index번호로 초기화 배열의 길이-1까지 돌리기(배열은 이미 한칸이 더 많아 져있기때문)
		if(itemNo == no) {
			for(int i = indexNo; i< items.length-1; i++) {
				// 해당 번호자리에 인덱스+1더한 앞칸 배열데이터를 덮어씌운다.(반복 --> 어디까지? 배열의 길이-1까지)
				items[i] = items[i + 1];
				// 총 길이배열 카운터인 포지션 또한 -1로 하여 총 길이를 줄인다.
				position = position - 1;
			}
			System.out.println("삭제 완료 되었습니다.");
			
		} else {
			System.out.println("해당 번호는 존재 하지 않습니다.");
		}
		
	}
}
