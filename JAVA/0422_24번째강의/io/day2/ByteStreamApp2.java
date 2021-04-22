package day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ByteStreamApp2 {
	
	public static void main(String[] args) throws IOException{
		
		URL url = new URL("https://images.blz-contentstack.com/v3/assets/blte0bbc3c063f45866/blt1d028682c341057d/5ea72b7aa0bad00bf7313e6d/thumbnail-home.jpg");
		
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("src/day2/블리자드.jpg");
		
		BufferedInputStream bis = new BufferedInputStream(in);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		int value = 0;
		while((value = bis.read()) != -1) {
			bos.write(value);
		}
	
		bos.close();
	}

}
