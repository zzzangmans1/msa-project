package com.example.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.userservice.vo.MemberVO;
import com.example.userservice.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper){
		this.memberMapper = memberMapper;
	}
	
	public void addMember(MemberVO memberVO) {
		memberMapper.save(memberVO);
	}
	
	public List<MemberVO> getAlluser() {
		List<MemberVO> memberVO = memberMapper.getAlluser();
		return memberVO;
	}
	
	public MemberVO getUser(String id) {
		MemberVO memberVO = memberMapper.getUser(id);
		return memberVO;
	}
	
}
