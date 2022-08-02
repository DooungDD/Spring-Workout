package com.myweb.basic.product;

import java.util.List;

import com.myweb.basic.command.ProductVO;

public interface ProductService {

	public boolean productRegist(ProductVO vo); //등록
	public List<ProductVO> getList(); //조회
	public ProductVO getDetail(int prod_id); //상세조회
	public boolean productUpdate(ProductVO vo); //수정
	public boolean productDelete(int prod_id);	//삭제
	
}
