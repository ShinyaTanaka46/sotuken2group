package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.teacher;

/**
 * Servlet implementation class change_teacher2
 */
@WebServlet("/change_teacher2")
public class change_teacher2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_teacher2() {
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
		HttpSession session = request.getSession();
		teacher usr = (teacher)session.getAttribute("usr");

		String first_id = usr.getId();
		System.out.println(first_id);
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String str = request.getParameter("pw");
		String pw = Hash.CreateHash.getSafetyPassword(str,id);

		int result = DB.Dao.teacher_update(first_id,id,name,pw);

		System.out.println(result);
		if(result == 1){
			String sql = "select * from teacher_user where id ='"+id+"';";
			ArrayList<teacher> usr2 = DB.Dao.select_user(sql);
			teacher list = null;
				for(int i = 0 ; i < usr2.size(); i++){
					list = usr2.get(i);
				}
			session.setAttribute("usr",list);
			String view = "/menu_teacher.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else{
		    response.sendRedirect("http://localhost:7093/sotuken/change_teacher2.jsp?id="+0);
		}
	}
}
