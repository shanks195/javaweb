package tp.kits3.livedinner.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.GeneralDao;
import tp.kits3.livedinner.vo.Contact;
import tp.kits3.livedinner.vo.Menu;
import tp.kits3.livedinner.vo.Post;

/**
 * Servlet implementation class AboutServlet
 */
@WebServlet("/about/list")
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GeneralDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.dao=new GeneralDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		GeneralDao dao =new GeneralDao();
		List<Contact> contactlist = dao.findAllContact();
		List<Menu> menulist = dao.findAllMenu();
		List<Post> postlist = dao.findAllPost();
		request.setAttribute("ContactList", contactlist);
		request.setAttribute("MenuList", menulist);
		request.setAttribute("PostList", postlist);
		
		String prefix = "/WEB-INF/views/";
		String postfix = ".jsp";
		RequestDispatcher dispatcher =request.getRequestDispatcher(prefix+"about"+postfix);
		dispatcher.forward(request,response);
		
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
