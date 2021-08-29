package com.sample.mapper;

import java.util.List;

import com.sample.vo.User;

public interface UserMapper {

	/**
	 * 신규 사용자 정보를 데이터베이스에 저장한다.
	 * @param user 신규 사용자 정보
	 */
	void insertUser (User user);
	
	/**
	 * 사용자 아이디를 전달받아서 해당 사용자의 정보를 삭제한다.
	 * @param userId 사용자 아이디
	 */
	void deleteUser (String userId);
	
	/**
	 * 변경된 사용자 정보를 전달받아서 반영하기
	 * @param user 변경된 사용자 정보
	 */
	void updateUser (User user);
	
	/**
	 * 아이디로 사용자 정보를 조회해서 반환하기
	 * @param userId 유저아이디
	 * @return 사용자 정보
	 */
	User getUserById (String userId);
	
	/**
	 * 이메일로 사용자 정보를 조회해서 반환하기
	 * @param email 유저 이메일
	 * @return 사용자 정보
	 */
	User getUserByEmail (String email);
	
	/**
	 * 전화번호로 사용자 정보를 조회해서 반환하기
	 * @param phone 사용자 전화번호
	 * @return 사용자 정보 목록
	 */
	List<User> getUserByPhone (String phone);
	
}
