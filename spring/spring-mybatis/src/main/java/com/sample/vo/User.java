package com.sample.vo;

import java.util.Date;

import lombok.Builder;

//@Getter				getter메소드 추가 lombok
//@Setter				Setter메소드 추가 lombok
//@ToString				ToString메소드 재정의 lombok
//@NoArgsConstructor	기본생성자 메소드 추가, 기본생성자 외의 생성자가 정의되어 있는 경우 기본생성자를 추가할 때 사용
public class User {

	private String userId;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String status;
	private Date createdDate;
	private int point;

	public User() {}
	
	@Builder	// User 클래스의 초기화를 담당하는 빌더패턴의 빌더객체를 추가한다.
	public User(String userId, String name, String password, String email, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public User(String userId, String name, String password, String email, String phone, String status,
			Date createdDate, int point) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.createdDate = createdDate;
		this.point = point;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
