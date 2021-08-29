package com.sample.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sample.vo.User;

// SpringJUnit4ClassRunner
// 		단위테스트 실행시 spring-test 라이브러리가 지원하는 서비스를 제공받을 수 있도록한다.
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration
//		지정된 스프링 빈 설정파일을 읽어서 스프링 컨테이너를 생성한다.
@ContextConfiguration("classpath:/spring/context-tx-annotation.xml")
// @Transactional
// 		각각의 테스트 메소드의 실행이 종료되면 해당 메소드내에서 수행했던 모든 데이터베이스 엑세스 작업을 롤백시킨다.
//		즉, 테이블의 상태를 테스트 이전 상태로 되돌려 놓는다.
//		수동으로 값을 원래 상태로 되돌리는 작업없이 반복적으로 테스트를 수행할 수 있게 된다.
@Transactional
public class UserServiceTest {
	// @Autowired
	//		단위테스트 대상이 되는 객체를 스프링컨테이너로부터 주입받을 수 있다.
	@Autowired
	UserService userService;
	
	// @Value
	//		단위테스트 수행시 필요한 상수값, properties파일의 설정값을 주입받을 수 있다.
	@Value("${user.default.deposit.point}")
	int defaultDepoistPoint;
	
	@Test
	public void testConfig() {
		// userService에 UserService객체가 주입되었기 때문에 userService는 null이 아니어야 한다.
		assertNotNull(userService);
		// defaultDepositPoint에는 프로퍼티 설정값이 주입되었기 때문에 defaultDepositPoint는 100이어야 한다.
		assertEquals(10, defaultDepoistPoint);
	}
	
	@Test
	public void testAddNewUser() {
		userService.removeUser("hong5555");
		
		User user = User.builder()
				.userId("hong5555").password("zxcv1234")
				.name("퐁길동").email("tong5555@gmail.com")
				.phone("010-1512-5555").build();
		
		// 신규회원 저장하기
		userService.insertUser(user);
		
		// 신규회원 정보 다시 조회하기
		User savedUser = userService.getUserById(user.getUserId());
		
		// 데이터베이스에 저장된 신규회원정보가 예상한대로 저장되어 있는지 확인하기
		assertEquals("ACTIVE", savedUser.getStatus());
		assertEquals(defaultDepoistPoint, savedUser.getPoint());
		assertNotNull(user.getCreatedDate());
	}
}
