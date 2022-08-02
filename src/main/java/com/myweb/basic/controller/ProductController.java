package com.myweb.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.basic.command.ProductVO;
import com.myweb.basic.product.ProductService;
import com.myweb.basic.util.Criteria;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	ProductService productService;
	
	
	@GetMapping("/productReg")
	public String productReg() {
		return "product/productReg";
	}
	
	@GetMapping("/productList")
	public String productList(Model model, Criteria cri) {
		
		//1st - admin기반으로 조회(나중에 세션값으로 변경)
		//List<ProductVO> list = productService.getList();
		//model.addAttribute("list", list);
		
		//2nd - 페이지
		List<ProductVO> list = productService.getList(cri);
		model.addAttribute("list", list);
		
		return "product/productList";
	}

	@GetMapping("/productDetail")
	public String productDetail(@RequestParam("prod_id") int prod_id,
								Model model) {
		
		/*
		 * 1. 화면에서 넘어오는 prod_id값을 받습니다.
		 * 2. getDetail(prod_id) 형식으로 select한 결과를 vo에 저장합니다
		 * 3. model에 vo를 저장합니다.
		 * 4. 화면에는 vo의 결과값을 출력해주세요.
		 */
		ProductVO vo = productService.getDetail(prod_id);
		model.addAttribute("prodVO", vo);
		
		
		return "product/productDetail";
	}
	
	@PostMapping("/productForm")
	public String productForm(@Valid ProductVO vo, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			for(FieldError err : list) {
				if(err.isBindingFailure() ) {
					model.addAttribute("valid_" + err.getField(), "형식을 일치 시켜주세요");
				}else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
				}
			}
			//다시 등록화면으로
			model.addAttribute("vo", vo);
			return "product/productReg";
			
		}
		
		
		//상품등록
		boolean result = productService.productRegist(vo);
		
		
		return "redirect:/product/productList";
	}
	
	//수정기능 
	@PostMapping("/productUpdate")
	public String productUpdate(ProductVO vo, RedirectAttributes RA) {
		
		boolean result = productService.productUpdate(vo);
		//메세지처리(리다이렉트시 1회성으로 처리할수 있는 방식)
		if(result) {
			RA.addFlashAttribute("msg", "정상 수정되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "정보 수정에 실패했습니다.");
		}
		
		return "redirect:/product/productList";
	}
	
	@PostMapping("/productDelete")
	public String productDelete(@RequestParam("prod_id") int prod_id, RedirectAttributes RA) {
		
		boolean result = productService.productDelete(prod_id);
		
		if (result) {
			RA.addFlashAttribute("msg", "정상 삭제되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "삭제에 실패하였습니다.");
		}
		
		return "redirect:/product/productList";
	}
	
	
	
	
	
	
	
	
}
