package swing05_1215;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleDao {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	ArticleDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "mysql");
			System.out.println("DB 접속!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int insert(Article art) {
		String sql = 
			"insert into Article(writer, title, content, count)"
			+ " values (?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, art.writer);
			pstm.setString(2, art.title);
			pstm.setString(3, art.content);
			pstm.setInt(4, art.count);
			return pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return 0;
	}

	int delete(int id) {
		String sql = "delete from Article where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			return pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return 0;
	}
	
	int update(Article art) {
		String sql = "update Article "
				+ "set writer = ?, title = ?, content = ?, count = ?"
				+ " where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, art.writer);
			pstm.setString(2, art.title);
			pstm.setString(3, art.content);
			pstm.setInt(4, art.count);
			pstm.setInt(5, art.id);
			return pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return 0;
	}

	Article select(int sid) {
		String sql = "select * from article where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, sid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int count = rs.getInt("count");
				return new Article(id, writer, title, content, count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	List<Article> selectAll() {
		List<Article> lst = new ArrayList<Article>();
		String sql = "select id, writer, title, content, count " + "from article";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String writer = rs.getString(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				int count = rs.getInt(5);
				lst.add(new Article(id, writer, title, content, count));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;

	}

	public static void main(String[] ar) {
		ArticleDao dao = new ArticleDao();
		List<Article> lst = dao.selectAll();
//		for (Article art : lst) {
//			System.out.println(art);
//		}
		
		//스트림
		lst.stream().forEach(s -> System.out.println(s.writer));
		
		//select하나만
		Article art1 = dao.select(3);
		System.out.println(art1);
		
		//insert
//		Article art2 = new Article(0, "정1", "제목1", "내용1", 0);
//		System.out.println(dao.insert(art2));
		
		List<Article> lst1 = new ArrayList<>(); //<Article>이나 <>똑같음. 앞에꺼가 들어간다는 뜻.
		for (int i = 0; i<10; i++) {
			Article art3 = new Article(0, "정"+i, "제목"+i, "내용"+i, 0);
			lst1.add(art3);
		}
		
		lst1.stream().forEach(s-> System.out.println(dao.insert(s)));
		
		
		//위 반복문 스트림으로
		IntStream.rangeClosed(1, 10).asLongStream().forEach((e) -> {
			Article art2 = new Article(0, "강"+e, "제목"+e, "내용"+e, 0);
			lst1.add(art2);
		});
		
		
	
		

	}
}