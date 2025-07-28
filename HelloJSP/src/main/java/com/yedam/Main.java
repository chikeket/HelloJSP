package com.yedam;




import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class Main {
	public static void main(String[] args) {
		
		BoardService svc = new BoardServiceImpl();
				
		int searchNo = 1;
		
		//조회. 조회수증가. =>업무(조회:  글번호조회 + 조회카운트)
		BoardVO board = svc.searchBoard(searchNo);
				
		// hr, 근태, +++++ => 업무.
		System.out.println(board.toString());
		
	}
	void backup() {//25-07-28
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO board : list) {
//			System.out.println(board.toString());
//		}
//		System.out.println(list.get(0).getCreationDate()); 
	}
}
