package testPackages;

public class TestAccount2_0330 {

//	Account2.java 클래스는 예금주, 비밀번호, 잔액정보를 저장하는 객체를 위한 클래스다.
//    위의 정보를 담는 멤버변수를 정의한다.
// Account2.java 클래스는 입금기능, 계좌정보 출력기능을 지원하는 객체를 위한 클래스다.
//    위의 기능이 지원되는 멤버메소드를 정의한다.
//    입금기능 void deposit(long amount) { ... }
//     * 전달받은 금액만큼 멤버변수의 잔액을 증가시킨다.
//    출금기능 void withdraw(long amount, int password) { ...}
//                    * 전달받은 비밀번호와 멤버변수의 비밀번호가 일치하면
//     * 전달받는 금액만큼 멤버변수의 잔액을 감소시킨다.
//    계좌정보 출력기능 void displayInfo() { ... }
//     * 멤버변수에 저장된 예금주, 잔액정보를 화면에 출력한다.
	
	String name;
	int pw;
	int balance;
	
	// 입금
	void deposit(long amount) {
		balance += amount;
	}
	
	// 출금
	void withdraw(long amount, int password) {
		if (pw == password) {
			balance -= amount;
		}
	}
	
	// 계좌정보 출력
	void displayInfo() {
		System.out.println("예금주 : " + name);
		System.out.println("잔액정보 : " + balance);
	}
}
