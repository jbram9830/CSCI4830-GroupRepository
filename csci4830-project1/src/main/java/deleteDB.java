

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDB;

/**
 * Servlet implementation class deleteDB
 */
@WebServlet("/deleteDB")
public class deleteDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public deleteDB() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keywordPost = request.getParameter("keywordPost");
		String keywordComment = request.getParameter("keywordComment");
		if(keywordPost != null && !keywordPost.isEmpty()) {
			keywordPost = keywordPost.trim();
			UtilDB.deletePost(keywordPost);
		}
		else if(keywordComment != null && !keywordComment.isEmpty()) {
			keywordComment = keywordComment.trim();
			UtilDB.deleteComment(keywordComment);
		}
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/admin_dashboard.html\" />");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}