package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.CalenderVO;

public class RemovecalenderControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		// param: bno, reply, replyer
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		System.out.println(title);
		System.out.println(start);
		System.out.println(end);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		CalenderVO calen = new CalenderVO();
		calen.setTitle(title);
		calen.setStart(start);
		calen.setEnd(end);
		map.put("calen", calen);
		//map.put("start", start);
		//map.put("end", end);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();		
		//DB 처리. => 반환.
		ReplyService svc = new ReplyServiceImpl();
		try {
			svc.removeCalender(calen);
			map.put("retCode", "OK");
			String json = gson.toJson(map); // 자바객체 -> json문자열.
			resp.getWriter().print(json);			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("retCode", "NG");
			String json = gson.toJson(map); // 자바객체 -> json문자열.
			resp.getWriter().print(json);			
			System.out.println("쿼리에서 add가 작동하지않음");
		}

	}

}
