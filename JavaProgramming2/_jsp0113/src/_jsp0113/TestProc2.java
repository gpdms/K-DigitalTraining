package _jsp0113;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class TestProc2 {

	public static void main(String[] args) {
		// 프로시저를 이용한 sungjuk 테이블 목록 연습
		
				String url     ="jdbc:oracle:thin:@localhost:1521:xe";
				String user    ="SCOTT";
				String password="tiger";
				String driver  ="oracle.jdbc.driver.OracleDriver";

				Connection con=null;          //DB연결
				//프로시저 호출관련 인터페이스
				CallableStatement cstmt=null;
				ResultSet rs=null;            //select문 조회

				try{
					Class.forName(driver);
					con=DriverManager.getConnection(url, user, password);
					System.out.println("오라클DB서버 연결 성공");
				
					//프로시저 호출 형식
					//con.prepareCall("{call 프로시저이름(?,?,?)}")
					cstmt=con.prepareCall(" {call myproc2(?)} ");
					
					//1-> 첫번째 ? 인덱스
					//OracleTypes.CURSOR 조회하고자 하는 DB서버 커서
					cstmt.registerOutParameter(1, OracleTypes.CURSOR);
					cstmt.execute(); //실행
					
					//1이 의미하는 것 -> (1, OracleTypes.CURSOR)
					rs=(ResultSet) cstmt.getObject(1);
					if(rs.next()){
						System.out.println("자료있음");
						do{
							System.out.print(rs.getInt("num")+" ");
							System.out.print(rs.getString("message")+" ");
							System.out.println();					
						}while(rs.next());						
					}else{
						System.out.println("자료없음");
					}//if end
					
				}catch(Exception e){
					System.out.println("실패!");
				}finally{ //자원반납
					try{
						if(rs!=null){rs.close();}
					}catch(Exception e){}
					try{
						if(cstmt!=null){cstmt.close();}
					}catch(Exception e){}
					try{
						if(con!=null){con.close();}
					}catch(Exception e){}
				}

	}

}