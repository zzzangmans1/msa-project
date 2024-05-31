package com.example.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.service.MemberService;
import com.example.userservice.vo.MemberVO;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@AllArgsConstructor
@RequestMapping("member/api")
public class MemberController {
	private MemberService memberService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping("/signUp")
	public void signup(@RequestBody Map<String, String> requestData) {
		logger.info("================================ START PostMapping /signUp signup ================================");
		logger.warn("request data id={} , password={} ", requestData.get("id"), requestData.get("password"));
		
		if(requestData.get("id") == null) {
			logger.warn("signupForm is null");
			return;
		}
		
		MemberVO checkId = memberService.getUser(requestData.get("id"));
		if(checkId == null) {
			logger.warn("{} 사용 가능합니다.", requestData.get("id"));
		}
		else if(checkId.getId().equals(requestData.get("id"))) {
			logger.warn("{} 중복 아이디가 존재합니다.", checkId.getId());
			return;
		}
		
		MemberVO memberVO = new MemberVO(requestData.get("id"), requestData.get("password"));
		memberService.addMember(memberVO);
		logger.info("================================ END PostMapping /signUp signup ================================");
	}
	
	
	@GetMapping("/test")
	public String test() {
		logger.info("================================ START GetMapping /test test ================================");
		logger.info("================================ END GetMapping /test test ================================");
		return "테스트입니다.";
	}
	
	@GetMapping("/getAlluser")
	public List<MemberVO> getAlluser() {
		logger.info("================================ START GetMapping /getAlluser getAlluser ================================");
		logger.info("================================ END GetMapping /getAlluser getAlluser ================================");
		return memberService.getAlluser();
	}
	
	@PostMapping("/getUser")
	public MemberVO getUser(@RequestBody Map<String, String> requestData) {
		logger.info("================================ START PostMapping /getUser getUser ================================");
		MemberVO memberVO = memberService.getUser(requestData.get("id"));
		logger.warn("getUser ID : {}", memberVO.getId());
		logger.info("================================ END PostMapping /getUser getUser ================================");
		return memberVO;
	}
}
;