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

import Bean.student;
import Bean.teacher;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("id");
		String str = request.getParameter("pw");
		String pw = Hash.CreateHash.getSafetyPassword(str,num);

		String sql;
		ArrayList<student> Student = new ArrayList<student>();
		ArrayList<teacher> Teacher = new ArrayList<teacher>();

		if(isNum(num)){ //IDが学籍番号か教師のIDか判断
			int id= Integer.parseInt(request.getParameter("id"));
			sql = "select * from student_user where id = "+id+" AND password = '"+pw+"'";
			Student = DB.Dao.select(sql);

			System.out.println("配列の中身があるか"+Student.size());

			if(Student.size() == 0){
			    response.sendRedirect("http://localhost:7093/sotuken/login_form.jsp?id="+0);
			}else{
				student list = null;
				for(int i = 0 ; i < Student.size(); i++){
					list = Student.get(i);
				}
				if(list.getGrade() > 2 && list.getSubject().equals("情報システム科") || list.getSubject().equals("ネットワークセキュリティ科")){ //情報システム科orセキュリティ科であり、学年が２より大きいか判断
				    response.sendRedirect("http://localhost:7093/sotuken/login_form.jsp?id="+0);
				}else if(list.getGrade() > 3 && list.getSubject().equals("総合システム工学科")){//総合システム工学科かつ、３年を超えているか
					response.sendRedirect("http://localhost:7093/sotuken/login_form.jsp?id="+0);
				}else if(list.getGrade() > 4 && list.getSubject().equals("高度情報工学科")){
					response.sendRedirect("http://localhost:7093/sotuken/login_form.jsp?id="+0);
				}else{
					session.setAttribute("usr",list);
					String view = "/menu.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				}
			}
		}else{
			 sql = "select * from teacher_user where id = '"+num+"' AND password = '"+pw+"'";
			 Teacher = DB.Dao.select_user(sql);

			 System.out.println("配列："+Teacher.size());

			 if(Teacher.size() == 0){
				response.sendRedirect("http://localhost:7093/sotuken/login_form.jsp?id="+0);
			 }else{
				 teacher list = null;
					for(int i = 0 ; i < Teacher.size(); i++){
						list = Teacher.get(i);
					}
				session.setAttribute("usr",list);
				String view = "/menu_teacher.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			 }
		}

	}
	static boolean isNum(String number) {
	    try {
	        Integer.parseInt(number);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
