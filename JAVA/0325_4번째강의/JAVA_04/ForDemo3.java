
public class ForDemo3 {
	
	public static void main(String[] args) {
		//내포된 for문
		//실행횟수가 많아져서 복잡해짐
		for (int i=1; i<=3; i++) {
			System.out.println("바깥쪽 for문의 수행문");
			for(int j=1; j<=5; j++) {
				System.out.println("안쪽 for문의 수행문");
			}
		}
	}
}
