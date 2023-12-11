import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDB;

@WebServlet("/Reporter")
public class Reporter extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   public Reporter() {
	      super();
	   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   
       
	   String postIdStr = request.getParameter("postId").trim();
	   int postId = Integer.parseInt(postIdStr);
	   
	   
	   System.out.println("the GET request has been made to /Reporter for postID:"+postIdStr);
	   PrintWriter out = response.getWriter();
	   //response.sendRedirect("/csci4830-project1/landing2.html");
	   response.setContentType("text/html");

         if (postIdStr != null) {
               postId = Integer.parseInt(postIdStr);
               UtilDB.incrementReportCount(postId);
         }
         
         
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<meta http-equiv=\"refresh\" content=\"5; url = /csci4830-project1/landing.html\" />");
         out.println("</head>");
         out.println("<body style=\"background-color:black;\">");
         out.println("</body>");
         out.println("</html>");
         
         
         
         
         
         
         
         
         
         //doGet
      }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doGet(request, response);
	   }
   
   //class
   }



