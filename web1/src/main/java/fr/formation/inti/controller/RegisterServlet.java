package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private EmployeeDaoImpl empDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        empDao = new EmployeeDaoImpl();
        empDao.begin();
        userDao = new UserDaoImpl();
        userDao.begin();
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
		String password2 = request.getParameter("password2");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		if (password.equals(password2)) {
			Employee emp = new Employee(firstName, lastName, new Date());
			User user = new User(login, password, 0);
			user.setEmp(emp);
			
			empDao.beginTransaction();
			empDao.save(emp);
			empDao.commitTransaction();
			
			userDao.beginTransaction();
			userDao.save(user);
			userDao.commitTransaction();
			
			request.setAttribute("message", "Registered in the database!");
			request.setAttribute("user", user);
			request.setAttribute("employee", emp);
			
			request.getRequestDispatcher("infos.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "Error in the password!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		userDao.close();
		empDao.close();
	}

}
