

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.DataModelComment;
import datamodel.DataModelPost;
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
		boolean postTrue = false;
		boolean commentTrue = false;
		
		
		
		
		if (keywordPost != null && !keywordPost.isEmpty()) {
		List<DataModelPost> listDataModelPosts = UtilDB.listDataModelPosts();

		for (DataModelPost post : listDataModelPosts) {
			if (post.getPost_id() == Integer.parseInt(keywordPost)) {
				postTrue = true;
			}

			
			
		}
		if (!postTrue) {
			System.out.println("Invalid Post ID");
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if (keywordComment != null && !keywordComment.isEmpty()) {
		List<DataModelComment> DataModelComments = UtilDB.listDataModelComments();
		
		
		
		for (DataModelComment comment : DataModelComments) {
			if (comment.getComment_id() == Integer.parseInt(keywordComment)) {
				commentTrue = true;
			}

		}
		if (!commentTrue) {
			System.out.println("Invalid Comment ID");
		}
		}
		

		
		
		
		
		if(keywordPost != null && !keywordPost.isEmpty() && postTrue) {
			keywordPost = keywordPost.trim();
			List<DataModelComment> DataModelComments = UtilDB.listDataModelComments(Integer.parseInt(keywordPost));
			for (DataModelComment comment : DataModelComments) {
				
				String c = String.valueOf(comment.getComment_id());
				
				UtilDB.deleteComment(c);
			}
			
			UtilDB.deletePost(keywordPost);
		}
		
		
		
		
		
		
		else if(keywordComment != null && !keywordComment.isEmpty() && commentTrue) {
			keywordComment = keywordComment.trim();
			UtilDB.deleteComment(keywordComment);
		}
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/admin_dashboard.html\" />");
	    out.println("</head>");
	    out.println("<body bgColor=black>");
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