# :herb: 익명게시판
+ 기간 : 23/1/2 ~ 23/1/27
+ 기술
  - Java 
  - JSP
  - MySQL
  - jQuery, AJAX
  - Bootstrap, CSS

+ 팀원 : 총 5명
+ 나의 역할 : [검색, 마이페이지, 회원정보 수정, 프로필 이미지] 관련 백엔드&프론트엔드, 게시판 프론트엔드

## 담당부분 소스코드

### [Dao](https://github.com/gpdms/K-DigitalTraining/blob/main/JavaProgramming2/JSPteamproject/src/user/Dao.java)
#### :point_down: 검색
```java
		//검색한 단어 포함한 게시물 목록 불러오기
		public List<Post> selectSearchedList(String searchWord, int index_no){
			List<Post> searchedList = new ArrayList<>();
			
			String sql = "select * from post where (title like '%"+searchWord+"%' "
							+ "or content like '%"+searchWord+"%') order by postNum desc limit "+index_no+", 10";
			Post post = null;
			try {
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					int postNum = rs.getInt("postNum");
					int studentNum = rs.getInt("studentNum");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String date =  rs.getString("date");
					String board =  rs.getString("board");
					int onoff =  rs.getInt("onoff");
					post = new Post(postNum, studentNum, title, content, date, board, onoff); 
					searchedList.add(post);
				}
				rs.close();
				pstm.close();
				System.out.println("검색한 게시글 목록 리턴");
				return searchedList;
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("selectSearchedList() 에러");
			}
			return null;
		}
		
		//검색한 단어 포함한 게시물 개수
		public int countSearchedPostAll(String searchWord){
			String sql = "select count(*) total from post where onoff=1 "
					+ "and (title like '%"+searchWord+"%' "
					+ "or content like '%"+searchWord+"%')"
			;
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
```


#### :point_down: 회원정보 수정
```java
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
```


### jsp
#### :point_down: 마이페이지
#### [myPage.jsp](https://github.com/gpdms/K-DigitalTraining/blob/main/JavaProgramming2/JSPteamproject/WebContent/myPage.jsp)
<br/>

#### :point_down: 회원정보 수정
#### [myinfoUpdate.jsp](https://github.com/gpdms/K-DigitalTraining/blob/main/JavaProgramming2/JSPteamproject/WebContent/myinfoUpdate.jsp)
#### [myinfoUpdateAction.jsp](https://github.com/gpdms/K-DigitalTraining/blob/main/JavaProgramming2/JSPteamproject/WebContent/myinfoUpdateAction.jsp)
<br/>

#### :point_down: 검색
#### [searchedList.jsp](https://github.com/gpdms/K-DigitalTraining/blob/main/JavaProgramming2/JSPteamproject/WebContent/searchedList.jsp)
