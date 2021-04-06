package testPackages;

import java.util.Scanner;

public class Test_0330 {

	public static void main(String[] args) {
		//   숫자 12345가 있다.
		//   1 + 2 + 3 + 4 + 5 ------> 15
		//   ex) 65486516 숫자일 경우에도 무조건 합이 나와야함
		//   %연산자를 사용해야 됨
		Scanner sc = new Scanner(System.in);
		
		String[] str;
		String no1;
		
		int num = 0;
		int sum = 0;
		
		System.out.println("숫자를 입력 하세요");
		num = sc.nextInt();
		
		while(num > 0) {
			sum += num%10;
			num /= 10;
		}
		System.out.println(sum);
		
		// split Integer.parseInt 사용
//		System.out.println("숫자를 입력 하세요");
//		no1 = sc.next();
//		
//		str = no1.split("");
//		for(int i = 0; i < str.length; i++) {
//			sum += Integer.parseInt(str[i]);
//		}
//		System.out.print("합계 : " + sum);
		
		
	}

}
