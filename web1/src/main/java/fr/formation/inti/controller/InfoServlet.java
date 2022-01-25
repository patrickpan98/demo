package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Infos Servlet</title></head>");
		
		//Infos
		out.println("<b>Infos : </b>");
		String requestUrl = request.getRequestURL().toString();
		out.println("<br><span>requestURL : "+requestUrl+"</span>");
		String requestUri = request.getRequestURI().toString();
		out.println("<br><span>requestURI : "+requestUri+"</span>");
		String contextPath = request.getContextPath().toString();
		out.println("<br><span>contextPath : "+contextPath+"</span>");
		
		//Header Infos
		out.println("<br><br><b>Headers : </b>");
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			out.println("<br>"+header+" : "+request.getHeader(header));
		}
		
		//Emplacement de l'app web dans le disque dur
		out.println("<br><br><b>Path : </b>");
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("");
		out.println("<br>"+realPath);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Infos Servlet</title></head>");
		
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		out.println("<h1>Method Post : Login = "+login+"</h1>");
		out.println("<h1>Method Post : Password = "+pass+"</h1>");
	}
	
}
