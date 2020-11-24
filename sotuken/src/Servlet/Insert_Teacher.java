package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert_Teacher
 */
@WebServlet("/Insert_Teacher")
public class Insert_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_Teacher() {
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String str = request.getParameter("pw");
		String pw = Hash.CreateHash.getSafetyPassword(str,id);

		System.out.println(pw);

		int result = DB.Dao.insert_teacher(id,name,pw);
		if(result == 1){
		    response.sendRedirect("http://localhost:7093/sotuken/login_form.jsp?");
		}else{
		    response.sendRedirect("http://localhost:7093/sotuken/insert_teacher.jsp?id="+0);
		}
	}

}
