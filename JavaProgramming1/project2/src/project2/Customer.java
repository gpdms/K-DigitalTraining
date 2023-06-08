package project2;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;


public class Customer {

	Connection conn;

	Statement stmt;

	ResultSet rs;

	

	Customer(){

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		System.out.println("드라이버 완료");

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		System.out.println("접속 완료");

	}
	


	

	//로그인 정보 확인

	String logincheck(String number, String password) throws SQLException {

		stmt = conn.createStatement();

		rs = stmt.executeQuery("select * from customer");

		boolean run = false;

		

//		String id = _i;

//		String password = _p;

		

		try {

			String checkingStr = "select name, password from customer where number='" + number + "'";

			ResultSet result = stmt.executeQuery(checkingStr);

			

			while(result.next()) {

				if(password.equals(result.getString("password"))) {

					run = true;

					System.out.println("로그인에 성공했습니다.");

					return result.getString("name");

				}

				else {

					run = false;

					System.out.println("로그인에 실패했습니다");

					return null;

				}

			}

		} catch(Exception e) {

			run = false;

			System.out.println("로그인 실패했습니다 > " + e.toString());

		}

		return null;

	}

	

	boolean joinCheck(String number, String password, String name) {

		boolean run = false;

			

		try {

			stmt = conn.createStatement();

			String insertStr = "insert into customer(number, password, name) values('"+number+"','"+password+"','"+name+"')";

			stmt.executeUpdate(insertStr);

				

			run= true;

			System.out.println("회원가입 성공");

		} catch(Exception e) {

			run = false;

			System.out.println("회원가입 실패 > " + e.toString());

		}

			

		return run;

	}
	


	

	public void selectAll() throws SQLException{

		stmt = conn.createStatement();

		rs = stmt.executeQuery("select * from customer");

		while(rs.next()) {

			String name = rs.getString("name");

			System.out.printf(name + "\t");

		}

	}

//	

//	public void insertAll() throws SQLException{

//		stmt = conn.createStatement();

//		rs = stmt.executeQuery("select * from student");

//		int res = stmt.executeUpdate("insert into student values(1111, '김창석', '202211', '서울 중구')");

//		System.out.println(res +"건 입력 성공");

//	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Customer cus = new Customer();

		cus.selectAll();

		cus.logincheck("01021141128", "1234");

//		cus.joinCheck("49543", "543543", "이천수");

//		cus.joinCheck(2,"pokemon", "1234", "포켓몬", "0123");

//		Customer studentDB = new Customer();

//		studentDB.insertAll();

	}

}

