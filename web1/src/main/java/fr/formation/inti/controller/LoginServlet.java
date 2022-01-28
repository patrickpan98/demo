package fr.formation.inti.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(LoginServlet.class);
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String msg = (String) session.getAttribute("message");
		Date dateCon = (Date) session.getAttribute("dateConnection");
		String userName = (String) session.getAttribute("userName");
		
		if (msg == null) {
			response.sendRedirect(request.getContextPath());
		}
		else {
			Writer out = response.getWriter();
			out.append("<html>")
			.append("<head><title>Login</title></head>")
			.append("<body>")
			.append("<p>Re-bonjour "+userName+"!<br>")
			.append(msg+"<br>")
			.append("Date : "+dateCon+"<br>")
			.append("Session ID : "+session.getId()+"</p>")
			.append("</body>")
			.append("</html>");
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if ("root".equals(user) && "123456".equals(pass)) {
			Writer out = response.getWriter();
			Date date = new Date();
			out.append("<html>")
			.append("<head><title>Login</title></head>")
			.append("<body>")
			.append("<p>Hello "+user+", tu es connecté(e) !<br>")
			.append("Date : "+date+"</p>")
			.append("</body>")
			.append("</html>");
			
			session.setAttribute("message", "You are connected!");
			session.setAttribute("dateConnection", date);
			session.setAttribute("userName", user);
			session.setMaxInactiveInterval(300);
			
		}
		else {
//			request.getRequestDispatcher("/").forward(request, response);
			response.sendRedirect(request.getContextPath());
		}
	}
	
}