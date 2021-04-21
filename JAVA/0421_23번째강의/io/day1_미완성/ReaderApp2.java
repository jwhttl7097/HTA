package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderApp2 {

	public static void main(String[] args) {
		
		try (FileReader fileReader = new FileReader("src/day1/students.txt");
			BufferedReader reader = new BufferedReader(fileReader);) {
			
			String text = null;
			// readLine()으로 읽어온 텍스트를 text변수에 대입하고, 그값이 null이 아닐때까지 반복
			while((text = reader.readLine()) != null) {
				String[] values = text.split(",");
				String name = values[0];
				int kor = Integer.parseInt(values[1]);
				int eng = Integer.parseInt(values[2]);
				int math = Integer.parseInt(values[3]);
				int total = kor + eng + math;
				int average = total/3;
				
				System.out.println(name);
				System.out.println(kor);
				System.out.println(eng);
				System.out.println(math);
				System.out.println("총 점:" + total);
				System.out.println("평 균:" + average);
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
