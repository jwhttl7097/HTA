package object;

public class ObjectApp2 {

	public static void main(String[] args) {
		Person p1 = new Person(10, "홍길동", "hong@gmail.com");
		Person p2 = new Person(20, "김유신", "kimyoushin@naver.com");
		
		// String toString()
		// 객체에 대한 간단한 정보를 문자열로 반환한다.
		System.out.println(p1); // 참조변수값을 출력하면 참조변수.toString()의 반환값이 출력된다.
		System.out.println(p2);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}

}
