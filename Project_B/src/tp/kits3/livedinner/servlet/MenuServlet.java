package tp.kits3.livedinner.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tp.kits3.livedinner.dao.GeneralDao;

import tp.kits3.livedinner.vo.Category;
import tp.kits3.livedinner.vo.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu/list")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GeneralDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.dao=new GeneralDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Menu menu = new Menu();
//		Gson gson = new Gson();
//		String json=gson.toJson(menu);
//		gson.fromJson(json,Category.class);
//		response.getWriter().append(json);
//		
		response.setContentType("text/html;charset=UTF-8");
		
		GeneralDao dao = new GeneralDao();
		List<Menu> menulist = dao.findAllMenu();
		request.setAttribute("MenuList", menulist);
		
		// Servlet to Servlet <context-param>
		
		String prefix = "/WEB-INF/views/";
		String postfix = ".jsp";
		RequestDispatcher dispatcher = 
		request.getRequestDispatcher(prefix+"menu"+postfix);
		dispatcher.forward(request,response);
		
	

		
		
//		ServletContext ctx = getServletContext();
//		ctx.setAttribute("menu", new Menu());
//		ctx.getAttribute("menu");
		
		
		
//		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/menuList.jsp");
//		dispatcher.forward(request,response);
		  
		
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
