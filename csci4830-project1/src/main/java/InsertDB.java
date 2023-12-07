import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDB;

@WebServlet("/InsertDB")
public class InsertDB extends HttpServlet{
   private static final long serialVersionUID = 1L;

   public InsertDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String user_alias = null;
	   String post_body = null;
	   String trail_name = null;
	   String score_string = null;
	   String event_date_time = null;
	   int score = 0;
       
	   
	   
	   user_alias = request.getParameter("UserAlias").trim();
	   if (request.getParameter("TrailName") != null) {
	   trail_name = request.getParameter("TrailName").trim();
	   }
	   if (request.getParameter("PostBody") != null) {
	   post_body = request.getParameter("PostBody").trim();
	   }
	   if (request.getParameter("Score") != null) {
	   score_string = request.getParameter("Score").trim();
	   score = Integer.parseInt(score_string);
	   }
	   if (request.getParameter("EventDateTime") != null) {
	   event_date_time = request.getParameter("EventDateTime").trim();
	   }
      
      
      
      System.out.println("the GET request has been made to /InsertDB");
	   PrintWriter out = response.getWriter();
	   //response.sendRedirect("/csci4830-project1/landing2.html");
	   response.setContentType("text/html");
	   
	   LocalDateTime localDateTime = LocalDateTime.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       String formattedDateTime = localDateTime.format(formatter);
       
	   if (score == 0 && event_date_time == null && trail_name == null)
	   {
		   UtilDB.createDataModelPost(user_alias, trail_name, score, post_body, formattedDateTime, null, "t");
	   }
	   else if (event_date_time != null)
	   {
		   UtilDB.createDataModelPost(user_alias, trail_name, null, post_body, formattedDateTime, event_date_time, "e");
	   }
	   else if (score != 0)
	   {
		   UtilDB.createDataModelPost(user_alias, trail_name, score, post_body, formattedDateTime, null, "c");
	   }
	   else
		   //(score == 0 && event_date_time == null && trail_name != null)
	   {
		   UtilDB.createDataModelPost(user_alias, trail_name, null, post_body, formattedDateTime, null, "w");
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