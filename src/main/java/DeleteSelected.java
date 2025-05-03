

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteSelected
 */
@WebServlet("/DeleteSelected")
public class DeleteSelected extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSelected() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String[] ids = request.getParameterValues("selected");
		
		
		
		Dao dao = new Dao();
		
		dao.deleteUsers(ids);
		
		response.sendRedirect("UsersServlet");
		
	}
		
		

}
