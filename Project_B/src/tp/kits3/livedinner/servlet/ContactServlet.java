package tp.kits3.livedinner.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.GeneralDao;
import tp.kits3.livedinner.vo.Contact;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/contact/list")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GeneralDao dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.dao=new GeneralDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
//		GeneralDao dao =new GeneralDao(); // <-- use field
		List<Contact> contactlist = dao.findAllContact();
		request.setAttribute("ContactList", contactlist);
		
		String prefix ="/WEB-INF/views/";
		String postfix =".jsp";
		RequestDispatcher dispathcher = request.getRequestDispatcher(prefix+"contact"+postfix);
		dispathcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
