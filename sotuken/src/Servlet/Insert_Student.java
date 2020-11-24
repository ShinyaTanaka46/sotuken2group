package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Insert_Student
 */
@WebServlet("/Insert_Student")
public class Insert_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("id");
		int id= Integer.parseInt(request.getParameter("id"));
		int  grade= Integer.parseInt(request.getParameter("grade"));
		String subject= request.getParameter("subject");
		String group = request.getParameter("group");
		String name = request.getParameter("name");
		String str = request.getParameter("pw");
		String pw = Hash.CreateHash.getSafetyPassword(str,num);

		//↓↓↓↓卒業年次を求めるメソッド↓↓↓↓
		int year = year(num,subject);

		String sql = "SELECT department_id FROM department WHERE department = '"+subject+"'";
		int str1 = DB.Dao.search(sql,"学科");
		System.out.println(str1);

		sql = "SELECT class_id FROM class WHERE class = '"+group+"'";

		int str2 = DB.Dao.search(sql,"クラス");
		System.out.print(str2);

		int result = DB.Dao.insertuser(id,grade,str1,str2,name,pw,year);

		System.out.println(result);
		if(result == 1){
		    response.sendRedirect("http://localhost:7093/sotuken/login_form.jsp?");
		}else{
		    response.sendRedirect("http://localhost:7093/sotuken/student.jsp?id="+0);
		}
	}

	private int year(String id, String subject) {
		char[] num = new char[(id.length())];
		String str1 = null;
		String str2 = null;

	    for(int i = 0; i < id.length(); i++){
	            num[i] =id.charAt(i);

	            if(i == 1){
	            	str1 = String.valueOf(num[i]);
	        	    System.out.println("[1]"+str1);
	            }else if( i == 2){
	            	str2 = String.valueOf(num[i]);
	        	    System.out.println("[2]"+str2);
	            }
	    }
	    String str = "20"+ str1 + str2;
	    //String str = String.valueOf(num[1]+num[2]);
	    System.out.println("入学年次:"+str);
	    int start_year = Integer.parseInt(str);

		if(subject.equals("情報システム科") || subject.equals("ネットワークセキュリティ科")){
			start_year += 2;
		}else if(subject.equals("総合システム工学科")){
			start_year += 3;
		}else if(subject.equals("高度情報工学科")){
			start_year += 4;
		}

		return start_year;
	}
}
