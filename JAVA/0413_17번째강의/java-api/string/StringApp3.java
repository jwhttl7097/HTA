package string;

public class StringApp3 {

	public static void main(String[] args) {
		// 정수, 실수, 문자, 불린값을 문자열로 바꾸기
		
		// String String.valuOf(boolean value)
		// String String.valuOf(int value)
		// String String.valuOf(long value)
		// String String.valuOf(double value)
		// String String.valuOf(char value)
		// 다양한 타입의 값을 문자열로 변환한 다음 반환한다.
		String value1 = String.valueOf(true);            //true -> "true"
	    String value2 = String.valueOf(100);            //100 -> "100"
	    String value3 = String.valueOf(100000000000000000L);//100000000000000000L ->"100000000000000000"
	    String value4 = String.valueOf(3.14);            //3.14 -> "3.14"
	    String value5 = String.valueOf('A');            //'A' -> "A"
 
				
	}
}
