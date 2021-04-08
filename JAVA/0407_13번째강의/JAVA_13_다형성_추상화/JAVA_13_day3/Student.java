package day3;

public class Student extends Person{

	private int grade;
	private String dept;
	
	public Student() {
		super();
	}
	
	public Student(String name, int grade, String dept) {
		super(name);				// 부모객체의 생성자 실행
		this.grade = grade;
		this.dept = dept;
	}
	
	public Student(String name, String email, String tel, int grade, String dept) {
		super(name, email, tel);	// 부모객체의 생성자 실행
		this.grade = grade;
		this.dept = dept;
	}

	public int getGrade() {
		return grade;
	}

	public String getDept() {
		return dept;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("학년 : " + grade);
		System.out.println("학과 : " + dept);
	}
	
}
