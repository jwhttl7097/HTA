public class OpDemo5 {

	public static void main(String[] args) {
		
		// 논리연산자
		// && || !
		// 두 이상의 비교 연산 결과를 합쳐서 최종 결과를 획득할 때 사용되는 연산자 (!는 제외)
		// 논리연산자의 좌항/우항에는 불린값이 오거나, 식의 연산결과가 불린값인 것만 위치할 수 있습니다.
		
		// 자동차 유상처리 판정하기
		// 주행거리가 10만km이상이거나 사용기간이 3년 이상인 차량은 유상수리 대상이다.
		// 논리합 (둘 중의 한개만 되도 유상수리기 때문에)
		int distance = 50000;
		int usedYear = 2;
		
		boolean result1 = distance >= 100000 || usedYear >= 3;
		System.out.println("유상수리 여부 판정결과 : " + result1);
		
		// 사은품 지급 기준
		// 고객의 등급(1,2,3등급이 있음)이 2등급보다 높거나 같고, 구매금액이 10만원 이상인 경우 사은품 지급 대상이다.
		// 논리곱 (둘 다 해당해야 지급 가능)
		int grade = 3;
		int orderPrice = 500000;
		boolean result2 = grade <= 2 && orderPrice >= 100000;
		System.out.println("사은품 지급 여부 판정결과 : " + result2);
		
		// 장학금 지급 기준
		// 국어, 영어, 수학 점수의 평균이 90점 이상이고, 국어점수가 95점이상인 경우 장학금 지급 대상이다.
		// 변수명 - kor, eng, math, result3
		int kor = 90;
		int eng = 90;
		int math = 100;
		int average = (kor+eng+math)/3 ;
		boolean result3 = average >= 90 && kor >= 95;
		System.out.println("장학금 지급 판정결과 : " + result3);
		
		// 포인트 지급 기준
		// 구매횟수가 10회 이상이거나, 당일 구매금액이 100만원 이상인 경우 포인트 지급 대상이다.
		// 변수명 - orderCount, orderPrice, result4
		int orderCount = 15;
		int todayOrderPrice = 1000;
		boolean result4 = orderCount >= 10 || todayOrderPrice >= 1000000;
		System.out.println("포인트 지급 결과 : " + result4);
		
	}
}
