package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class RegisterControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException{
		// web-inf/html/register_from.html
		// 요청재지정 객체
		
			// 요청재지정. 경로는 webapp이 제일 상위경로라서 그 밑인 WEB_INF부터 적는거임
			req.getRequestDispatcher("user/register_form.tiles").forward(req, resp);
		

	}

}
