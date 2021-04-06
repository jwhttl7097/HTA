package testPackages;

import java.util.Iterator;
import java.util.Scanner;

public class Test_0324 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
//		1. Scanner / 조건연산자 ( 조건식 ? 값1 : 값2; )
		// 이름, 국어, 영어, 수학점수를 입력받아서 총점, 평균을 계산하고 , 계산된 결과를 화면에 출력한다.
		// 평균이 90점 이상이면 장학금 지급 대상이 된다.
		
//		
//		System.out.println("이름을 입력하세요. : ");
//		String name = sc.next();
//		System.out.println("국어 점수를 입력하세요. : ");
//		double korean = sc.nextDouble();
//		System.out.println("영어 점수를 입력하세요. : ");
//		double english = sc.nextDouble();
//		System.out.println("수학 점수를 입력하세요. : ");
//		double math = sc.nextDouble();
//		double totalScore = korean + english + math;
//		double avg = totalScore / 3;
//		
//		System.out.println("평균 점수 : " + avg);
//		System.out.println(avg >= 90 ? "장학금 지급 대상입니다." : "장학금 지급 대상이 아닙니다.");
		

//		2. Scanner 
		/*
		 * 제품명, 가격, 구매수량을 입력받는다.
		 * 출력내용은 제품명, 가격, 구매수량, 총구매가격, 적립포인트다.
		 * 적립포인트는 총구매가격의 1%다. 
		 */
		
//		System.out.println("제품명을 입력하세요 : ");
//		String productName = sc.next();
//		System.out.println("가격을 입력하세요 : ");
//		double price = sc.nextDouble();
//		System.out.println("구매수량을 입력하세요 : ");
//		int amount = sc.nextInt();
//		double totalPrice = (price * amount);
//		double point = (totalPrice * 0.01);
//		
//		System.out.println("=================");
//		System.out.println("제품명" + productName);
//		System.out.println("가격" + price);
//		System.out.println("구매수량" + amount);
//		System.out.println("총 구매가격" + totalPrice);
//		System.out.println("적립포인트" + point);
		

//		3. Scanner / 논리연산자,비교연산자 
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
		
//		System.out.println("고객명을 입력하세요 : ");
//		String customer = sc.next();
//		
//		System.out.println("등급을 선택하세요 : ");
//		int grade = sc.nextInt();
//		switch (grade) {
//		case 1:
//			grade = 1;
//			break;
//			
//		case 2:
//			grade = 2;
//			break;
//
//		case 3:
//			grade = 3;
//			break;
//
//		default: 
//			System.out.println("잘못 입력하셨습니다.");
//			break;
//		}
//		
//		System.out.println("누적 구매횟수를 입력하세요 : ");
//		int orderCount = sc.nextInt();
//		
//		System.out.println("당일 총구매금액을 입력하세요 : ");
//		int totalPrice = sc.nextInt();
//		
//		double point;
//		if(grade == 1) {
//			point = totalPrice * 0.03;
//		} else {
//			point = totalPrice * 0.01;
//		}
//		
//		String gift;
//		if(grade == 1 || orderCount >= 5 || totalPrice >= 300000) {
//			gift = "사은품 지급대상임";
//		} else {
//			gift = "사은품 지급대상이 아닙니다";
//		}
//			
//		System.out.println("====================");
//		System.out.println("고객이름 :" + customer);
//		System.out.println("고객등급 : " + grade + "등급");
//		System.out.println("누적구매횟수 : " + orderCount);
//		System.out.println("당일총구매금액 : " + totalPrice);
//		System.out.println("적립포인트 : " + point);
//		System.out.println("사은품지급여부 : " + gift);
		
//		4. if ~ else if문
		/*
		 * 91점 이상이면 "A", 81점 이상이면 "B", 71점 이상이면 "C"
		 * 61점 이상이면 "D", 60점 이하는 "F"를 출력한다. 
		 */
		
//		System.out.println("점수를 입력하세요 : ");
//		int score = sc.nextInt();
//		if(score >= 91) System.out.println("A");
//		else if(score >= 81) System.out.println("B");
//		else if(score >= 71) System.out.println("C");
//		else if(score >= 61) System.out.println("D");
//		else if(score <= 60) System.out.println("F");
		
		
//		5. Scanner / 중첩 if문  
		/*
		 * 내포된 if문 사용하기
		 * 고객명, 고객등급, 총구매금액을 입력받는다.
		 * 고객등급이 1등급인 경우, 총구매금액의 3%를 적립포인트를 지급한다.
		 * 	단, 총구매금액이 100만원을 초과하는 경우, 
		 * 	100만원을 제외한 나머지 금액에 대해서는 5%를 적립한다.
		 * 그 외는 총구매금액에 관계없이 총구매금액의 1%를 적립포인트로 지급한다.
		 * 
		 * 고객명, 고객등급, 총구매금액, 적립포인트를 출력한다.
		 * 
		 */
		
//		Test_0324 Test_0324 = new Test_0324();
//		Test_0324.po();
		
//		6. Scanner / if문 / 중첩 if문
		/*
		 * 학생이름, 전자계산기, 데이터베이스, 알고리즘 점수를 입력받는다.
		 * 학생이름, 각 과목점수, 총점, 평균, 합격여부를 출력한다.
		 * 평균이 60점 이상이면 합격이다.
		 * 한 과목이라도 40점 미만인 경우는 불합격이다.
		 */
		
//		System.out.println("학생이름을 입력해주세요 : ");
//		String studentName = sc.next();
//		System.out.println("전자계산기 점수 입력 : ");
//		double cal = sc.nextDouble();
//		System.out.println("DB 점수 입력 : ");
//		double dataBase = sc.nextDouble();
//		System.out.println("알고리즘 점수 입력 : ");
//		double al = sc.nextDouble();
//		
//		double total = cal + dataBase + al;
//		double avg = total/3;
//		
//		System.out.println("학생이름 : " + studentName);
//		System.out.println("전자계산기 : " + cal);
//		System.out.println("DB : " + dataBase);
//		System.out.println("알고리즘 : " + al);
//		System.out.println("총점 : " + total);
//		System.out.println("평균 : " + avg);
//		if(avg >= 60) {
//			if(cal < 40 || dataBase < 40 || al <40) {
//				System.out.println("합격여부 : 불합격(과락)");
//			} else {
//				System.out.println("합격여부 : 합격");
//			}
//		} else {
//			System.out.println("합격여부 : 불합격");
//		}
		
		
//		7. Scanner / if문 / 중첩 if문 / else if문
		/*
		 * 고객명, 고객등급, 총구매금액을 입력받는다.
		 * 고객명, 고객등급, 총구매금액, 적립포인트, 보너스포인트를 출력한다.
		 * 
		 * 등급별 적립포인트는 1등급은 5%, 2등급은 3%, 3등급은 1%다.
		 * 보너스포인트 지급기준 
		 *       1등급은 300만원 초과한 부분에 대해서 10% 추가포인트 지급
		 *       2등급은 150만원 초과한 부분에 대해서 5% 추가포인트 지급
		 *       3등급은 100만원 초과한 부분에 대해서 3% 추가포인트 지급  
		 */
//		8. for문 
		//1~10까지 출력하기
//		for(int i = 1; i <= 10; i++) {
//			System.out.println(i);
//		}
		
		//구구단 2단 출력하기
//		for(int i = 1; i<10; i++) {
//			int a = 2;
//			System.out.println("2" + "*" + i + " : " + a*i );
//		}
		//합계 구하기 (1~100 / 1001~2000)
//		int sum = 0;
//		for (int i = 1; i < 101; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
		
//		int sum = 0;
//		for (int i = 1001; i < 2001; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
		
	}
	
//	public void po() {
//		System.out.println("고객명을 입력하세요 : ");
//		String customer = sc.next();
//		
//		System.out.println("등급을 선택하세요 : ");
//		int grade = sc.nextInt();
//		switch (grade) {
//		case 1:
//			grade = 1;
//			break;
//			
//		case 2:
//			grade = 2;
//			break;
//
//		case 3:
//			grade = 3;
//			break;
//
//		default: 
//			System.out.println("잘못 입력하셨습니다.\n");
//			po();
//			break;
//		}
//		
//		System.out.println("총구매금액을 입력하세요 : ");
//		int totalPrice = sc.nextInt();
//		
//		double point = 0.0;
//		
//		if(grade == 1) {
//			point = totalPrice * 0.03;
//			if(totalPrice > 1000000){
//				point = (1000000 * 0.03) + ((totalPrice - 1000000) * 0.05);
//			} 
//		} else {
//			point = totalPrice * 0.05;
//		}
//		
//		System.out.println("====================");
//		System.out.println("고객이름 :" + customer);
//		System.out.println("고객등급 : " + grade + "등급");
//		System.out.println("총구매금액 : " + totalPrice);
//		System.out.println("적립포인트 : " + point);
//		
//		}
}
