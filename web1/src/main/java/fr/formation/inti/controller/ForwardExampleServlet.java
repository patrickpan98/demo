package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class ForwardExampleServlet
 */
@WebServlet(urlPatterns = {"/forward"},
initParams = {@WebInitParam(name="driver", value="com.jdbc.coucou")})
public class ForwardExampleServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(ForwardExampleServlet.class);
	private static final long serialVersionUID = 1L;
	private String driver;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardExampleServlet() {
        super();
        log.info("------------- > new ForwardExampleServlet");
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.driver = config.getInitParameter("driver");
		log.info("------------- > method init : Driver = " + driver);
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		log.info("------------- > method service : "+request.getMethod());
//	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("------------- > method doGet");
		String forward = request.getParameter("forwardTo");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/"+forward);
		dispatcher.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("------------- > method doPost");
		doGet(request, response);
	}
	
}
