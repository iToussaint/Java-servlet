

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gender = request.getParameter("filter_by_gender");
		String searchBy = request.getParameter("searchByField");
		String search = request.getParameter("searchField");
		List<User> users;
		
		
		if(gender == null || gender.trim().isEmpty()) {
			if(searchBy == null || searchBy.trim().isEmpty())
			users = new Dao().getAllUsers();
			else
				users = new Dao().getAllUsers(searchBy, search);
				
	         
			
		}
		
		else {
			users = new Dao().getUsersByGender(gender);
			
			
		}
		
		request.setAttribute("users", users);
		request.setAttribute("gender", gender);
		request.setAttribute("searchBy", searchBy);
		request.setAttribute("search", search);
		
		System.out.println(gender);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UsersManagementSystem.jsp");
        
        requestDispatcher.forward(request, response);

        
	}

	

}
