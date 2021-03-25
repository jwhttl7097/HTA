
public class ForDemo1 {

	public static void main(String[] args) {

		//수행문을 10개 실행하기
		for(int i=0; i<10; i++) {
			System.out.println("안녕하세요");			
		}

		System.out.println("------------------------");

		for(int i=10; i>0; i--) {
			System.out.println("안녕하세요");
		}

		System.out.println("------------------------");

		//1~10까지 출력하기
		for(int i=1; i<11; i++) {
			System.out.println(i);
		}
		
		System.out.println("------------------------");

		// 구구단 출력하기
		int dan = 2;
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}

		System.out.println("-----------------------------");

		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i+"x"+j+"="+i*j);
			}
		}
		
		System.out.println("-----------------------------");

		// 합계 구하기
		// 1 ~ 100까지 합계를 구하고 출력한다.
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("-----------------------------");
		
		// 합계 구하기
		// 1001 ~ 2000까지 합계를 구하고 출력한다.
		sum = 0;
		//int sum2 = 0;
		for (int i=1001; i<=2000; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
