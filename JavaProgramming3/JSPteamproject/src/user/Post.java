package user;

public class Post implements Comparable<Post>{
	// 게시글 Dto
	private int postNum; // 기본키
	private int studentNum;
	private String title;
	private String content;
	private String date;
	private String board;
	private int onoff;
	
	//생성자
	
	
	
	public Post(int postNum, int studentNum, String title, String content, String date,
			String board, int onoff) {
		super();
		this.postNum = postNum;
		this.studentNum = studentNum;
		this.title = title;
		this.content = content;
		this.date = date;
		this.board = board;
		this.onoff = onoff;
	}



	public Post(int postNum, String title, String content, String date, String board) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.content = content;
		this.date = date;
		this.board = board;
	}

	public Post(int postNum, String title, String date) {
		super();
		this.postNum = postNum;
		this.title = title;
		this.date = date;
	}
	
	public Post(int postNum, String title) {
		super();
		this.postNum = postNum;
		this.title = title;
	}
	
	public Post(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Post() {}

	
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
				+ ", date=" + date + ", board=" + board
				+ ", onoff=" + onoff + "]";
	}

	// 정렬할 떄 비교 메소드(기본: postNum 오름차순)
	@Override
	public int compareTo(Post o) {
		// TODO Auto-generated method stub
		return Integer.compare(postNum, o.postNum);
	}
	
}
