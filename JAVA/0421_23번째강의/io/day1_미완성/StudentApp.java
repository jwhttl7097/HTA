package day1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		try {
			while(true) {
				System.out.println("-------------------------------------------------");
				System.out.println("1.전체조회  2.추가  3.검색  4.삭제  5.석차  0.종료");
				System.out.println("-------------------------------------------------");
				
				System.out.print("메뉴를 선택하세요 : ");
				int menuNo = sc.nextInt();
				System.out.println();
				
				if(menuNo == 1) {
					System.out.println("[전체조회]");
					ArrayList<Student> students = service.getAllStudentList();
					if(students.isEmpty()) {
						System.out.println("[안내] 등록된 학생정보가 없습니다.");
					} else {
						System.out.println("학생명\t총점\t평균");
						for (Student student : students) {
							System.out.print(student.getName() + "\t");
							System.out.print(student.getTotal() + "\t");
							System.out.println(student.getAverage());
						}
					}
				} else if (menuNo == 2) {
					System.out.println("[추가]");
					System.out.print("이름 입력 : ");
					String name = sc.next();
					System.out.print("국어점수 입력 : ");
					int kor = sc.nextInt();
					System.out.print("영어점수 입력 : ");
					int eng = sc.nextInt();
					System.out.print("수학점수 입력 : ");
					int math = sc.nextInt();
					
					Student student = new Student(name, kor, eng, math);
					service.addNewStudent(student);
					System.out.println("[안내] 새 학생정보가 추가되었습니다.");
					
				} else if (menuNo == 3) {
					System.out.println("[검색]");
				} else if (menuNo == 4) {
					System.out.println("[삭제]");
				} else if (menuNo == 5) {
					System.out.println("[석차]");
				} else if (menuNo == 0) {
					System.out.println("[프로그램 종료]");
					service.saveAllstudentData();
					break;
				}
				System.out.println();
				System.out.println();
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("[오류]" + e.getMessage());
		}
		sc.close();
		
	}
}
