package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchDTO;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO member); //회원등록
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw); //회원등록
	public List<MemberVO> selectList(SearchDTO search); // 목록.
	public int selectCount(SearchDTO search);
}
