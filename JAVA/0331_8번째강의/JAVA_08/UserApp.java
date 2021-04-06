package day3;

public class UserApp {

	public static void main(String[] args) {
		
		/*
		*	 new 생성자메소드();
		* 		1. 생성자메소드명은 클래스 이름과 같다.
		*			-> 객체 생성에 사용할 설계도 이름을 알 수 있음
		*			-> 설계도이름에 해당하는 클래스를 로딩해서 객체를 생성함.
		*		2. 생성자메소드(); <--- 메소드를 실행하는 코드임
		*			-> 객체 생성된 직후에 생성자메소드의 수행문이 실행됨
		*			-> 객체 생성 직후에 필요한 작업을 수행할 수 있게 됨
		*		* new 생성자메소드()는
		*			  객체를 생성할 클래스이름을 알 수 있다.
		*			  객체생성 직후 실행할 메소드도 알 수 있다.
		*/			
		User user1 = new User();
		user1.displayUserInfo();
		
		System.out.println("--------------------------------------");
		User user2 = new User();		// 9999, 홍길동, hong, zxcv1234, 서울로 값이 먼저 초기화됨
		user2.no = 10;
		user2.name = "김유신";
		user2.id = "kim";
		user2.password = "kim1234";
		user2.displayUserInfo();
		
		System.out.println("--------------------------------------");
		User user3 = new User(1500, "이순신", "Lee", "lee123456");
		user3.displayUserInfo();
	}

}
