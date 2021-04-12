package day5.inner;


public class Outer3 {

	int x = 10;
	static int y = 20;
	
	public void test1() {
		System.out.println("외부클래스의 인스턴스 메소드 test1() 실행");
	}
	
	public static void test2() {
		System.out.println("외부클래스의 정적 메소드 test2() 실행");
	}
	
	public void test3() {
		int a = 10;
		int b = 20;
		final int c = 30;
		
		// 로컬 내부 클래스
		// 외부 클래스의 모든 변수, 메소드 사용가능, 사용빈도 매우 낮음
		// 내부클래스를 포함하고 있는 메소드의 변수 중에서는
		// final로 선언된 변수나, 메소드 
		
		class Inner {
			public void innerMethod() {
				System.out.println("외부클래스의 인스턴스 변수 : " + x);
				System.out.println("외부클래스의 정적 변수 : " + Outer3.y);
				test1();
				Outer3.test2();
				
				System.out.println("test3() 메소드의 변수 : " + a);
				//System.out.println("test3() 메소드의 변수 : " + b);
				System.out.println("test3() 메소드의 변수 : " + c);
			}
		}
		
		Inner inner = new Inner();
		inner.innerMethod();
		
		b = 50;
		System.out.println(b);
	}
}
