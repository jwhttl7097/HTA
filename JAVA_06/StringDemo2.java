import java.util.Scanner;

public class StringDemo2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String value1 = "홍길동";
		
		System.out.println("이름을 입력하세요 : ");
		String value2 = sc.next();
		
		// value1변수에 저장된 문자열과 value2에 저장된 문자열이 동일한 문자열인지 비교하기
		
		// ==은 주소값이 같은지 비교하기 때문에 객체가 같은값을 가지고 있는지 비교할수 없다.
		// (서로 다른 객체의 주소값을 가지고 있으므로 결과는 false)
		System.out.println(value1 == value2);
		
		// String객체는 .equals(객체)를 사용하면 객체가 같은값을 가지고 있는지 비교할수 있다.
		// value1변수가 참조하는 객체와 value2변수가 참조하는 객체가 동일한 내용을 가지고 있으면
		// 객체의 주소값에 상관없이 true가 나온다.
		System.out.println(value1.equals(value2));
		System.out.println(value2.equals(value1));
	}

}
