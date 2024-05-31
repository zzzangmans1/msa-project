package com.example.userservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.userservice.vo.MemberVO;

@Mapper
public interface MemberMapper {
	void save(@Param("mem") MemberVO memberVO);
	
	List<MemberVO> getAlluser();
	
	MemberVO getUser(String id);
}
