package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// key=value + 파일 => 처리.
		// cos.jar Multipart 파일을 처리해줄수 있는 라이브러리
		// 게시글 DB Insert.
		
		// 서버상의 upload 폴더에 저장.
		//getServletContext()프로젝트의 이름임
		String upload = req.getServletContext().getRealPath("upload");
		System.out.println(upload);
		
		MultipartRequest mr = new MultipartRequest(
				//총5개 정보가 매개변수로 필요함
				req, //1.요청정보
				upload, //2.업로드경로
				1024 * 1024 * 5, //3.최대파일크기 (예시는 5메가임)
				"UTF-8", //4.인코딩 방식
				new DefaultFileRenamePolicy() //5.업로드한 파일이 저장되는 공간인 upload 공간에 동일한 파일이름에 대한 리네임 정책.
				);
		
		// addBoard.do?title=값들어오는곳&writer=값들어오는곳&content=값들어오는곳
		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		//업로드했던 리네임정책이 적용된 파일을 넣어줌
		String img = mr.getFilesystemName("images");
		
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setContent(content);
		param.setWriter(writer);
		param.setImage(img);
		BoardService svc = new BoardServiceImpl();
		if(svc.registerBoard(param)) {
			// 목록이동.
			resp.sendRedirect("boardList.do");//sendRedirect 페이지 재조정 하는의미
		} else {
			System.out.println("에러발생.");
		}

	}//end of execute.

}
