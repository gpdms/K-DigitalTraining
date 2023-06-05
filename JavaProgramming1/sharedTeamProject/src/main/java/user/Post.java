package user;

public class Post implements Comparable<Post>{
	// 게시글 Dto
	private int postNum; // 기본키
	private int studentNum;
	private String title;
	private String content;
	private int likeCount;
	private int commentCount;
	private String date;
	private String board;
	private int onoff;
	
	//생성자
	
	
	
	public Post(int postNum, int studentNum, String title, String content, int likeCount, int commentCount, String date,
			String board, int onoff) {
		super();
		this.postNum = postNum;
		this.studentNum = studentNum;
		this.title = title;
		this.content = content;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
		this.date = date;
		this.board = board;
		this.onoff = onoff;
	}



	public Post(int postNum, String title, String content, String date) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	
	public Post(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	

	public Post() {
		super();
	}



	// getter, setter
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getOnoff() {
		return onoff;
	}
	public void setOnoff(int onoff) {
		this.onoff = onoff;
	}

	// toString
	@Override
	public String toString() {
		return "Text [postNum=" + postNum + ", studentNum=" + studentNum + ", title=" + title + ", content=" + content
				+ ", likeCount=" + likeCount + ", commentCount=" + commentCount + ", date=" + date + ", board=" + board
				+ ", onoff=" + onoff + "]";
	}

	// 정렬할 떄 비교 메소드(기본: postNum 오름차순)
	@Override
	public int compareTo(Post o) {
		// TODO Auto-generated method stub
		return Integer.compare(postNum, o.postNum);
	}
	
}
