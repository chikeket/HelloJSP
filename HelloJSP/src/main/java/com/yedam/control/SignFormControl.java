package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class SignFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청재지정. 경로는 webapp이 제일 상위경로라서 그 밑인 WEB_INF부터 적는거임
	req.getRequestDispatcher("WEB-INF/html/signup_form.jsp")
	.forward(req, resp);
	}

}
