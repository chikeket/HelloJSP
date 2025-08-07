package com.yedam.service;

import java.util.List;

import com.yedam.vo.CalenderVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page);
	boolean removeReply(int replyNo); // 삭제.
	boolean addReply(ReplyVO reply); // 등록.	
	int replyCount(int boardNo); //댓글건수계산
	
	//캘린더 리스트 추가 삭제
	List<CalenderVO> calenderList();
	boolean addCalender(CalenderVO calen); // 등록.	
	boolean removeCalender(String title); // 삭제
}
