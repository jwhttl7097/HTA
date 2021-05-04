package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteApp {
	
	public static void main(String[] args) {
		// ojdbc.jar 라이브러리에 포함되어 있는 오라클용 jdbc 지원 핵심 클래스
		String driverClassName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";
		
		String sql = "delete from sample_books where book_no = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 101);
			
			int rowCount = pstmt.executeUpdate(); // executeUpdate()는 sql실행된 행의 갯수 반환
			System.out.println(rowCount + "개의 행이 삭제 되었습니다.");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {}
				try {
					if(con != null) con.close();
				} catch (SQLException e) {}
		}
	}

}
