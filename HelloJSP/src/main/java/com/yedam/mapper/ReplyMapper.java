package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.CalenderVO;
import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page") int page);
	int deleteReply(int replyNo); // 삭제.
	int insertReply(ReplyVO reply);
	int selectCount(int replyNo); //댓글건수계산
	// 목록, 추가, 삭제. -> mapper.xml 에 추가.
	List<CalenderVO> calenderList();
	int insertCalender(Map<String, Object> calen);
	int deleteCalender(Map<String, Object> calen);
	
}
