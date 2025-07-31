package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO member); //회원등록
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw); //회원등록
}
