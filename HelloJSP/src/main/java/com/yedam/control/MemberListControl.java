package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터. (page&searchCondition&keyword)
				String page = req.getParameter("page");
				String sc = req.getParameter("searchCondition");
				String kw = req.getParameter("keyword");
				page = page ==null ? "1" : page;
				
				//SearchDTO (메소드에 전달할 파라미터)
				SearchDTO search = new SearchDTO();
				search.setPage(Integer.parseInt(page));
				
				search.setSearchCondition(sc);
				search.setKeyword(kw);
				
						// web-inf/html/register_from.html
						MemberService svc = new MemberServiceImpl();
						List<MemberVO> list = svc.boardList(search); //글목록 가져오기
						
						for(MemberVO Mem : list) {							
							System.out.print(Mem.getMemberId()+"\t");
							System.out.print(Mem.getMemberName()+"\t");
							System.out.print(Mem.getMemberPw()+"\t");
							System.out.println(Mem.getResponsibility());							
						}
						
						
						//페이징.
						int tatalCnt = svc.totalCount(search);
						PageDTO paging = new PageDTO(Integer.parseInt(page), tatalCnt);
						
						//jsp(뷰역할) 페이지에 데이터 전달.
						req.setAttribute("board_list", list);
						req.setAttribute("paging", paging);
						req.setAttribute("searchCondition", sc);
						req.setAttribute("keyword", kw);																
						
						req.getRequestDispatcher("manager/member_list.tiles")
						.forward(req, resp);
							
						

	}

}
