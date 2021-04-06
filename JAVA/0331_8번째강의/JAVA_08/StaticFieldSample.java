package day3;

public class StaticFieldSample {

	// 멤버변수, 인스턴스변수
	int x;
	
	// 정적변수, 클래스변수
	static int y;
	
	// 멤버메소드
	void increase() {
		x++;
		y++;
	}
	
	// 멤버메소드
	// static(정적)변수는 오로지 클래스당 1개만 만들어 진다.
	// 반면 인스턴스변수는 객체 당 1개씩 생긴다
	void print() {
		System.out.println("멤버변수 x의 값 : " + x);
		System.out.println("멤버변수 y의 값 : " + y);
		/* 실행결과 아래의 결과를 얻을수 있는데
		 * 멤버변수 x의 값 : 1
		 * 멤버변수 y의 값 : 1
		 * 멤버변수 x의 값 : 1
		 * 멤버변수 y의 값 : 2
		 * 멤버변수 x의 값 : 1
		 * 멤버변수 y의 값 : 3
		 * x의 값은 계속 1인 이유는 인스턴스 변수 이기때문에 객체당 1개씩 생성 되서 서로 다른 객체를 생성해서 출력했기 떄문이다.
		 * 반면 y의 값은 1씩 증가되는데 이 이유는 static변수이기 때문에 해당 클래스에는 static y변수 하나만을 가지므로 값이 증가되는것을 볼수 있다.
		 */ 
	}
}
