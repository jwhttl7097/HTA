import java.util.Scanner;

public class Example4 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 고객이름, 고객등급(1,2,3 중 하나다), 누적구매횟수, 당일총구매금액을 입력받는다.
		 * 고객이름, 고객등급, 누적구매횟수, 당일총구매금액, 적립포인트, 사은품지급여부를 출력한다.
		 * 적립포인트는 1등급고객의 경우 당일구매금액의 3%고, 나머지는 1%다.
		 * 사은품지급여부는 등급이 1등급이거나, 누적구매횟수가 5회이상이거나, 당일총구매금액이 30만원이상이면
		 * 사은품 지급 대상이다.(사은품 지급 여부는 "지급대상임", "지급대상이아님"으로 출력한다.)
		 * 
		 * 적립포인트와 사은품지급여부를 계산할 때는 조건식 ? 값1 : 값2;
		 * 조건 연산자의 조건식은 true/false가 최종연산결과로 나오는 비교연산자, 논리연산자를 사용한다.
		 */
		
		//고객이름을 입력하세요를 출력한다.
		//고객이름을 읽어서 변수에 저장한다.
		System.out.println("고객이름을 입력하세요");
		String customerName = scanner.next();
		
		//고객등급(1,2,3)을 입력하세요를 출력한다.
		//고객등급을 읽어서 변수에 저장한다.
		System.out.println("고객등급을 입력하세요");
		int customerGrade = scanner.nextInt();
		
		//누적구매횟수를 입력하세요를 출력한다.
		//누적구매횟수를 읽어서 변수에 저장한다.
		System.out.println("누적구매횟수를 입력하세요");
		int totalOrderCount = scanner.nextInt();
		
		//당일총구매금액을 입력하세요를 출력한다.
		//당일총구매금액을 읽어서 변수에 저장한다.
		System.out.println("당일총구매금액을 입력하세요");
		int todayTotalOrderPrice = scanner.nextInt();
		
		//당일총구매금액과 적립률로 포인트를 계산한다.
		//포인트는 1등급인 경우와 아닌 경우로 구분해서 계산한다.
		double point = customerGrade == 1 ? todayTotalOrderPrice * 0.03 : todayTotalOrderPrice * 0.01;
		//int point = (int) (customerGrade == 1 ? todayTotalOrderPrice * 0.03 : todayTotalOrderPrice * 0.01);
		
		//사은품지급대상인지 여부를 판정해서 변수에 저장한다.
		//위에서 제시한 사은품지급대상일 경우만 "지급대상"임을, 아닌 경우에는 "지급대상아님"이 변수에 저장된다.
		String gift = customerGrade == 1 || totalOrderCount >= 5 || todayTotalOrderPrice >= 300000 ? "지급대상" : "지급대상아님";
		//boolean result = customerGrade == 1 || totalOrderCount >= 5 || todayTotalOrderPrice >= 300000;
		//String gift = result ? "지급대상임" : "지급대상아님";
		
		//모든 내용을 출력한다.
		System.out.println("=======================================");
		System.out.println("고객이름 : " + customerName);
		System.out.println("고객등급 : " + customerGrade);
		System.out.println("누적구매횟수 : " + totalOrderCount);
		System.out.println("당일총구매금액 : " + todayTotalOrderPrice);
		System.out.println("적립포인트 : " + point);
		System.out.println("사은품지급여부 : " + gift);
		System.out.println("=======================================");
		
	}
}
