package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("Register")) {
			User u = new User();
			u.setName(request.getParameter("Name"));
			u.setContact(Long.parseLong(request.getParameter("Contact")));
			u.setAddress(request.getParameter("Address"));
			u.setEmail(request.getParameter("Email"));
			u.setPassword(request.getParameter("Password"));
			
			new UserDao().insertUser(u);
			request.setAttribute("msg", "Account Registred Succesfully.");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		}
		
		else if (action.equalsIgnoreCase("Login")) {
			User u = new User();
			u.setEmail(request.getParameter("Email"));
			u.setPassword(request.getParameter("Password"));
			
			User u1 = new UserDao().userLogin(u);
			if (u1 == null) {
				request.setAttribute("msg1", "Password is Incorrect");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("data", u1);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}			
		}
		
		else if (action.equalsIgnoreCase("Edit")) {
			int ID = Integer.parseInt(request.getParameter("ID"));
			User u = new UserDao().getUserByID(ID);
			
			request.setAttribute("data", u);
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}
		
		else if (action.equalsIgnoreCase("Update")) {
			User u = new User();
			u.setID(Integer.parseInt(request.getParameter("ID")));
			u.setName(request.getParameter("Name"));
			u.setContact(Long.parseLong(request.getParameter("Contact")));
			u.setAddress(request.getParameter("Address"));
			u.setEmail(request.getParameter("Email"));
			u.setPassword(request.getParameter("Password"));
			
			new UserDao().updateUser(u);
			response.sendRedirect("Home.jsp");
		}
		
		else if (action.equalsIgnoreCase("Delete")) {
			int ID = Integer.parseInt(request.getParameter("ID"));
			User u = new UserDao().getUserByID(ID);
			new UserDao().deleteUser(u);
			response.sendRedirect("Home.jsp");
		}
	}

}
