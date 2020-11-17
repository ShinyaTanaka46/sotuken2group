package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Change_student
 */
@WebServlet("/Change_Student")
public class Change_student extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change_student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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

		String sql = "SELECT department_id FROM department WHERE department = '"+subject+"'";
		int str1 = DB.Dao.search(sql,"学科");
		System.out.println(str1);

		sql = "SELECT class_id FROM class WHERE class = '"+group+"'";

		int str2 = DB.Dao.search(sql,"クラス");
		System.out.print(str2);

		int result = DB.Dao.student_update(id,grade,str1,str2,name,pw);

		System.out.println(result);
		if(result == 1){
		    response.sendRedirect("http://localhost:7093/sotuken/menu.jsp?");
		}else{
		    response.sendRedirect("http://localhost:7093/sotuken/change.jsp?id="+0);
		}
	}

}
