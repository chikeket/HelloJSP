package com.yedam;

import lombok.AllArgsConstructor;
import lombok.Data;


// 생성자, getter/setter
// lombok 라이브러리를 생성함 1)설치 2) 라이브러리
@Data
@AllArgsConstructor
public class book {
	private int id;
	private String title;
	private String author;
}
