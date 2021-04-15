package sample5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		/*
		 * 학생성적 관리 프로그램
		 * 1. 학생 성적정보 입력기능
		 * 		이름, 국어, 영어, 수학점수를 입력 받아서 ArrayList에 저장
		 * 2. 학생 성적정보 전체 조회 기능
		 * 		ArrayList에 저장된 학생들의 이름, 총점, 평균을 출력
		 * 3. 학생 성적정보 상세 조회 기능
		 * 		학생이름을 입력 받아서 그 학생의 이름, 국어, 영어, 수학, 총점, 평균을 출력
		 * 4. 학생 성적정보 성적순 출력 기능(고득점 -> 저득점:총점기준)
		 * 		Comparable<T> 혹은 Comparator<T>를 이용해서 총점이 높은 학생부터 낮은 학생순으로 출력
		 */
		ArrayList<Student> students = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while (flag) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1.성적입력  2.성적전체조회  3.성적정보 상세조회  4.성적순위 출력  0.종료");
			System.out.println("--------------------------------------------------------");
			System.out.println();
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = sc.nextInt();
			
			switch (menuNo) {
			case 1:
				System.out.println("학생성적 입력");
				System.out.print("학생이름을 입력하세요 : ");
				String name = sc.next();
				System.out.print("국어 성적을 입력하세요 : ");
				int kor = sc.nextInt();
				System.out.print("영어 성적을 입력하세요 : ");
				int eng = sc.nextInt();
				System.out.print("수학 성적을 입력하세요 : ");
				int math = sc.nextInt();
				students.add(new Student(name, kor, eng, math, 0, 0));
				if(students.isEmpty()) {
					System.out.println("잘못입력하셨습니다.");
				} else {
					System.out.println("학생정보등록 완료");
				}
				break;

			case 2:
				System.out.println("성적 전체 조회 하기");
				for (Student student : students) {
					System.out.println("학생이름 : " + student.getName());
					System.out.println("국어 : " + student.getKor());
					System.out.println("영어 : " + student.getEng());
					System.out.println("수학 : " + student.getMath());
					System.out.println("총점 : " + student.getTotal());
					System.out.println("평균 : " + student.getAverage());
					System.out.println();
				}
				break;

			case 3:
//				3. 학생 성적정보 상세 조회 기능
//					학생이름을 입력 받아서 그 학생의 이름, 국어, 영어, 수학, 총점, 평균을 출력
				System.out.println("학생 성적정보 상세 조회");
				boolean foundName = false;
				
				System.out.print("학생이름을 입력하세요 : ");
				name = sc.next();
				for (Student student : students) {
					if(student.getName().equals(name)) {
						foundName = true;
						System.out.println("학생이름 : " + student.getName());
						System.out.println("국어 : " + student.getKor());
						System.out.println("영어 : " + student.getEng());
						System.out.println("수학 : " + student.getMath());
						System.out.println("총점 : " + student.getTotal());
						System.out.println("평균 : " + student.getAverage());
						System.out.println();
					} 
				}
				if(!foundName) {
					System.out.println("해당학생은 존재하지 않습니다.");
				}
				
				break;

			case 4:
//				4. 학생 성적정보 성적순 출력 기능(고득점 -> 저득점:총점기준)
//				 * 		Comparable<T> 혹은 Comparator<T>를 이용해서 총점이 높은 학생부터 낮은 학생순으로 출력
				Collections.sort(students, (o1, o2) -> o1.getTotal() - o2.getTotal());
				Collections.reverse(students);
				
				for (Student student : students) {
					System.out.print("학생이름 : " + student.getName()+ ", ");
					System.out.print("총점 : " + student.getTotal()+ ", ");
					System.out.println("평균 : " + student.getAverage());
					System.out.println();
				}				
				break;

			case 0:
				System.out.println("프로그램 종료");
				flag = false;
				break;

			default:
				break;
			}
			
		}
	}

}
