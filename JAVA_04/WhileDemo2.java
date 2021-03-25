import java.util.Scanner;

public class WhileDemo2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// balance는 잔액을 저장하는 변수(저장소)
		int balance = 10000;
		
		// 이 반복문은 무한반복되도록 처리되어 있다.
		while(true) {
			System.out.println("===========================");
			System.out.println("    1.결제  2.충전  0.종료    ");
			System.out.println("===========================");
			
			// 사용자가 입력한 메뉴번호는 menuNo 변수에 저장(대입)된다.
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = sc.nextInt();
			
			if(menuNo == 1) { // menuNo변수에 저장된 값이 1일 때 실행되는 코드블록이다.
				System.out.println("[결제를 진행합니다.]");
				
				// 사용자가 입력한 사용금액은 amount 변수에 저장된다.
				System.out.print("사용금액을 입력하세요 : ");
				int amount = sc.nextInt();
				
				if(balance >= amount) { // 잔액이 사용금액보다 크거나 같을 때 실행되는 코드블록이다.
					// 사용금액만큼 잔액에서 차감하고, 결제 후 잔액을 출력한다.
					balance -= amount;
					System.out.println("사용금액 : " + amount + "원");
					System.out.println("결제 후 잔액 : " + balance + "원");
					System.out.println("[결제가 완료 되었습니다.]");
				}else {					// 잔액이 사용금액보다 작을 때 실행되는 코드블록이다.
					System.out.println("[에러] 잔액이 부족합니다.");
					System.out.println("현재 잔액 : " + balance + "원");
					System.out.println("[결제를 중단합니다.]");
				}
			
			}else if(menuNo == 2) { // menuNo변수에 저장된 값이 2일 때 실행되는 코드 블록이다.
				System.out.println("[충전를 진행합니다.]");
				
				//사용자가 입력한 충전금액은 amount 변수에 저장된다.
				System.out.print("충전할 금액을 입력하세요 : ");
				int amount = sc.nextInt();
				//amount에 저장된 충전금액을 balance변수에 저장된 값에 더하고, 현재잔액을 출력한다.
				balance += amount; //남아있는 잔액에 충전금액을 더한다.
				System.out.println("충전 후 잔액 : " + balance);
				
				System.out.println("[충전이 완료되었습니다.]");

			}else if(menuNo == 0) { // menuNo변수에 저장된 값이 0일 때 실행되는 코드 블록이다.
				System.out.println("[서비스를 종료합니다.]");
				break;
				
			}else { // menuNo변수에 저장된 값이 0,1,2 모두와 일치하지 않을 때 실행되는 코드블록이다.
				System.out.println("[에러] 메뉴를 다시  선택하세요");
			}
			
			System.out.println();	//빈 줄을 추가한다
			System.out.println();	//빈 줄을 추가한다
			System.out.println();	//빈 줄을 추가한다
			
		}
		sc.close();
	}
}
