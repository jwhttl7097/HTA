
public class IfDemo2 {
	
	public static void main(String[] args) {
		
		/*
		 * 91점 이상이면 "A", 81점 이상이면 "B", 71점 이상이면 "C"
		 * 61점 이상이면 "D", 60점 이하는 "F"를 출력한다. 
		 */
		int score = 95;
		
		// if ~ else if ~ else if ~ else 문을 사용하면 
		// 다양한 조건을 제시해야하는 조건문을 작성할 수 있다.
		if (score > 90) {
			System.out.println("A학점");
		} else if (score > 80) {
			System.out.println("B학점");
		} else if (score > 70) {
			System.out.println("C학점");
		} else if (score > 60) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}
		
	}
}
