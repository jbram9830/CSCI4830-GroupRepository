import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.DataModelPost;
import datamodel.DataModelComment;
import util.UtilDB;

@WebServlet(name="/InsertCommentDB")
public class InsertCommentDB extends HttpServlet{
   private static final long serialVersionUID = 1L;

   public InsertCommentDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int post_id = 0;
	   String commenter_alias = null;
	   String comment_body = null;

	   String postId_string = request.getParameter("postId");
	   
	   

	   post_id = Integer.parseInt(postId_string);

	   
	   commenter_alias = request.getParameter("CommenterAlias").trim();
	   comment_body = request.getParameter("CommentBody").trim();

      
      
      System.out.println("the GET request has been made to /InsertCommentDB");
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
	   
	   LocalDateTime localDateTime = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       String formattedDateTime = localDateTime.format(formatter);
       
       List<DataModelComment> DataModelComments = UtilDB.listDataModelComments(post_id);
	   request.setAttribute("comments", DataModelComments);
       
       for (DataModelComment comment : DataModelComments) {
		      if (comment.getPost_id() == post_id) {
	    		  UtilDB.createDataModelComment(comment.getPost_id(), comment.getComment_alias(), comment.getComment_body(), comment.getComment_timestamp(), comment.getComment_report_count());
	    	  }
       }
	   
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/landing.html\" />");
      out.println("</head>");
      out.println("<body style=\"background-color:black;\">");
      out.println("</body>");
      out.println("</html>");



   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}