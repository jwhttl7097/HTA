import java.util.Arrays;

public class ArrayDemo6 {

	public static void main(String[] args) {

		/*
		* 난수를 활용해서 로또 번호 만들기
		* 난수는 수행문이 실행될 때 마다 생성되는 임의의 숫자다.
		* 자바는 Math 클래스에 여러 가지 수학연산과 관련된 기능을 가지고 있고,
		* 난수를 생성하는 기능도 가지고 있다.
		* 난수 만들기 Math.random() 메소드를 사용해서 난수를 생성한다.
		* 0 <= Math.random() < 1 난수의 범위다.
		*/ 

		/*
		 * 로또번호 생성하기 
		 * 1. 번호를 저장할 배열을 생성한다. 
		 * 2. 중복체크가 끝난 숫자를 배열의 몇번째 칸에 저장해야 하는지 그 위치를 기억하는 변수를 만든다. 
		 * 3. while문을 사용해서 중복이 없는 로또번호가 전부 만들어질때 까지 무한반복한다. 
		 * 		3-1. position값이 6이면 반복문을 탈출한다. 
		 * 		3-2. Math.random()을 이용해서 임의의 숫자(1~45)를 획득한다. 
		 * 		3-3. lotto배열에 3-2에서 획득한 숫자가 저장되어 있는지 여부를 조사한다. 
		 * 			3-3-1. lotto배열에 숫자가 존재하는지 여부를 담는 변수를 선언한다.(boolean타입의 변수) 
		 * 			3-3-2. for문을 사용해서 lotto배열에 저장된 값을 순서대로 조회 
		 * 			3-3-3. 3-2에서 획득한 번호와 일치하는지 조사해서 일치하면 숫자 존재여부를 true로 설정한다. 
		 * 		3-4. 저장여부를 조사했을 때 false로 판정되면,
		 * 			3-4-1. 3-2에서 획득한 숫자를 lotto배열에 position이 가르키는 위치에 저장한다. 
		 * 			3-4-2. position의 값을 1증가 시킨다. (숫자가 배열에 저장될 때만 position값이 1증가됨) 
		 * 4. 로또번호 정렬
		 * 5. 완성된 로또번호를 출력한다.
		 */
		
		int[] lotto = new int[6];								    // 1 로또용 배열 생성

		// 숫자를 저장할 위치를 기억하고 있는 변수
		int position = 0; 											// 2 중복여부 체크가 완료된 숫자가 저장될 위치를 기억하는 변수

		while (true) { 												// 3 숫자 뽑기 무한 반복
			if (position == 6) { 									// 3-1 반복문 중지여부 결정
				break;
			}
			int number = (int) (Math.random() * 45) + 1;			// 3-2 난수 획득

																	// 3-3 중복(존재)여부 조사
			boolean isExist = false; 								// 3-3-1
			for (int no : lotto) { 									// 3-3-2
				if (no == number) { 								// 3-3-3
					isExist = true;
					break;
				}
			}

			if (!isExist) { 										// 3-4 중복여부체크가 완료된 숫자를 로또 배열에 저장
				lotto[position] = number; 							// 3-4-1
				position++; 										// 3-4-2
			}
		}

		Arrays.sort(lotto);											// 4 로또번호 정렬

		for (int x : lotto) { 										// 5 로또번호 출력
			System.out.print(x + " ");
		}

	}

}
