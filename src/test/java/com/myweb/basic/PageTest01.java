package com.myweb.basic;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myweb.basic.command.ProductVO;
import com.myweb.basic.product.ProductMapper;

@SpringBootTest
class PageTest01 {

	@Autowired
	ProductMapper productMapper;
	
	//insert 600번
//	@Test
//	public void testCode01() {
//		
//		for(int i = 1; i <= 600; i++) {
//			
//			ProductVO vo =  ProductVO.builder()
//									.prod_enddate("2022-08-02")
//									.prod_writer("admin")
//									.prod_name("admin" + i)
//									.prod_price(i)
//									.prod_count(i)
//									.prod_discount(i)
//									.prod_purchase_yn("N")
//									.prod_content("test" + i)
//									.prod_comment("test" + i)
//									.build();
//			
//			productMapper.productRegist(vo);
//		}
//	}

}
