package com.example.userservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.userservice.mapper.BoardMapper;
import com.example.userservice.vo.BoardVO;
import java.util.List;
@Service
public class BoardServiceimpl implements BoardService{
	private BoardMapper boardMapper;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public BoardServiceimpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	public void saveBoard(BoardVO boardVO) {
		logger.warn("saveBoard 입니다.");
		boardMapper.saveBoard(boardVO);
	}
	
	public String test() {
		logger.warn("test입니다.");
		return "test";
	}
	
	public List<BoardVO> getAllboard() {
		logger.warn("getAllboard 입니다.");
		return boardMapper.getAllboard();
	}
}
