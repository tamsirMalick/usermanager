package vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.UserService;
import models.User;

/**
 * Servlet implementation class GestionUtlisateurs
 */
@WebServlet({ "/users/add", "/users/usersList", "/users/delete" })
public class GestionUtlisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/add.jsp";
	private static final String VUE_LIST_UTILISATEUR = "/WEB-INF/usersList.jsp";
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionUtlisateurs() {
		super();

		userService = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedUrl = request.getServletPath();
		String userId = request.getParameter("userId");
		if (requestedUrl.equals("/users/add") | requestedUrl.equals("/") && userId == null) {
			getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
		} else if (requestedUrl.equals("/users/add") && userId != null) {
			int id = Integer.parseInt(request.getParameter("userId"));
			User user = userService.getUserById(id);
			userService.updateUser(user);

			request.setAttribute("user", user);

			getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
		} else if (requestedUrl.equals("/users/delete")) {
			int id = Integer.parseInt(userId);
			for (User user : userService.listUsers()) {
				if (user.getUserId() == id) {
					userService.deleteUser(id);
					break;
				}
			}
			response.sendRedirect("usersList");
		} else {
			request.setAttribute("users", userService.listUsers());
			getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		String requestedUrl = request.getServletPath();
		String userId = request.getParameter("userId");
		if (requestedUrl.equals("/users/add") && userId == null) {
			User user = new User(firstname, lastname, email, phone, password);
			userService.addUser(user);
		} else if (requestedUrl.equals("/users/add") && userId != null) {
			for (User user : userService.listUsers()) {
				int id = Integer.parseInt(userId);
				if (user.getUserId() == id) {
					user.setFirstname(firstname);
					user.setLastname(lastname);
					user.setEmail(email);
					user.setPhone(phone);
					user.setPassword(password);
					userService.updateUser(user);
					break;
				}
			}
		}

		response.sendRedirect(request.getContextPath() + "/users/usersList");
	}
}
