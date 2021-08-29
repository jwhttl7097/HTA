package com.sample.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sample.exception.MallBusinessException;
import com.sample.mapper.UserMapper;
import com.sample.vo.User;

@Service
public class UserService {

	@Value ("${user.default.deposit.point}")
	private int defaultDepositPoint;
	
	@Autowired
	private UserMapper userMapper;
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	/**
	 * 새 사용자 정보를 전달받아 회원가입 처리하기
	 * @param user 사용자 정보
	 */
	public void insertUser (User user) {
		User savedUser = userMapper.getUserById(user.getUserId());
		if(savedUser != null) {
			throw new MallBusinessException("["+user.getUserId()+"]는 이미 사용중인 아이디입니다.");
		}
		savedUser = userMapper.getUserByEmail(user.getEmail());
		if(savedUser != null) {
			throw new MallBusinessException("["+user.getEmail()+"]는 이미 사용중인 이메일입니다.");
		}
		List<User> savedUsers = userMapper.getUserByPhone(user.getPhone());
		if (!savedUsers.isEmpty()) {
			throw new MallBusinessException("["+user.getPhone()+"]은 이미 사용중인 전화번호입니다.");
		}
		
		// 비밀번호 암호화
		String sha256Pwd = DigestUtils.sha256Hex(user.getPassword());
		user.setPassword(sha256Pwd);
		
		// 신규 가입한 사용자의 정보를 등록
		userMapper.insertUser(user);
		
		// 신규 가입한 사용자의 기본 포인트를 수정등록 한다.
		User user2 = userMapper.getUserById(user.getUserId());
		user2.setPoint(defaultDepositPoint);
		userMapper.updateUser(user2);
	}
	
	public void removeUser (String userId) {
		userMapper.deleteUser(userId);
	}
	
	/**
	 * 아이디를 전달받아서 조회된 사용자 정보를 반환한다.
	 * @param userId 사용자 아이디
	 * @return 사용자 정보
	 */
	public User getUserDetail(String userId) {
		return userMapper.getUserById(userId);
	}
	
	/**
	 * 변경된 사용자 정보를 전달받아서 반영하기
	 * @param user 변경된 사용자 정보
	 */
	public void updateUser (User user) {
		
	}
	
	/**
	 * 사용자 아이디를 전달받아서 해당 아디의 유저 정보를 반환한다.
	 * @param userId 사용자 아이디
	 * @return 사용자 정보
	 */
	public User getUserById (String userId) {
		User user = userMapper.getUserById(userId);
		return user;
	}
	
	/**
	 * 이메일로 사용자 정보를 조회해서 반환하기
	 * @param email 사용자 이메일
	 * @return 사용자 정보
	 */
	public User getUserByEmail (String email) {
		return userMapper.getUserByEmail(email);
	}
	
	/**
	 * 전화번호로 사용자 정보를 조회해서 반환하기
	 * @param phone 사용자 전화번호
	 * @return 사용자 정보 목록
	 */
	public List<User> getUserByPhone (String phone) {
		return userMapper.getUserByPhone(phone);
	}
}
