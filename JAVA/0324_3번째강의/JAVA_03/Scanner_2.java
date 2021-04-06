
import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		// 표준입력장치로 입력한 내용을 읽어오는 Scanner 객체를 생성하고,
		// 그 객체의 주소값을 sc변수에 대입하게 함
		Scanner sc = new Scanner(System.in);
		
		// 생성된 Scanner객체의 메소드 사용하기(실행하기, 호출하기)
		// 생성된 Scanner객체의 메소드를 사용하기 위해서는 그 객체의 주소값이 저장된 sc변수가 필요하다.
		// 메소드의 실행 ----> 참조변수.메소드명();
		
		// 이름, 국어, 영어, 수학점수를 입력받아서 총점, 평균을 계산하고 , 계산된 결과를 화면에 출력한다.
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		
		System.out.println("국어점수를 입력하세요");
		int kor = sc.nextInt();
		
		System.out.println("영어점수를 입력하세요");
		int eng = sc.nextInt();
		
		System.out.println("수학점수를 입력하세요");
		int math = sc.nextInt();
		
		int totalScore = kor + eng + math;
		int average = totalScore/3;
		
		// 평균이 90점 이상이면 장학금 지급 대상이 된다.
		String result = average >= 90 ? "지급대상" : "지급대상 아님";
		
		System.out.println("###### 시험성적 ######");
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + totalScore);
		System.out.println("평균 : " + average);
		System.out.println("장학금 " + result);
	}
}
