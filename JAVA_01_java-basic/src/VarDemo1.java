
public class VarDemo1 {

	public static void main(String[] args) {
		// 변수(값을 담는 저장소) 생성하기
		// price, amount, discountRate, soldOut은 변수명이다.
		// price, amount, discountRate, soldOut은 저장소를 식별하기 위한 고유한 이름이다.
		// int, double, boolean은 생성된 저장소의 타입을 지정한다.
		// 저장소의 타입은 한번 정해지면 바꿀수 없다.
		// 저장소에는 타입에 맞는 값만 저장할 수 있다.
		
		int price;
		int amount;
		int orderPrice;
		double discountRate;
		boolean soldOut; // 매진여부, 값의 상태가 딱 2가지만 존재함, 참/거짓
		
		// 변수의 초기화
		// 변수(저장소)에 값을 대입하는 것
		price = 35000;
		amount = 2;
		orderPrice = 70000;
		discountRate = 0.01;
		soldOut = false;
		
		// 변수의 사용
		System.out.println(price); // price 저장소에 저장된 값 출력하기
		System.out.println(amount); // amount 저장소에 저장된 값 출력하기
		System.out.println(price*amount); //price와 amount에 저장소에 저장된 값 출력하기
		System.out.println(discountRate); // discountRate 저장소에 저장된 값 출력하기
		System.out.println(soldOut); //soldOut 저장소에 저장된 값 출력하기
		System.out.println(price+", "+amount+", "+price*amount+", "+discountRate+", "+soldOut);
		
		
	}

}
