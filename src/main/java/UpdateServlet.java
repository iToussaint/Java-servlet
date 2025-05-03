

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dateOfBirth");
		
		int id = Integer.parseInt(request.getParameter("id"));

		Dao dao = new Dao();
		User userToUpdate = dao.getUserById(id);
		
		
		if(firstName.trim().isEmpty() || firstName == null) {
			firstName = userToUpdate.getFirstName();
		}
		if(lastName.trim().isEmpty() || lastName == null) {
			lastName = userToUpdate.getLastName();
		}
		if(gender.trim().isEmpty() || gender == null) {
			gender = userToUpdate.getGender();
		}
		if(dateOfBirth.trim().isEmpty() || dateOfBirth == null) {
			dateOfBirth = userToUpdate.getDateOfBirth();
		}
		
		
		
		dao.updateUser(new User(firstName, lastName, gender, dateOfBirth), id);

		
		response.sendRedirect("UsersServlet");
	}

}
