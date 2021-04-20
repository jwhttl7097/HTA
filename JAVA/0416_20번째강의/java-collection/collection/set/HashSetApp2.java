package collection.set;

import java.util.HashSet;
import java.util.Random;

public class HashSetApp2 {		//HashSet -> 중복허용 안함.

	public static void main(String[] args) {
		System.out.println("HashSet으로 로또번호 뽑기 (자동중복제외)");
		
		HashSet<Integer> lottoNumbers = new HashSet<Integer>();
		
		Random random = new Random();
		while(true) {
			int number = random.nextInt(45) + 1;
			lottoNumbers.add(number);	// lottoNumbers.add(new Integer (number));
			
			if(lottoNumbers.size() == 6) {
				break;
			}
		}
		System.out.println();
		System.out.println(lottoNumbers);
	}

}
