package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.student;
import Bean.teacher;

public class Dao {
	//①DBアクセスに必要な情報の定数を定義
		private final static String user = "root";
		private final static String pw = "soma1020naw";

		public Dao() {

		}
		public static int search(String sql,String genre) {
			final String url = "jdbc:mysql://localhost:3306/support_practice_system?serverTimezone=JST";
			int result = 0;

			//アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				//JDBCドライバをロードする
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pw);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				if(genre.equals("学科")){
					result = rs.getInt("department_id");
				}else{
					result = rs.getInt("class_id");
				}
				rs.close();
				//中身の詰まったArrayListを返却する
			}  catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑫DBとの切断処理
				try {
					//nullかチェックしないとNullPointerExceptionが
					//発生してしまうためチェックしている。
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return result;
		}

		public static int insertuser(int id, int gakunen, int gakka,int jugyo_class,String name, String password){
			final String url = "jdbc:mysql://localhost:3306/support_practice_system?serverTimezone=JST";
			int result = 0;

			//②アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				//③JDBCドライバをロードする
				Class.forName("com.mysql.cj.jdbc.Driver");

				//④データベースと接続する(コネクションを取ってくる)
				//第1引数→接続先URL
				//第2引数→ユーザ名
				//第3引数→パスワード
				con = DriverManager.getConnection(url, user, pw);

				//⑤SQL文の元を作成する
				//?をプレースホルダと言います。
				//後の手順で?に値を設定します。
				String sql = "INSERT INTO student_user(id, grade, department_id,class_id,name, password) VALUES(?,?,?,?,?,?)";

				//⑥SQLを実行するための準備(構文解析)
				pstmt = con.prepareStatement(sql);

				//⑦プレースホルダに値を設定
				//第1引数→何番目の?に設定するか(1から数える)
				//第2引数→?に設定する値
				pstmt.setInt(1, id);
				pstmt.setInt(2, gakunen);
				pstmt.setInt(3, gakka);
				pstmt.setInt(4, jugyo_class);
				pstmt.setString(5, name);
				pstmt.setString(6, password);

				result =  pstmt.executeUpdate();

			} catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑨DBとの切断処理
				try {
					//nullかチェックしないとNullPointerExceptionが
					//発生してしまうためチェックしている。
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return result;
		}
		public static int insert_teacher(String id, String name, String pw2) {
			final String url = "jdbc:mysql://localhost:3306/support_practice_system?serverTimezone=JST";
			int result = 0;

			//②アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				//③JDBCドライバをロードする
				Class.forName("com.mysql.cj.jdbc.Driver");

				//④データベースと接続する(コネクションを取ってくる)
				//第1引数→接続先URL
				//第2引数→ユーザ名
				//第3引数→パスワード
				con = DriverManager.getConnection(url, user, pw);

				//⑤SQL文の元を作成する
				//?をプレースホルダと言います。
				//後の手順で?に値を設定します。
				String sql = "INSERT INTO teacher_user(id,name, password) VALUES(?,?,?)";

				//⑥SQLを実行するための準備(構文解析)
				pstmt = con.prepareStatement(sql);

				//⑦プレースホルダに値を設定
				//第1引数→何番目の?に設定するか(1から数える)
				//第2引数→?に設定する値
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, pw2);

				result =  pstmt.executeUpdate();

			} catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑨DBとの切断処理
				try {
					//nullかチェックしないとNullPointerExceptionが
					//発生してしまうためチェックしている。
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return result;
		}
		public static ArrayList<student> select(String sql) {
			final String url = "jdbc:mysql://localhost:3306/support_practice_system?serverTimezone=JST";

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<student> list = new ArrayList<student>();


			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				//DBMSとの接続を確立する
				con = DriverManager.getConnection(url,user,pw);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				String department;
				int d = rs.getInt("department_id");
				if(d == 1){
					department = "情報システム科";
				}else if( d == 2){
					department = "ネットワークセキュリティ科";
				}else if( d == 3){
					department = "総合システム工学科";
				}else{
					department = "高度情報工学科";
				}

				String Class;
				int c = rs.getInt("class_id");
				if(c == 1){
					Class = "基本情報 Aクラス";
				}else if( c == 2){
					Class = "基本情報 Bクラス";
				}else if( c == 3){
					Class = "基本情報 Cクラス";
				}else if( c == 4){
					Class = "応用情報 Aクラス";
				}else{
					Class = "応用情報 Bクラス";
				}
				list.add(new student(rs.getInt("id"),rs.getInt("grade"),department,Class,rs.getString("name"),rs.getString("password")));


			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			} finally {
				// ⑧DBMSから切断する
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return list;
		}
		public static ArrayList<teacher> select_user(String sql) {
			final String url = "jdbc:mysql://localhost:3306/support_practice_system?serverTimezone=JST";

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<teacher> list = new ArrayList<teacher>();


			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				//DBMSとの接続を確立する
				con = DriverManager.getConnection(url,user,pw);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next() == true){
					list.add(new teacher(rs.getString("id"),rs.getString("name"),rs.getString("password")));
				}

			} catch (ClassNotFoundException e) {
				System.out.println("JDBCドライバが見つかりません。");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			} finally {
				// ⑧DBMSから切断する
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					System.out.println("DBアクセス時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return list;
		}

		public static int student_update(int id, int grade, int str1, int str2, String name, String password) {
			final String url = "jdbc:mysql://localhost:3306/support_practice_system?serverTimezone=JST";
			int result = 0;

			//②アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				Class.forName("com.mysql.cj.jdbc.Driver");


				con = DriverManager.getConnection(url, user, pw);

				String 	sql = "UPDATE  student_user SET grade = ? , department_id = ? , class_id = ? , name = ? , password = ? WHERE id = ?;";

				pstmt = con.prepareStatement(sql);


				pstmt.setInt(1, grade);
				pstmt.setInt(2, str1);
				pstmt.setInt(3, str2);
				pstmt.setString(4, name);
				pstmt.setString(5, password);
				pstmt.setInt(6, id);


				result =  pstmt.executeUpdate();

			} catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑨DBとの切断処理
				try {
					//nullかチェックしないとNullPointerExceptionが
					//発生してしまうためチェックしている。
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return result;
		}
		public static int teacher_update(String first_id,String id, String name, String password) {
			final String url = "jdbc:mysql://localhost:3306/support_practice_system?serverTimezone=JST";
			int result = 0;

			//②アクセスに必要な変数の初期化
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try{
				Class.forName("com.mysql.cj.jdbc.Driver");


				con = DriverManager.getConnection(url, user, pw);

				String 	sql = "UPDATE  teacher_user SET id = ? , name = ? , password = ? WHERE id = ?;";

				pstmt = con.prepareStatement(sql);


				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, password);
				pstmt.setString(4, first_id);

				result =  pstmt.executeUpdate();

			} catch (SQLException e){
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DBアクセスに失敗しました。");
				e.printStackTrace();
			} finally {
				//⑨DBとの切断処理
				try {
					//nullかチェックしないとNullPointerExceptionが
					//発生してしまうためチェックしている。
					if( pstmt != null){
						pstmt.close();
					}
				} catch(SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}

				try {
					if( con != null){
						con.close();
					}
				} catch (SQLException e){
					System.out.println("DB切断時にエラーが発生しました。");
					e.printStackTrace();
				}
			}
			return result;
		}
	}
