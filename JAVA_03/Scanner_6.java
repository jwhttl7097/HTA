import java.util.Scanner;

public class Example6 {
	public static void main(String[] args) {
		/*
	     * 고객명, 고객등급, 총구매금액을 입력받는다.
	     * 고객명, 고객등급, 총구매금액, 적립포인트, 보너스포인트를 출력한다.
	     * 
	     * 등급별 적립포인트는 1등급은 5%, 2등급은 3%, 3등급은 1%다.
	     * 보너스포인트 지급기준 
	     *       1등급은 300만원 초과한 부분에 대해서 10% 추가포인트 지급
	     *       2등급은 150만원 초과한 부분에 대해서 5% 추가포인트 지급
	     *       3등급은 100만원 초과한 부분에 대해서 3% 추가포인트 지급  
	     */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("고객명을 입력하세요");
		String name = sc.next();
		
		System.out.println("고객등급을 입력하세요");
		int grade = sc.nextInt();
		
		System.out.println("총구매금액을 입력하세요");
		int totalPrice = sc.nextInt();
		
		int point = 0;
		int bonusPoint = 0;
		
		/*
		if (grade == 1) {
			point = (int) (totalPrice * 0.05);
			if(totalPrice > 3000000) {
				bonusPoint = point + 300000;
			}else {
				System.out.println(point);
			}
		}else if(grade == 2){
			point = (int) (totalPrice * 0.05);
			if(totalPrice > 1500000) {
				bonusPoint = point + 75000;
				System.out.println(bonusPoint);
			}else {
				System.out.println(point);
			}			
		}else if(grade == 3){
			point = (int) (totalPrice * 0.03);
			if(totalPrice > 1000000) {
				bonusPoint = point + 30000;
				System.out.println(bonusPoint);
			}else {
				System.out.println(point);
			}
		}
		*/
		
		if(grade == 1) {
			if(totalPrice > 3000000) {
				bonusPoint = (int)((totalPrice - 3000000) * 0.1);
				point = bonusPoint + (int)(3000000*0.05);
			}else {
				point = (int) (totalPrice*0.05);
			}
		}else if(grade == 2) {
			if(totalPrice > 1500000) {
				bonusPoint = (int)((totalPrice - 1500000) * 0.05);
				point = bonusPoint + (int)(1500000*0.03);
			}else {
				point = (int) (totalPrice*0.03);
			}
		}else if(grade == 3) {
			if(totalPrice > 1000000) {
				bonusPoint = (int)((totalPrice - 1000000) * 0.03);
				point = bonusPoint + (int)(1000000*0.01);
			}else {
				point = (int) (totalPrice*0.01);
			}
		}
	
		
		System.out.println("=========================");
		System.out.println("고객명 : " + name);
		System.out.println("고객등급 : " + grade);
		System.out.println("총금액 : " + totalPrice);
		System.out.println("적립포인트 : " + point);
		System.out.println("보너스포인트 : " + bonusPoint);
		System.out.println("=========================");
		
	}
}
