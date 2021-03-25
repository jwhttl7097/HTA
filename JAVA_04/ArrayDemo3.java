
public class ArrayDemo3 {
	
	public static void main(String[] args) {
		
		// 배열의 활용
		String[] names = {"김유신", "이순신", "홍길동"};
		int[] korScores = {100, 80, 30};
		int[] engScores = {80, 100, 50};
		int[] mathScores = {80, 100, 20};
		
		// 이번에 수업에 참여한 모든 학생의 이름을 출력하시오.
		System.out.println("### 수강신청 학생 목록 ###");
		for (String x : names) {
			System.out.println(x);
		}
		
		System.out.println("\n### 김유신 학생의 국어, 영어, 수학 점수 ###");
		// 김유신 학생의 성적을 전부 출력하시오.
		System.out.println(korScores[0] + ", " + engScores[0] + ", " + mathScores[0]);
		//System.out.println(korScores[1] + ", " + engScores[1] + ", " + mathScores[1]);
		//System.out.println(korScores[2] + ", " + engScores[2] + ", " + mathScores[2]);
		
		System.out.println("\n### 국어점수의 총점과 평균 ###");
		// 국어 점수의 평균을 출력하시오.
		// 국어점수의 총합을 계산한다.
		// 평균은 국어점수의 총합을 3으로 나누어서 계산한다.
		int korTotal = 0;
		int korAverage = 0;
		for(int kor : korScores) {
			korTotal += kor;	//korTotal += 100, korTotal += 80, korTotal += 30; 실행
		}
		korAverage = korTotal/korScores.length; //korAverage = korTotal/3;
		System.out.println("국어점수 총점 : " + korTotal);
		System.out.println("국어점수 평균 : " + korAverage);
		
		System.out.println("\n### 수학점수의 총점과 평균 ###");
		// 수학 점수의 평균을 출력하시오.

		int mathTotal = 0;
		int mathAverage = 0;
		for(int math : mathScores) {
			mathTotal += math;	
		}
		mathAverage = mathTotal/mathScores.length; 
		System.out.println("수학점수 총점 : " + mathTotal);
		System.out.println("수학점수 평균 : " + mathAverage);
		
		System.out.println("\n### 영어점수의 총점과 평균 ###");
		// 영어 점수의 평균을 출력하시오.
		int engTotal = 0;
		int engAverage = 0;
		for(int eng : engScores) {
			engTotal += eng;	
		}
		engAverage = engTotal/engScores.length; 
		System.out.println("영어점수 총점 : " + engTotal);
		System.out.println("영어점수 평균 : " + engAverage);
		
		System.out.println("\n### 이름,국어,영어,수학점수,총점,평균점수 출력 ###");
		// 각 학생별 학생이름, 국어, 영어, 수학점수, 총점, 평균점수를 출력하시오.
		// 김유신 100 80  80  260 89
		// 이순신 80  100 100 280 91
		// 홍길동 30  50  20  100 33
		/*
		 * 학생 및 성적정보
			String[] names = {"김유신", "이순신", "홍길동"};
			int[] korScores = {100, 80, 30};
			int[] engScores = {80, 100, 50};
			int[] mathScores = {80, 100, 20}; 
		 */
		for(int i=0; i<3; i++) {
			String studentName = names[i];
			int kor = korScores[i];
			int eng = engScores[i];
			int math = mathScores[i];
			
			int total = kor + eng + math;
			int average = total/3;
			
			System.out.println(studentName +"\t"+ kor +"\t"+ eng +"\t"+ math +"\t"+total+"\t"+average);
			//System.out.printf("%s%5d%5d%5d%5d%5d\n",studentName, kor, eng, math, total, average);
		}
		/*
		 	for(int i=0; i<names.length; i++) {
			String studentName = names[i];
			int kor = korScores[i];
			int eng = engScores[i];
			int math = mathScores[i];
			
			int total = kor + eng + math;
			int average = total/names.length;
			
			System.out.println(studentName +"\t"+ kor +"\t"+ eng +"\t"+ math +"\t"+total+"\t"+average);
		} 
		 */
	}
}
