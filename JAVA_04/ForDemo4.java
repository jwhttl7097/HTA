import java.util.Scanner;

public class ForDemo4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 반복문 탈출하기
		// break구문을 사용하면 반복문을 탈출할 수 있다.
		// break는 반복문(for문, while문, do~while문)과 switch문 내에서만 사용할 수 있다.
		// 반복문을 탈출할 때는 보통 제시된 조건에 해당될 때 break문을 실행해서 탈출한다.
		System.out.println("### 프로그램 시작 ###");
		
		for(int i=1; i<=10; i++) {
			System.out.println("숫자를 입력하세요");
			
			int number = sc.nextInt();
			System.out.println("입력한 숫자 : " + number);

			if(number <= 0) {	// 탈출조건. 사용자가 0이나 음수를 입력하면 반복문을 탈출한다.
				break;				
			}
		}
		
		sc.close();
		System.out.println("### 프로그램 종료 ###");
	}
}


/*
 int index = -1;
 for(int i=0; i<6; i++){
 	i번째 값 가져오기
 	// i번째 값이 이순신과 일치하는지 확인하기
 	// i번째값이 이순신과 일치하면
 		index에 i번째 값을 대입한다.
 		반복문에서 탈출한다.(더이상 이순신을 찾을 필요없음)
 }
 */