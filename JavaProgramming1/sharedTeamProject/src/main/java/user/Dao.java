package user;

import java.io.FileReader;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dao {
	// 싱글톤
	
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {
		return dao;
	} // ------------
	
	private Connection conn = getConnect();
	
	private Connection getConnect() {
		try {
			Properties prop = new Properties();
			String path = Dao.class.getResource("db.properties").getPath();
			path = URLDecoder.decode(path,"utf-8");
			prop.load(new FileReader(path));
			String driver = prop.getProperty("driver");
			String dbURL = prop.getProperty("dbURL");
			String dbID = prop.getProperty("dbID");
			String dbPW = prop.getProperty("dbPW");
			Class.forName(driver);
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
			
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}
		return null;
	}
//	post  ---------------------------------------------------------
	// 게시글 전체 목록 불러오기
	public List<Post> selectPostAll(int index_no){
		List<Post> postList = new ArrayList<>();
		
		String sql = "select * from post where onoff=1 order by postNum desc limit "+index_no+",10";
		Post post = null;
		
		try {
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int postNum = rs.getInt("postNum");
				int studentNum = rs.getInt("studentNum");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int likeCount = rs.getInt("likeCount");
				int commentCount = rs.getInt("commentCount");
				String date =  rs.getString("date");
				String board =  rs.getString("board");
				int onoff =  rs.getInt("onoff");
				post = new Post(postNum, studentNum, title, content, likeCount, commentCount, date, board, onoff); 
				postList.add(post);
			}
			rs.close();
			pstm.close();
			System.out.println("게시글 전체 목록 리턴");
			return postList;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("selectPostAll() 에러");
		}
		
		return null;
	}
	
	// 해당 아이디가 작성한 게시글 전체 목록 불러오기
	public List<Post> selectPostID(int idStudentNum,int index_no){
		List<Post> postList = new ArrayList<>();
		String sql = "select * from post where onoff=1 and studentNum= ? order by postNum desc limit ?,10";
		Post post = null;
		try {
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idStudentNum);
			pstm.setInt(2, index_no);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int postNum = rs.getInt("postNum");
				int studentNum = rs.getInt("studentNum");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int likeCount = rs.getInt("likeCount");
				int commentCount = rs.getInt("commentCount");
				String date =  rs.getString("date");
				String board =  rs.getString("board");
				int onoff =  rs.getInt("onoff");
				post = new Post(postNum, studentNum, title, content, likeCount, commentCount, date, board, onoff); 
				postList.add(post);
			}
			rs.close();
			pstm.close();
			System.out.println("해당 아이디가 작성한 게시글 전체 목록 리턴");
			return postList;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("selectPostID() 에러");
		}
		
		return null;
	}
	
	// 게시글 번호로 게시글 제목 찾기
	public List <String> selectPostNum(int postNum){
		List<String> titleList = new ArrayList<>();
		String sql = "select title from post where onoff=1 and postNum= ?";
		String title = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, postNum);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				title = rs.getString("title");
				titleList.add(title);
			}
			rs.close();
			pstm.close();
			System.out.println("게시물 번호로 제목 검색");
			return titleList;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("selectPostID() 에러");
		}
		
		return null;
	}
	
	//총 게시물 개수
	public int countPostAll(){
		
		String sql = "select count(*) total from post";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rsTot = pstm.executeQuery();
			rsTot.next();
			int total = rsTot.getInt("total");
			System.out.println("총 게시물 개수 : "+total+"리턴완료");
			return total;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("countPostAll() 에러");
		}
		return  0;
	}
	
	// 해당 아이디가 작성한 총 게시물 개수
		public int countPostID(int idStudentNum){
			
			String sql = "select count(*) total from post where onoff=1 and studentNum = ?";
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, idStudentNum);
				ResultSet rsTot = pstm.executeQuery();
				rsTot.next();
				int total = rsTot.getInt("total");
				System.out.println("해당 아이디 총 게시물 개수 : "+total+"리턴완료");
				return total;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("countPostID() 에러");
			}
			return  0;
		}
		
		// 특정한 게시판 값 의 모든 정보를 가져옴
		public Post getPost(int postNum) {
			String sql = "select * from post where postNum = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, postNum);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					Post post = new Post();
					post.setPostNum(rs.getInt(1));
					post.setStudentNum(rs.getInt(2));
					post.setTitle(rs.getString(3));
					post.setContent(rs.getString(4));
					post.setLikeCount(rs.getInt(5));
					post.setCommentCount(rs.getInt(6));
					post.setDate(rs.getString(7));
					post.setBoard(rs.getString(8));
					post.setOnoff(rs.getInt(9));
					
					return post;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null; 
		}
		// -------------------글쓰기--------------
		
		
		
		//날짜를 불러옴
		public String getDate() {
			String sql = "select now()";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
				return rs.getString(1);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return ""; 
		}
		
		
		
		
		// 저장할 새롭게 게시판의 번호를 지정
		public int getNext() {
			String sql = "select postNum from post order by postNum desc";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				if(rs.next()) {
				return rs.getInt(1) + 1;
				}
				return 1; // 
			} catch(Exception e) {
				e.printStackTrace();
			}
			return -1; // 
		}
		
	
			//게시판 이름(익명게시판)
				public String getBoard() {
					String sql = "select board from post order by postNum desc";
					try {
						PreparedStatement psmt = conn.prepareStatement(sql);
						ResultSet rs = psmt.executeQuery();
						if(rs.next()) {
						return rs.getString(1);
						}
						return sql; // 
					} catch(Exception e) {
						e.printStackTrace();
					}
					return sql; // 
				}				
		
		//글쓰기
		public int write(String title, int studentNum, String content) {
			String sql = "insert into post values(?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, getNext());
				psmt.setInt(2, studentNum);
				psmt.setString(3, title);
				psmt.setString(4, content);
				psmt.setInt(5, 0);
				psmt.setInt(6, 0);
				psmt.setString(7, getDate());
				psmt.setString(8, getBoard());
				psmt.setInt(9, 1);
				return psmt.executeUpdate(); // 
			} catch(Exception e) {
				e.printStackTrace();
			}
			return -1; //
		}
		
		// 글 수정
		public int update(int postNum, String title, String content) {
			String sql = "UPDATE POST SET TITLE=?,CONTENT=? WHERE POSTNUM=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(3, postNum);
				psmt.setString(1, title);
				psmt.setString(2, content);
				
				return psmt.executeUpdate(); // 첫번째 게시글인 경우
			} catch(Exception e) {
				e.printStackTrace();
			}
			return -1; // 데이터 베이스 호출
		}
//	--------------------------------------------------------------------
	
//	user  ----------------------------------------------------------------
	// 유저 전체 목록 불러오기
	public List<User> selectUserAll(){
		List<User> userList = new ArrayList<>();
		String sql = "select * from user";
		User user = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int studentNum = rs.getInt("studentNum");
				String userID =  rs.getString("userID");
				String nickName =  rs.getString("nickName");
				String pw =  rs.getString("pw");
				String email =  rs.getString("email");
				user = new User(studentNum,userID,nickName,pw,email); 
				userList.add(user);
			}
			rs.close();
			pstm.close();
			System.out.println("유저 전체 목록 리턴");
			return userList;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("selectUserAll() 에러");
		}
		
		return null;
	}
	
	
	//로그인 기능
	public int login(String userID, String pw) {
		String SQL = "select pw from user where userID = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(SQL);
			psmt.setString(1, userID);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(pw)) {
					return 1; 
				}
				else{
					return 0; 
				}
			}
			return -1; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; 
	}
	
	
	//studetNum 확인
	public int selectStudentNum(String userID) {
		String sql = "select studentNum from user where userId = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userID);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
			return	rs.getInt(1);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return -1; // 데이터 베이스 실패 
		
	}
	

	
	
	//회원가입
	public int join(User user) {
		String SQL = "insert into user(userID,nickName,pw,email) values(?, ?, ?, ?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(SQL);
			psmt.setString(1, user.getUserID());
			psmt.setString(2, user.getPw());
			psmt.setString(3, user.getNickName());
			psmt.setString(4, user.getEmail());
			return psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //
	}
	

	// 학번으로 유저 한명 정보 불러오기
			public User selectUserOne(int num){
				String sql = "select studentNum, userID, nickName, pw, email from user "
						+ "where studentNum = ?";
				User user = null;
				try {
					PreparedStatement pstm = conn.prepareStatement(sql);
					pstm.setInt(1, num); //물음표 안에 int num값.
					ResultSet rs = pstm.executeQuery();
					while(rs.next()) {
						int studentNum = rs.getInt("studentNum");
						String userID =  rs.getString("userID");
						String nickName =  rs.getString("nickName");
						String pw =  rs.getString("pw");
						String email =  rs.getString("email");
						user = new User(studentNum,userID,nickName,pw,email);
					}
					rs.close();
					pstm.close();
					System.out.println("학번으로 유저 정보 불러오기");
					return user;
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("selectUserOne() 에러");
				}
				return null;
			}
			
			//유저 정보 수정
			public int updateUser(User user) {
				String sql = "update user set nickname=?, pw=?, email=?"
						+ " where studentNum=?";
				
				try {
					PreparedStatement pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, user.getNickName());
					pstm.setString(2, user.getPw());
					pstm.setString(3, user.getEmail());
					pstm.setInt(4, user.getStudentNum());
					int res = pstm.executeUpdate();
					System.out.println("처리된 행의 개수:"+res);
					pstm.close();
					return res;
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("updateUser() 에러");
				}
				return 0;
				
			}
			
	
//	--------------------------------------------------------------------
	
//	comment  -------------------------------------------------------------
	// 댓글 전체 목록 불러오기
	public List<Comment> selectCommentAll(){
		List<Comment> commentList = new ArrayList<>();
		String sql = "select * from comment";
		Comment comment = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int commentNum = rs.getInt("commentNum");
				int postNum =  rs.getInt("postNum");
				int studentNum =  rs.getInt("studentNum");
				String commentContent =  rs.getString("commentContent");
				String date =  rs.getString("date");
				comment = new Comment(commentNum,postNum,studentNum,commentContent,date); 
				commentList.add(comment);
			}
			rs.close();
			pstm.close();
			System.out.println("댓글 전체 목록 리턴");
			return commentList;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("selectCommentAll() 에러");
		}
		
		return null;
	}
	
	// 해당 아이디가 댓글 단 목록 전체 불러오기(post제목까지)
	public List<Comment> selectCommentID(int idStudentNum, int index_no){
		List<Comment> commentList = new ArrayList<>();
		String sql = "select c.commentNum, c.studentNum, c.postNum, c.commentContent, c.date, p.title " + 
				"from comment c, post p " + 
				"where c.postNum = p.postNum and c.studentNum = ? order by date desc limit ?,10";
		Comment comment = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idStudentNum);
			pstm.setInt(2, index_no);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int commentNum =  rs.getInt("commentNum");
				int studentNum =  rs.getInt("studentNum");
				int postNum =  rs.getInt("postNum");
				String commentContent =  rs.getString("commentContent");
				String date =  rs.getString("date");
				String title =  rs.getString("title");
				comment = new Comment(commentNum, postNum, studentNum, commentContent, date, title); 
				commentList.add(comment);
			}
			//System.out.println("해당 아이디가 댓글 단 목록 리턴"+commentList.get(0).getTitle());
			rs.close();
			pstm.close();
			return commentList;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("selectCommentID() 에러");
		}
		
		return null;
	}
	
	// 해당 아이디가 작성한 총 댓글 개수
		public int countCommentID(int idStudentNum){
			String sql = "select count(*) total from comment where studentNum = ? ";
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, idStudentNum);
				ResultSet rsTot = pstm.executeQuery();
				rsTot.next();
				int total = rsTot.getInt("total");
				System.out.println("해당 아이디 총 댓글 수 : "+total+"리턴완료");
				return total;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("countCommentID() 에러");
			}
			return  0;
		}
	
	// 해당 글 댓글 수
	public int countLikeComment(int PostNum){
		String sql = "select count(*) total from comment where PostNum = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, PostNum);
			ResultSet rsTot = pstm.executeQuery();
			rsTot.next();
			int total = rsTot.getInt("total");
			System.out.println("해당 게시글 댓글 수 : "+total+"리턴완료");
			return total;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("countLikeComment() 에러");
		}
		return  0;
	}
		
//	--------------------------------------------------------------------
//		like --------------------------------------------------------------------
//		like_table  ----------------------------------------------------------
		public List<Post> selectLikeID(int idStudentNum,int index_no){
			List<Post> likeList = new ArrayList<>();
			String sql = "select l.postNum, p.title, p.content, p.date " + 
					"from like_table l, post p " + 
					"where l.postNum = p.postNum and l.studentNum = ? order by postNum desc limit ?,10";
			Post like = null;
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, idStudentNum);
				pstm.setInt(2, index_no);
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					int postNum = rs.getInt("postNum");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String date = rs.getString("date");
					like = new Post(postNum,title, content,date); 
					likeList.add(like);
				}
				rs.close();
				pstm.close();
				System.out.println(" 리턴");
				return likeList;
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("selectLikeID() 에러");
			}
			
			return null;
		}
			
		public int LikeOnOff(int likePostNum, int likeStudentNum){
			String sql = "select count(*) from like_table where postNum = ? and studentNum = ?";
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, likePostNum);
				pstm.setInt(2, likeStudentNum);
				ResultSet rsTot = pstm.executeQuery();
				rsTot.next();
				int total = rsTot.getInt(1);
				System.out.println("게시판 좋아요표시 : "+total+"리턴완료");
				return total;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("LikeOnOff() 에러");
			}
			return  0;
		}
			
	// 해당 아이디가 누른 좋아요 개수
			public int countLikeID(int idStudentNum){
				String sql = "select count(*) total from like_table where studentNum = ?";
				try {
					PreparedStatement pstm = conn.prepareStatement(sql);
					pstm.setInt(1, idStudentNum);
					ResultSet rsTot = pstm.executeQuery();
					rsTot.next();
					int total = rsTot.getInt("total");
					System.out.println("해당 아이디가 누른 총 좋아요 수 : "+total+"리턴완료");
					return total;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("countCommentID() 에러");
				}
				return  0;
			}	
			
		// 해당 글 좋아요 수
			public int countLikePost(int PostNum){
				String sql = "select count(*) total from like_table where PostNum = ?";
				try {
					PreparedStatement pstm = conn.prepareStatement(sql);
					pstm.setInt(1, PostNum);
					ResultSet rsTot = pstm.executeQuery();
					rsTot.next();
					int total = rsTot.getInt("total");
					System.out.println("해당 글 총 좋아요 수 : "+total+"리턴완료");
					return total;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("countLikePost() 에러");
				}
				return  0;
			}	
			
			
//-------------------------------------------------------------------------
	public static void main(String[] args) {
		//게시글 전체 목록 불러오기 - 내림차순 정렬 check
		System.out.println("게시글 전체 목록 불러오기 - 내림차순 정렬 check");
		Dao dao = Dao.getInstance();
//		List<Post> postCheck = dao.selectPostAll();
//		for(Post a : postCheck) {
//			System.out.println(a);
//		}
		
		//게시글 총 수
		System.out.println("총 게시글 수: "+dao.countPostAll());
		
//		//해당 아이디가쓴 글
//		List<Post> idPostCheck = dao.selectPostID(1001, 1);
//		for(Post a : idPostCheck) {
//			System.out.println(a);
//		}
		
		//해당아이디가 댓글 단 글
		List<Comment> idCommentCheck = dao.selectCommentID(1001,1);
		for(Comment a : idCommentCheck) {
			System.out.println("댓"+a);
		}
		
		//
		List<Post> likeCheck = dao.selectLikeID(1001,1);
		for(Post a : likeCheck) {
			System.out.println("좋"+a.getTitle());
		}
		System.out.println("업데이트 됨? :" + dao.update(2015, "제발", "뭐냐고"));
		
		//해당아이디가 쓴 글 수
		System.out.println("아이디 총 게시글 수: "+dao.countPostID(1001));
		
		//해당아이디가 쓴 댓글 수
		System.out.println("아이디 총 댓글 수: "+dao.countCommentID(1001));
		
		//해당글 아이디가 해당글 좋아요 여부
		System.out.println("좋아요: "+dao.LikeOnOff(2001,1002));
		
		//해당아이디가 좋아요한 글 수
		System.out.println("아이디 총 좋아요 수: "+dao.countLikeID(1001));
		
		// stream
//		postCheck.stream().sorted((n1,n2)->n2.compareTo(n1)).forEach(n->System.out.println(n));
//		System.out.println("게시글 전체 목록 불러오기 완료");
//		System.out.println();
//		
//		//게시글 전체 목록 불러오기 - 내림차순 정렬 check
//		System.out.println("게시글 전체 목록 불러오기 - 내림차순 정렬 check");
//		List<User> userCheck = dao.selectUserAll();
//		userCheck.stream().sorted((n1,n2)->n2.compareTo(n1)).forEach(n->System.out.println(n));
//		System.out.println("게시글 전체 목록 불러오기 완료");
//		System.out.println();
//		
//		//게시글 전체 목록 불러오기 - 내림차순 정렬 check
//		System.out.println("게시글 전체 목록 불러오기 - 내림차순 정렬 check");
//		List<Comment> commentCheck = dao.selectCommentAll();
//		commentCheck.stream().sorted((n1,n2)->n2.compareTo(n1)).forEach(n->System.out.println(n));
//		System.out.println("게시글 전체 목록 불러오기 완료");
	
	
	
	
	}
	


}
