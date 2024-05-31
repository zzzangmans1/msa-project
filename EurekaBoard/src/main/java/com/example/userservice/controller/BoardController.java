package com.example.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.userservice.service.BoardServiceimpl;
import com.example.userservice.vo.BoardVO;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("board/api")
public class BoardController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private BoardServiceimpl boardService;
	
	public BoardController(BoardServiceimpl boardService) {
		this.boardService = boardService;
	}
	
	@PostMapping("/saveboard")
	public void saveBoard(@RequestBody Map<String, String> requestData) {
		logger.info("================================ START PostMapping /saveboard saveBoard ================================");
		logger.warn("board data= {} ", requestData);
		BoardVO boardVO = new BoardVO(requestData.get("boardId"), requestData.get("title"), requestData.get("content"), requestData.get("writer"));
		
		boardService.saveBoard(boardVO);
		
		logger.info("================================ START PostMapping /saveboard saveBoard ================================");
	}
	
	@GetMapping("/getAllboard")
	public List<BoardVO> getAllboard() {
		return boardService.getAllboard();
	}
	
	@GetMapping("/test")
	public String test() {
		return boardService.test();
	}
}
