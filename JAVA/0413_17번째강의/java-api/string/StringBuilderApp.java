package string;

public class StringBuilderApp {
	
	public static void main(String[] args) {
		// StringBuilder
		// - StringBuilder 객체는 내부에 임시저장소를 가지고 있는 객체다.
		// - StringBuilder의 append(값) 메소드로 임시저장소에 다양한 값을 추가할 수 있다.
		// - StringBuilder의 toString() 메소드는 임시저장소에 저장된 값을
		//   하나의 문자열(String객체)에 담아서 반환한다
		// * StringBuilder는 String이 아니다.
		// * StringBuilder는 String을 제공하는 기능을 가지고 있는 완전 다른 객체다.
		
		StringBuilder sb = new StringBuilder();
		sb.append("홍길동");				// 이름		- String값 추가
		sb.append(",");					
		sb.append("010-1111-1111");		// 전화번호	- String값 추가
		sb.append(",");
		sb.append("hong@gmail.com");	// 이메일		- String값 추가
		sb.append(",");
		sb.append(34);					// 나이		- 정수값 추가
		sb.append(",");
		sb.append(182.6);				// 키		- 실수값 추가
		sb.append(",");
		sb.append(75.2);				// 몸무게		- 실수값 추가
		sb.append(",");
		sb.append('A');					// 혈액형		- 문자값 추가
		sb.append(",");
		sb.append(false);				// 결혼여부	- 불린값 추가
		
		//String toString() 메소드
	    // - 임시저장소에 저장된 모든 값을 하나의 문자열에 담아서 반환한다.
	    String text = sb.toString();
	    System.out.println(text);

		
	}

}
