package day4;

import java.util.Scanner;

// App(main)은 사용자와 상호작용하는 역할을 수행 (service에게 메소드 호출 요청)
public class StudentApp {

	public static void main(String[] args) {
		
		final int DISPLAY_ALLSTUDENTS = 1;
		final int DISPLAY_STUDENT = 2;
		final int INSERT_STUDENT = 3;
		final int UPDATE_STUDENT = 4;
		final int EXIT = 0;
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		
		while(flag) {
			System.out.println("================================================");
			System.out.println("1.전체조회    2.상세조회    3.등록    4.수정    0.종료");
			System.out.println("================================================");
			
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = sc.nextInt();
			switch (menuNo) {
				case DISPLAY_ALLSTUDENTS:
					System.out.println("[모든 학생정보 출력]");
					service.displayAllStudent();
					break;
				case DISPLAY_STUDENT:
					System.out.println("[학생 상세정보 출력]");
					System.out.println("조회할 학생명을 입력하세요.");
					String studentName = sc.next();
					service.displayStudent(studentName);
					break;
				case INSERT_STUDENT:
					System.out.println("[학생정보 등록]");
					
					System.out.println("학생명을 입력하세요 : ");
					String name = sc.next();
					System.out.println("국어점수를 입력하세요 : ");
					int kor = sc.nextInt();
					System.out.println("영어점수를 입력하세요 : ");
					int eng = sc.nextInt();
					System.out.println("수학점수를 입력하세요 : ");
					int math = sc.nextInt();
					
					Student student = new Student(name, kor, eng, math);
					service.insertStudent(student);
					
					break;
				case UPDATE_STUDENT:
					System.out.println("[학생정보 수정]");
					
					System.out.println("학생명을 입력하세요 : ");
					String name4 = sc.next();
					System.out.println("국어점수를 입력하세요 : ");
					int kor4 = sc.nextInt();
					System.out.println("영어점수를 입력하세요 : ");
					int eng4 = sc.nextInt();
					System.out.println("수학점수를 입력하세요 : ");
					int math4 = sc.nextInt();
					
					Student student1 = new Student(name4, kor4, eng4, math4);
					service.updateStudent(student1);
					
					break;
				case EXIT:
					System.out.println("[프로그램 종료]");
					flag = false;
					break;
	
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
			}
			System.out.println();
			System.out.println();
			System.out.println();
			
		}
		sc.close();
	}
}
