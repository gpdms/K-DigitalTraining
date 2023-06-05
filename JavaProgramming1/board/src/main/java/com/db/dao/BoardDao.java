package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.dto.BoardDto;

public class BoardDao {
	Connection conn = null;
	
	//생성자 등록
	public BoardDao() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//게시글 전체 출력 -> 목록
	public List<BoardDto> selectAll(){
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SCOTT","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		List<BoardDto> res = new ArrayList<BoardDto>();
		
		String sql = "select * from board";
		
		//sql 쿼리 실행
		try {
			stmt = conn.createStatement();
		
			//쿼리 실행결과 rs에 저장
			rs=stmt.executeQuery(sql);
		
			//rs dto에 순서대로 저장
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				res.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return res;
		
		
	}
	
	//게시글 선택 출력
	public BoardDto selectOne(int bd_no) {
		return null;
		
	}
	
	//글 추가
	public int insert(BoardDto dto) {
		return 0;
		
	}
	
	//글 수정
	public int update(BoardDto dto) {
		return 0;
		
	}
	
	//글 삭제
	public int delete(int bd_no) {
		return 0;
		
	}
	
	
	
	

	public static void main(String[] args) {
	}

}
