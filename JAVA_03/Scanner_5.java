import java.util.Scanner;

public class Example5 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/*
		 * 학생이름, 전자계산기, 데이터베이스, 알고리즘 점수를 입력받는다.
		 * 학생이름, 각 과목점수, 총점, 평균, 합격여부를 출력한다.
		 * 평균이 60점 이상이면 합격이다.
		 * 한 과목이라도 40점 미만인 경우는 불합격이다.
		 */
		
		// 학생이름, 각 과목 점수를 입력 받는다.
		// 학생이름을 입력하세요를 표준출력장치에 출력한다.
		System.out.println("학생이름을 입력하세요");
		// 스캐너객체의 next()를 실행시켜서 입력된 값을 읽어서 변수 이름에 저장한다.
		String name = sc.next();
		
		System.out.println("전자계산기 점수를 입력하세요");
		int electronicCalculator = sc.nextInt();
		
		System.out.println("데이터베이스 점수를 입력하세요");
		int database = sc.nextInt();
		
		System.out.println("알고리즘 점수를 입력하세요");
		int algorithm = sc.nextInt();
		
		// 총점을 계산한다.
		int totalScore = electronicCalculator + database + algorithm;
		// 평균을 계산한다.
		int average = totalScore/3;
		
		// 합격여부를 판정한다.
		if(electronicCalculator > 40 && database > 40 && algorithm > 40) {
			if(average > 59) {
				System.out.println("합격");
			}else {
				System.out.println("불합격");
			}
		}else {
			System.out.println("불합격(과목과락)");
		}
		
		/*
		String result = "";
		if(평균 >= 60) {
			if(electronicCalculator < 40 || database < 40 || algorithm < 40) { //과목과락인 경우
				result = "불합격(과목과락)입니다.";
			}else {
				result = "합격입니다.";
			}
		}else {
			result = "불합격입니다.";
		}
		*/
	
		// 총 정보 출력
		System.out.println("=========================");
		System.out.println("학생이름 : " + name);
		System.out.println("전자계산기 점수 : " + electronicCalculator);
		System.out.println("데이터베이스 점수 : " + database);
		System.out.println("알고리즘 점수 : " + algorithm);
		System.out.println("총점 : " + totalScore);
		System.out.println("평균 : " + average);
		System.out.println("=========================");
		
	}
}
