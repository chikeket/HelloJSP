package com.yedam;





import java.util.HashMap;
import java.util.Map;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;
//interface 도 데이터중 하나로 취급함
interface Controller {
	public void exe();
}
class Sample implements Controller {
	@Override
	public void exe() {
		System.out.println("Sample 클래스");
	}
}
public class Main {
	public static void main(String[] args) {
		
		BoardService svc = new BoardServiceImpl();
				
		int searchNo = 1;
		
		//조회. 조회수증가. =>업무(조회:  글번호조회 + 조회카운트)
		BoardVO board = svc.searchBoard(searchNo);
				
		// hr, 근태, +++++ => 업무.
		System.out.println(board.toString());
		
//		ArrayList<Book> list = new ArrayList<>();
//		Book book = list.get(0);
				
		//키=값
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("홍길동", 80);
		map.put("박길동", 78);
		map.put("200", 22);
		Integer result = map.get("홍길동");
		System.out.println(result);
		//우측에 타입을 안적어주면 왼쪽에 있는타입으로 자동 입력됨
		Map<String, Controller> controls = new HashMap<String, Controller>();
		controls.put("Sample", new Sample()); //abc.do
		controls.put("Test", new Controller() { //ddc.do
			@Override
		public void exe() {
				System.out.println("Test입니다.");
			}
		});
		
		Controller val = controls.get("Sample");
		val.exe();
	}
	void backup() {//25-07-28
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO board : list) {
//			System.out.println(board.toString());
//		}
//		System.out.println(list.get(0).getCreationDate()); 
	}
}
