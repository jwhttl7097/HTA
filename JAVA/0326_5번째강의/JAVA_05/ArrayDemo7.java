
public class ArrayDemo7 {

	public static void main(String[] args) {
		
		/*
		 * 다차원 배열
		 * 		1차원 배열
		 * 			int[] x = new int[3]
		 * 			int[] x = {1, 2, 3, 4, 5}
		 * 		2차원 배열
		 * 			타입[][] 변수명 = new 타입[행의 갯수][열의 갯수];
		 * 			타입[][] 변수명 = {{값, 값, 값}, {값, 값, 값}}
		 * 			String[][] x = new String[2][3];
		 * 			String[][] x = {{"김유신", "이순신", "강감찬"}, {"홍길동", "유관순", "안중근"}};
		 * 
		 * 		 ||===||============================||  	
		 * 		 ||	  ||    0	||	  1	  ||   2	||
		 * 		 ||===||============================||  
		 * 		 || 0 || "김유신" || "이순신" || "강감찬" || 
		 * 		 ||===||============================||
		 * 		 || 1 || "홍길동" || "유관순" || "안중근" ||
		 * 		 ||===||============================||
		 */
		
		// 다차원 배열(2행 3열 다차원 배열) 생성하기
		int[][] scores = {{70, 50, 80}, {100, 80, 100}};
		
		// 다차원 배열의 값 출력하기
		System.out.print(scores[0][0] + "\t");	// 70
		System.out.print(scores[0][1] + "\t");	// 50
		System.out.println(scores[0][2] + "\t");	// 80
		
		System.out.print(scores[1][0] + "\t");	// 100
		System.out.print(scores[1][1] + "\t");	// 80
		System.out.println(scores[1][2] + "\t" + "\n");	// 100
		
		// for문을 사용해서 다차원 배열의 모든 값을 출력하기
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
