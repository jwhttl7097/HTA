package com.sample.di.demo4;

public class CloudDatabaseService {

	private String url;
	private String username;
	private String password;
	private int timeout;
	
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public CloudDatabaseService() {}
	
	public CloudDatabaseService(String username, String password) {
		this.url = "free.rds.amazon.com";
		this.username = username;
		this.password = password;
		this.timeout = -1; //타임아웃(대기시간, 요청에 대한 처리시간), 마이너스로 설정하는 경우 대기시간에 제한이 없단 뜻
	}
	
	public CloudDatabaseService(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.timeout = -1; 
	}
	
	public void config() {
		System.out.println("url : " + url);
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("timeout : " + timeout);
	}
	
}
