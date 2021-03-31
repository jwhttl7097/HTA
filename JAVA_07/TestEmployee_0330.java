package testPackages;

public class TestEmployee_0330 {
//	 Employee.java는 사원번호, 사원이름, 소속부서명, 직위, 급여, 커미션지급여부를 정보를 저장하는 객체를 위한 클래스다.
//     위의 정보를 담는 멤버변수를 정의한다.
//     위의 정보를 화면에 출력하는 void printEmployeeInfo() 메소드를 정의한다.
	int no;
	String name;
	String department;
	String rank;
	int salary;
	boolean incentive;
	
	void printEmployeeInfo() {
		System.out.println("사원번호 : " + no);
		System.out.println("사원이름 : " + name);
		System.out.println("소속부서명 : " + department);
		System.out.println("직위 : " + rank);
		System.out.println("급여 : " + salary);
		System.out.println("커미션지급여부 : " + incentive);
	}
}
