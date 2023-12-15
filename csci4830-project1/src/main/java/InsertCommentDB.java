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

@WebServlet(name="/InsertCommentDB", urlPatterns = "/post_comments/create_comment/InsertCommentDB/*")
public class InsertCommentDB extends HttpServlet{
   private static final long serialVersionUID = 1L;

   public InsertCommentDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
	   String[] pathParts = requestURL.toString().split("/",0);
	   String postIdStr = pathParts[7];
	   
	   char check1 = postIdStr.charAt(2);
	   char check2 = postIdStr.charAt(3);
	   char check3 = postIdStr.charAt(4);
	   
	   if (Character.isDigit(check3) && check3 != '%' && check3 != '#') {
		   postIdStr = postIdStr.substring(0, 3);
	   }
	   else if (Character.isDigit(check2)) {
		   postIdStr = postIdStr.substring(0, 2);
	   }
	   else if (Character.isDigit(check1)) {
		   postIdStr = postIdStr.substring(0, 1);
	   }
	   else {
		   
	   System.out.println("Invalid post ID");
	   }
	   

	   
	   

	   //int post_id = 0;
	   String commenter_alias = null;
	   String comment_body = null;
	   int i = 0;
	   for (String thing : pathParts) {
		   System.out.println("HEY! "+i+" "+thing);
		   i++;
	   }

	   String postId_string = request.getParameter("postId");

	   
	   

	   int post_id = Integer.parseInt(postId_string);
	   System.out.println("ID IS " + post_id);

	   
	   commenter_alias = request.getParameter("CommenterAlias").trim();
	   comment_body = request.getParameter("CommentBody").trim();

      
      
      System.out.println("the GET request has been made to /InsertCommentDB");
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
	   
	   LocalDateTime localDateTime = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       String formattedDateTime = localDateTime.format(formatter);
       
       DataModelComment comment = new DataModelComment();
       
       comment.setPost_id(post_id);
       comment.setComment_alias(commenter_alias);
       comment.setComment_body(comment_body);
       comment.setComment_timestamp(formattedDateTime);
       comment.setComment_report_count(0);
       

       
	   UtilDB.createDataModelComment(comment.getPost_id(), comment.getComment_alias(), comment.getComment_body(), comment.getComment_timestamp(), comment.getComment_report_count());
	    	  
       
	   
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/post_comments/"+comment.getPost_id()+".html\" />");
      out.println("</head>");
      out.println("<body style=\"background-color:black;\">");
      out.println("</body>");
      out.println("</html>");



   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}