package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardListServlet
 */
//개발자가 실행하는게 아니라 이제 톰캣이 실행하게 해줌 아래 문장의 의미가 그러함
@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet { //extends 상속 이라는 의미
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        System.out.println("BoardListServlet 생성자.");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //데이터를 빨리 전달할수있지만 전달하는 양이 적다
	protected void doGet(HttpServletRequest request//요청정보
			, HttpServletResponse response//응답정보
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//글목록 출력.
		response.setContentType("text/html;charset=utf-8");//웹브라우저의 컨텐츠타입.
		System.out.println("Hello Servlet !!!");
		PrintWriter out = response.getWriter(); //stream
		out.println("<b>Hello, Servlet !!!2</b>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();
		
		String html = "<table border='2'><thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr></thead>";
		html += "<tbody>";
		for (BoardVO board : list) {
			html += "<tr><td align='center'><a href='board?board_no="+board.getBoardNo()+"'>"+ board.getBoardNo()//
			+"</td><td>"+ board.getTitle()//
			+"</td><td>"+ board.getWriter()//
			+"</td><td>"+ board.getViewCnt() + "</td></tr>";
		}		
		html += "</tbody></table>";
		out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//데이터 많이 전달할수 있다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
