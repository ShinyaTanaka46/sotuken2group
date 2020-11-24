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
 * Servlet implementation class change_teacher
 */
@WebServlet("/change_teacher")
public class change_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_teacher() {
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
		if(usr == null){
			//セッションスコープのデータ削除
			session.invalidate();
			//ログイン画面へリダイレクト
		    response.sendRedirect("http://localhost:7093/sotuken/Main");
		}else{
			String view = "/change_teacher2.jsp";
			String id = usr.getId();
			String sql = "select * from teacher_user where id ='"+id+"';";
			ArrayList<teacher> Teacher = DB.Dao.select_user(sql);
			session.setAttribute("usr",usr);
			request.setAttribute("list",Teacher);
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

}
