package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StandardInputApp {

	public static void main(String[] args) throws IOException{
		// Scanner와 표준입력스트림을 연결해서 키보드 입력값 읽어오기
		Scanner sc = new Scanner(System.in);
//		System.out.println("메세지를 입력하세요");
//		String text = sc.nextLine();
//		System.out.println("입력메세지 : " + text);
//		sc.close();
		
		// BufferedReader, InputStramReader와 표준입력스트림을 연결해서 키보드 입력값 읽어오기
		InputStream is = System.in; 						// 키보드와 연결된 InputStream
		InputStreamReader isr = new InputStreamReader(is);  // InputStream와 표준입력스트림 연결
		BufferedReader reder = new BufferedReader(isr);		// 표준입력스트림이 BufferedReader와 최종적으로 연결
		
		System.out.println("메세지를 입력하세요");
		String text = reder.readLine();
		System.out.println("입력메세지 : " + text);
		
	}
}
