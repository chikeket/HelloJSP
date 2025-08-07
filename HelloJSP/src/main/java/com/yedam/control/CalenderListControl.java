package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.CalenderVO;

public class CalenderListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		ReplyService svc = new ReplyServiceImpl();
		List<CalenderVO> list = svc.calenderList();
		
		//Gson 라이브러리 활용해서 json문자열 만들기.
				Gson gson = new GsonBuilder().create();
				String json = gson.toJson(list);
				
				// 출력 스트림.
				resp.getWriter().print(json);

	}

}
