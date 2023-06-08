package user;

public class Like implements Comparable<Like>{
	private int likeNumber;
	private int studentNum;
	private int postNum;
	private String title;
	
	public Like(int likeNumber, int studentNum, int postNum) {
		super();
		this.likeNumber = likeNumber;
		this.studentNum = studentNum;
		this.postNum = postNum;
	}
	


	public int getLikeNumber() {
		return likeNumber;
	}
	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Like [likeNumber=" + likeNumber + ", studentNum=" + studentNum + ", postNum=" + postNum + "]";
	}
	@Override
	public int compareTo(Like o) {
		// TODO Auto-generated method stub
		return Integer.compare(likeNumber, o.likeNumber);
	}
	
}
