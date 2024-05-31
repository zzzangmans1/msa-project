package com.example.userservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.userservice.vo.BoardVO;
import java.util.List;

@Mapper
public interface BoardMapper {
	
	void saveBoard(@Param("board") BoardVO boardVO);
	
	List<BoardVO> getAllboard();
	
}
