package com.sample.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.vo.Product;

/*
 * @RunWith
 * 		- 단위테스트 케이스 실행시 같이 실행될 클래스를 지정한다.
 * 		- 보통 단위테스트 케이스 실행을 지원하는 헬프 클래스가 지정된다.
 * 		- SpringJUnit4ClassRunner은 jUnit으로 스프링 컨테이너에서 생성된 빈을 테스트할 수 있도록
 * 		    지원한다.
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 *  @ContextConfiguration
 *  	- locations로 지정한 스프링 빈 설정정보를 로딩해서 스프링 컨테이너를 생성한다.
 *  	- 생성된 스프링 컨테이너는 스프링 설정정보를 분석해서 객체를 생성하고, 스프링의 빈으로 추가한다.
 */
@ContextConfiguration(locations = "classpath:/spring/context-mybatis.xml")
public class TestProductService {

	@Autowired
	ProductService productService;
	
	/*
	 * @Test
	 * 		- 단위테스트 케이스에 정의된 메소드를 단위테스트에 참여하게 한다.
	 * @Ignore
	 * 		- 단위테스트 대상에서 제외시킨다.
	 */
	@Test
	@Ignore
	public void testConfig() {
		// 단언하기 assertNotNull(객체) 해당 객체가 null이 아닐 것으로 확신한다.
		Assert.assertNotNull(productService);
		System.out.println(productService);
	}
	
	@Test
	public void testGetAllProducts() {
		List<Product> products = productService.getAllProductList();
		Assert.assertEquals(34, products.size());
	}
	
	@Test
	public void getAddProductByNo() {
		Product prevProduct = productService.getProductByNo(31);
		productService.addProduct(31, 10);
		Product nextProduct = productService.getProductByNo(31);
		
		// Assert.assertEquals(예상값, 결과값)
		Assert.assertEquals(prevProduct.getStock() + 10, nextProduct.getStock());
	}
}
