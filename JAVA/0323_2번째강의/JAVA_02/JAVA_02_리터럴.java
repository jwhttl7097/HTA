
public class VarDemo2 {
	
	public static void main(String[] args) {
		
		/* 정수 리터럴 */
		int a = 1000000;
		int b = 1_000_000;
		int c = 010;	// 0으로 시작하면 8진수 10이다. 010 8이다.
		int d = 0x10;	// 0x로 시작하면 16진수 10이다.	0x10은 16이다.
		long e = 100000000000L;	// int타입 값의 범위는 -21억 ~ + 21억이다. 
								//int 범위를 넘어가는 값은 long 타입의 변수에 담는다. 접미사 L을 붙인다.
		
		/* 문자 리터럴 */
		char ch1 = 'A';
		char ch2 = '가';
		char ch3 = '韓';
		//char ch4 = '';	// 문자리터럴은 '반드시' 한 글자를 가지고 있어야 한다.
		char ch5 = ' '; // 공백도 한 글자다.
		
		// Escape 문자
		char ch6 = '\t';	// 탭 문자
		char ch7 = '\n';	// 줄바꿈 문자
		char ch8 = '\'';	// '
		char ch9 = '\"';	// "
		char ch10 = '\\';	// \
		
		//유니코드로 문자를 표현하기
		char ch11 = '\u0076';
		System.out.println(ch11);
		System.out.println('\uac00');	// 유니코드 ac00 '가'
		System.out.println('\uac01');	// 유니코드 ac01 '각'
		System.out.println('\uac02');	// 유니코드 ac02 '갂'
		
		String st1 = "";
		String st2 = " ";
		String st3 = "서울시 종로구 율곡로10길 105 디아망빌딩 402호";
		String st4 = "김유신\n강감찬\n이순신\n\uac00\uac01\uac02"; //문자열 안에 Escape,unicode 문자포함 가능
		System.out.println(st4);
		
		/* 실수 리터럴 */
		double d1 = 3.14;
		double d2 = 3.;
		double d3 = 3.0e4;	// 3.0x10^4
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
 		
		float f1 = 3.14f;	// 실수를 float타입의 변수에 저장할 때는 f를 접미사로 붙인다.
		float f2 = 3.f;
		float f3 = 3.0e4f;
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		/* 불린형 리터럴 */
		boolean b1 = true;	// boolean타입의 값은 오직 true, false 두 가지 뿐이다.
		boolean b2 = false;
		
	}
}
