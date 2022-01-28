package fr.formation.inti.controller.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        this.userDao = new UserDaoImpl();
        this.userDao.begin();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		
		userDao.begin();
		userDao.beginTransaction();
		User user = userDao.findByLoginAndPassword(login, password);
		userDao.commitTransaction();
		
		
		if (user==null) {
			request.setAttribute("message", "User introuvable");
			request.getRequestDispatcher("jspEl.jsp").forward(request, response);
			return;
		}
		
		Employee emp = user.getEmp();
		
		request.setAttribute("message", "Hello!");
		request.setAttribute("user", user);
		request.setAttribute("employee", emp);
		request.getRequestDispatcher("infos.jsp").forward(request, response);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		this.userDao.close();
	}
	
}
