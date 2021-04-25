package day3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;

public class StandardIOApp {

	public static void main(String[] args) throws IOException{
		InputStream in = System.in;
		PrintStream out = System.out;
		PrintStream err = System.err;
		System.out.println("표준입력 스트림: " + in);
		System.out.println("표준출력 스트림: " + out);
		System.out.println("표준에러 출력 스트림: " + err);
	}
}
