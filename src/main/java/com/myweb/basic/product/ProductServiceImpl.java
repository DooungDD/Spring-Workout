package com.myweb.basic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.basic.command.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	ProductMapper productMapper;

	@Override
	public boolean productRegist(ProductVO vo) {
		
		return productMapper.productRegist(vo);
	}

	@Override
	public List<ProductVO> getList() {
		
		return productMapper.getList();
	}

	@Override
	public ProductVO getDetail(int prod_id) {

		return productMapper.getDetail(prod_id);
	}

	@Override
	public boolean productUpdate(ProductVO vo) {
		return productMapper.productUpdate(vo);
	}

	@Override
	public boolean productDelete(int prod_id) {
		return productMapper.productDelete(prod_id);
	}
	
	
}
