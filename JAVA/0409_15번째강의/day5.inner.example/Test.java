package day5.inner.example;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
        int[] answer = new int[5];
		int[] numbers = {5, 2, 1, 3, 4};
		int sum = 0;
		
        
        for(int i = 0; i <= numbers.length; i++) {
            sum = numbers[i] + numbers[i+1];
            if(sum != answer[i]) {
                answer[i] = sum;
            }
        }
        Arrays.sort(answer);
	    
		
	}
}
