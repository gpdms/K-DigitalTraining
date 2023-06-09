package user;

public class Comment implements Comparable<Comment>{
	// 댓글 Dto
	private int commentNum;
	private int postNum;
	private int studentNum;
	private String commentContent;
	private String date;
	private String title;
	
	//생성자
	public Comment(int commentNum, int postNum, int studentNum, String commentContent, String date) {
		super();
		this.commentNum = commentNum;
		this.postNum = postNum;
		this.studentNum = studentNum;
		this.commentContent = commentContent;
		this.date = date;
	}
	
	
	public Comment(int commentNum, int postNum, int studentNum, String commentContent, String date, String title) {
		super();
		this.commentNum = commentNum;
		this.postNum = postNum;
		this.studentNum = studentNum;
		this.commentContent = commentContent;
		this.date = date;
		this.title = title;
	}


	// getter, setter
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
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
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}



	
	@Override
	public String toString() {
		return "Comment [commentNum=" + commentNum + ", postNum=" + postNum + ", studentNum=" + studentNum
				+ ", commentContent=" + commentContent + ", date=" + date + ", title=" + title + "]";
	}


	// 정렬할 떄 비교 메소드(기본: commentNum 오름차순)
	@Override
	public int compareTo(Comment o) {
		// TODO Auto-generated method stub
		return Integer.compare(commentNum, o.commentNum);
	}
	
	
}
