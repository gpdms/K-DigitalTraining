package user;

public class User implements Comparable<User>{
	// 유저 Dto
	private int studentNum; // 기본키
	private String userID;
	private String nickName ;
	private String pw;
	private String email;
	
	//생성자
	public User(int studentNum, String userID, String nickName, String pw, String email) {
		super();
		this.studentNum = studentNum;
		this.userID = userID;
		this.nickName = nickName;
		this.pw = pw;
		this.email = email;
	}
	
	
	
	public User() {
		super();
	}



	// getter, setter
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// toString
	@Override
	public String toString() {
		return "User [studentNum=" + studentNum + ", userID=" + userID + ", nickName=" + nickName + ", pw=" + pw
				+ ", email=" + email + "]";
	}
	
	// 정렬할 떄 비교 메소드(기본: studentNum 오름차순)
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return Integer.compare(studentNum, o.studentNum);
	}

	
}
