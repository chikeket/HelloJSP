package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String bno = req.getParameter("bno");		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		

		
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setContent(content);
		param.setBoardNo(Integer.parseInt(bno));
		BoardService svc = new BoardServiceImpl();
		System.out.println("찐수정 저장버튼 눌럿을때 modifyBoard.do");
		System.out.println(page);
		
		if(svc.updateBoard(param)) {
			// 목록이동.
			resp.sendRedirect("boardList.do?searchCondition=&keyword=&page="+page);//sendRedirect 페이지 재조정 하는의미
			
		} else {
			System.out.println("에러발생.");
		}
	}

}
