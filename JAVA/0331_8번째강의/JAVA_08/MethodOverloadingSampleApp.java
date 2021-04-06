package day3;

public class MethodOverloadingSampleApp {

	public static void main(String[] args) {

		// 비슷한 작업을 일관성 있게 같은 메소드로 작업할떄 
		// 메서드 overloading을 사용한다.
		MethodOverloadingSample sample = new MethodOverloadingSample();
		
		sample.plus(10, 20);
		sample.plus(10, 20, 30);
		sample.plus(10.0, 20.0);
		sample.plus(10, 20.0);
		sample.plus(10.0, 20);
		
	}

}
