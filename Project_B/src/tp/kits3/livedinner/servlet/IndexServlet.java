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
import tp.kits3.livedinner.vo.Book;
import tp.kits3.livedinner.vo.Category;
import tp.kits3.livedinner.vo.Contact;
import tp.kits3.livedinner.vo.Menu;
import tp.kits3.livedinner.vo.Post;
import tp.kits3.livedinner.vo.Tag;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GeneralDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.dao=new GeneralDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html,charset=UTF-8");
		GeneralDao dao = new GeneralDao();
		List<Menu> menulist = dao.findAllMenu();
		List<Book> booklist = dao.findAllBook();
		List<Contact> contactlist =dao.findAllContact();
		List<Post> postlist =dao.findAllPost();
		List<Tag> taglist = dao.findAllTag();
		List<Category> categorylist = dao.findAllCategory();
		request.setAttribute("MenuList", menulist);
		request.setAttribute("BookList", booklist);
		request.setAttribute("ContactList", contactlist);
		request.setAttribute("PostList", postlist );
		request.setAttribute("TagList", taglist);
		request.setAttribute("CategoryList", categorylist);
//		List<Index> 
		String prefix ="/";
		String postfix=".jsp";
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(prefix+"index"+postfix);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
