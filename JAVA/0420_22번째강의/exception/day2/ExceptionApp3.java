package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExceptionApp3 {
	
	public static void test1() throws HTAUnCheckedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/day2/sample1.txt"));
			String text = reader.readLine();
			System.out.println("### 파일내용 : " + text);
			reader.close();
		} catch (FileNotFoundException e) {
			throw new HTAUnCheckedException("파일경로가 올바르지 않습니다.", e);
		} catch (IOException e) {
			throw new HTAUnCheckedException("### 파일읽기 오류가 발생하였습니다..", e);
		}
	}
	
	// 강제 발생시킨 HTAUnCheckedException 예외는 컴파일러가 예외처리 여부를 체크하지 않는 예외다.
	// 따라서, strToDate() 메소드 내부에서 HTAUnCheckedException 예외를 강제 발생 시켜도
	// throws 키워드를 사용해서 예외 떠넘기기를 생략 할 수 있다.
	
	public static Date strToDate(String dateString) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(dateString);
		} catch (ParseException cause) {
			throw new HTAUnCheckedException("올바른 날짜 형식이 아닙니다.", cause);
		}
	}
	
	public static void main(String[] args) {
		// test1()과 strToDate() 메소드는 예외처리를 강제하지 않는
		// UnChecked예외를 발생시키는 메소드다.
		// test1()과 strToDate() 메소드를 사용하는 측에서는 예외처리를 하지 않아도 된다.
		test1();
		Date day = strToDate("2010-01-01");
		System.out.println(day);
		
		// 필요에 따라서 예외처리를 일괄적으로 구현해도 상관없다.
		try {
			test1();
			Date day2 = strToDate("2010-01-01");
			System.out.println(day);
		} catch (HTAUnCheckedException e) {
			e.printStackTrace();
		}
	}
}
