package testPackages;

public class TestEmployeeApp_0330 {

	public static void main(String[] args) {
//		EmployeeApp.java에서는
//      Employee객체를 생성한다.
//      생성된 Employee객체의 멤버변수에 사원정보를 저장한다.
//      생성된 Employee객체의 printEmployeeInfo() 메소드를 호출해서 회원정보를 화면에 출력한다.
		
		TestEmployee_0330 te = new TestEmployee_0330();
		te.no = 1;
		te.name = "홍길동";
		te.department = "경영";
		te.rank = "사원";
		te.salary = 3000000;
		te.incentive = false;
		
		te.printEmployeeInfo();
	}
	
}
