package swing05_1215;

public class Article {
	int id;
	String writer;
	String title;
	String content;
	int count;
	
	public Article(int id, String writer, String title, String content, int count) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", writer=" + writer + ", title=" + title + ", content=" + content + ", count="
				+ count + "]";
	}
	
	
	
	
}
