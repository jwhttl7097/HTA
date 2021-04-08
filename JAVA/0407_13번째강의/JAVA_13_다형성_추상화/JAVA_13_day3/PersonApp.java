package day3;

public class PersonApp {

	public static void main(String[] args) {
		Student student = new Student("홍길동", "hong@z.com", "010-1234-5678", 3, "컴퓨터공학과");
		student.displayInfo();
		
		Professor professor = new Professor("김유신", "kim@naver.com", "010-2222-3333", "컴퓨터공학과", "정교수");
		professor.displayInfo();

	}

}
