
public class OpDemo1 {

	public static void main(String[] args) {
		
		// 사칙연산자
		// + - * / % 
		int num1 = 3;
		int num2 = 4;
		double num3 = 3.0;
		double num4 = 4.0;
		
		System.out.println(num1 + num2);	// 7
		System.out.println(num1 - num2);	// -1
		System.out.println(num1 * num2);		// 12
		System.out.println(num1 / num2);		// 0		정수/정수는 결과도 정수
		System.out.println(num3 / num4);		// 0.75		실수/실수는 결과도 실수
		System.out.println(num1 % num2);		// 3 		항상 나누는 수보다 하나 작은 수가 나옴 ex) 4로 나누면 3,2,1,0
		
		// 실수끼리의 연산은 예상과 다른 연산결과가 나올 수 있음
		// 실수에 10의 배수를 곱해서 정수로 만든 후 계산을 수행하고, 다시 10의 배수로 나눈다.
		double num5 = 0.1;
		double num6 = 0.2;
		System.out.println(num5 + num6);	// 0.30000000000000004
		System.out.println((num5 * 10 + num6 * 10) / 10);		//0.3
		//실수를 계산 할 때는 정수로 만들 수 있는 값을 곱한 후 그 수로 나눠야 정확한 값이 나옴
	}
}
