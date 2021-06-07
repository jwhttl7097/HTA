package com.sample.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.sample.dao.FileItemDao;
import com.sample.vo.FileItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/*
 * @WebServlet("/upload")
 *     - 이 클래스가 클라이언트의 HTTP요청을 처리하는 서블릿 클래스임을 나타낸다.
 *     - ("/upload")는 이 서블릿클래스와 매핑된 URI를 설정한다.
 *       위의 설정은 http://localhost/upload라는 요청이 접수되면 이 서블릿의
 *       void service(request, response) 메소드가 실행되게 한다.
 */
@WebServlet("/upload")
/*
 * @MultipartConfig
 *     - 이 클래스가 멀티파트 요청을 처리하는 서블릿 클래스임을 나타낸다.
 *     - 멀티파트요청은 폼 입력요소에 첨부파일 업로드가 포함되어 있는 요청이다.
 *     - 멀티파트요청은 <form />태그에 enctype="multipart/form-data"로 설정되어 있는 것이다.
 *     - @MultipartConfig 어노테이션이 부착되어 있지 않은 서블릿 클래스는 
 *       멀티파트요청을 처리할 수 없다.
 */
@MultipartConfig
public class FileUploadServlet extends HttpServlet{
	
	private static final String saveDirectory = "C:\\workspace\\woohyeok\\java-web\\upload";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0-1. 요청 파라미터 조회하기
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		// 0-2. 업로드된 첨부파일 처리하기 (getPart("name")으로 정보가져와서 Part객체에 담기)
		// Part는 업로드된 첨부파일의 정보를 가지고 있는 객체다 (-> part에 저장된 정보는 임시로 temp라는 임시폴더에 저장되어진다.).
		// Part로 부터 파일이름, 파일종류(ContentType), 파일크기, 파일을 읽어오는 스트림(in, outputStream)을 획득할 수 있다.
		Part part = request.getPart("upfile");
		
		// 1. 업로드된 첨부파일 정보 획득하기
		String filename = System.currentTimeMillis() + part.getSubmittedFileName();  //part로 가져온 업로드된 첨부파일정보를 part.getSubmittedFileName()를 이용해서 파일이름을 획득한다. 
		
		// 2. 업로드된 첨부파일을 지정된 폴더에 복사하기
		//    * 서버로 업로드된 첨부파일은 서버의 임시디렉토리에 임시파일(xxxxxxx.tmp)의 형태로 저장되어 있음
		// File객체 생성 : 지정된 디렉토리와 파일명에 대한 정보를 가지는 객체다.
		//				File객체는 실제로 존재하지 않는 파일에 대해서도 객체 생성이 가능하다.
		
		// InputStream은 임시폴더에 저장된 첨부파일을 읽어오는 스트림 획득
		InputStream in = part.getInputStream(); // 첨부파일 정보를 가진 part객체를 읽어오는 스트림획득 메소드
		
		// OutputStream은 첨부파일을 디스크에 저장하는 출력스트림 
		OutputStream out = new FileOutputStream(new File(saveDirectory, filename));
		
		// 입력스트림으로 읽어온 데이터를 출력스트림으로 출력시켜서 파일을 복사한다.
		IOUtils.copy(in, out);
		out.close();
		
		// 3. 업로드된 파일정보(제목, 설명, 파일명)을 데이터베이스에 저장하기
		FileItem fileItem = new FileItem();
		fileItem.setTitle(title);
		fileItem.setDescription(description);
		fileItem.setFilename(filename);
		
		FileItemDao fileItemDao = FileItemDao.getInstance();
		fileItemDao.insertFileItem(fileItem);
		
		// 클라이언트에게 index.jsp를 재요청하게 하는 응답을 보내기
		response.sendRedirect("/index.jsp");
	}
	
//	 Part객체가 가지고 있는 파일이름 정보 --> api가 나왔음 --> .getSubmittedFileName();를 이용해서 
//			Content-Disposition: form-data; name="upfile"; filename="휴가신청서.hwp"
//	private String getFilename(Part part) {
//		String contentDisposition = part.getHeader("content-disposition");
//		// contentdisposition <-- form-data; name="upfile"; filename="휴가신청서.hwp"
//		
//		String[] items = contentDisposition.split(";");
//		// items <--- {fomr-data, name="upfile", filename="휴가신청서.hwp"}
//		
//		for (String item : items) {
//			if (item.trim().startsWith("filename")) {
//				// item <-- filename="휴가신청서.hwp" 인덱스오브 =기호에서 2번째 앞부터 총 길이에서 -1칸 까지의 자료를 서브스트링으로 추출해서 반환한다. 
//				return item.substring(item.indexOf("=") +2, item.length() -1);
//			}
//		}
//		return "";
//	}
	
}
