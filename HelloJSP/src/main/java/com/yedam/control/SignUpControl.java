package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// param: id, psw, name
		// 회원정보 등록 -> 게시글목록 페이지.
		req.setCharacterEncoding("utf-8");
		// addBoard.do?title=값들어오는곳&writer=값들어오는곳&content=값들어오는곳
		String id = req.getParameter("id");
		String psw = req.getParameter("psw");
		String name = req.getParameter("name");
		
		MemberVO param = new MemberVO();
		param.setMemberId(id);
		param.setMemberPw(psw);
		param.setMemberName(name);
		
		MemberService svc = new MemberServiceImpl();
		if(svc.addMember(param)) {
			// 목록이동.
			resp.sendRedirect("boardList.do");//sendRedirect 페이지 재조정 하는의미
		} else {
			System.out.println("에러발생.");
		}


	}

}
