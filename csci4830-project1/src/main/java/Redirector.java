import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.DataModelPost;
import datamodel.DataModelComment;
import util.UtilDB;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Redirector")
public class Redirector extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Redirector() {
	      super();
	   }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //request.getRequestDispatcher("/WEB-INF/posts.jsp").forward(request, response);
	   String type = request.getParameter("PostType");
	   System.out.println("the GET request has been made to /Redirector ... " + type);
	   //PrintWriter out = response.getWriter();
	   //response.sendRedirect("/csci4830-project1/landing2.html");
	   //response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
	   
	   
	   
	   
			//String docType = "<!DOCTYPE html>\n"; //
			//out.println(docType + "<html>\n");
			//out.println("<meta charset=\"UTF-8\">");
			//out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
			//out.println("<title>Redirecting...</title>");
	   if (type.equals("t")) {
		   response.sendRedirect("/csci4830-project1/post_text.html");
		   //out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/post_text.html\" />");
	   }
	   else if (type.equals("c")) {
		   response.sendRedirect("/csci4830-project1/post_condition.html");
		   //out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/post_condition.html\" />");
	   }
	   else if (type.equals("e")) {
		   response.sendRedirect("/csci4830-project1/post_event.html");
		   //out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/post_event.html\" />");
	   }
	   else {
		   response.sendRedirect("/csci4830-project1/post_work.html");
		   //out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/post_work.html\" />");
	   }
			   
		      //out.println("</html>");
	   
	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/landing.html\" />");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("</body>");
	      out.println("</html>");
	
	   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}