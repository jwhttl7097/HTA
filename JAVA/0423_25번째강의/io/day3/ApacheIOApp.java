package day3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ApacheIOApp {

	public static void main(String[] args) throws IOException{
		// 파일 복사하기 (방법1)
//		FileUtils.copyFile(new File("src/day3/song.mp4"), new File("src/day3/song_copy"));
		// 파일 복사하기 (방법2)
//		File src = new File("src/day3/song.mp4");
//		File dest = new File("src/day3/song_copy");
//		
//		FileUtils.copyFile(src, dest);
		
		// 인터넷의 자원(텍스트, 사진, 영상) 가져오기
		URL url = new URL("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA5MTZfMjg3%2FMDAxNjAwMTg1NjM4OTU3.9sU8PhF2RjKoeU-2Ka1DyNP_LI8ns2X2_mDijzZq4oAg.RYTfVV5lBXKIZDVUwqAk9-u6WVoV4djbQ5JLsPV5LMsg.PNG.streetsu%2F0.png&type=a340");
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("src/day3/photo.jpg");
		
		IOUtils.copy(in, out);
	}
}
