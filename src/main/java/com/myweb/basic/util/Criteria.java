package com.myweb.basic.util;

import lombok.Data;

@Data	//Getter, Setter, ToString
public class Criteria {

	private int page;	//페이지번호
	private int amount;	//화면에 띄워지는 정보의 양
	
	//ctrl + space + enter
	public Criteria() {
		this(1, 10);
	}
	//alt + shift + s -> construct using field

	public Criteria(int page, int amount) {
		super();
		this.page = page;
		this.amount = amount;
	}
	//limit (페이지 - 1) * 데이터개수, 데이터개수
	//limit함수의 앞에 전달될 값
	public int getPageStart() {
		return (page - 1) * amount;
	}
	
}
