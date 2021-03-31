package testPackages;

public class TestAccountApp2_0330 {

	public static void main(String[] args) {
//		AccountApp2.java에서는
//        Account2객체를 생성한다.
//        생성된 Account2객체의 멤버변수에 예금주, 비밀번호, 잔액정보를 저장한다.
//        생성된 Account2객체의 계좌정보 출력기능을 실행해서 화면에 예금주, 잔액을 출력한다.
//        생성된 Account2객체의 입금기능을 실행한다.
//        생성된 Account2객체의 계좌정보 출력기능을 실행해서 화면에 예금주, 잔액을 출력한다.
//        생성된 Account2객체의 출금기능을 실행한다.
//        생성된 Account2객체의 계좌정보 출력기능을 실행해서 화면에 예금주, 잔액을 출력한다.
		
		TestAccount2_0330 ta = new TestAccount2_0330();
		// 예금주, 비밀번호, 잔액정보를 저장
		ta.name = "홍길동";
		ta.pw = 1234;
		ta.balance = 50000;
		
		System.out.println("계좌정보 출력");
		ta.displayInfo();
		
		// 입금
		System.out.println("### 입금");
		System.out.println("5천원 입금");
		ta.deposit(5000);
		System.out.println("계좌정보 출력");
		ta.displayInfo();
		
		//출금
		System.out.println("### 출금");
		System.out.println("1만5천원 출금");
		ta.withdraw(15000, 1234);
		System.out.println("계좌정보 출력");
		ta.displayInfo();
	}
}
