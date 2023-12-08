import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDB;

@WebServlet("/InsertDB")
public class InsertDB extends HttpServlet{
   private static final long serialVersionUID = 1L;
   private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   public InsertDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String user_alias = request.getParameter("UserAlias").trim();
      String post_body = request.getParameter("PostBody").trim();
      
      System.out.println("the GET request has been made to /LoadDB");
	   PrintWriter out = response.getWriter();
	   //response.sendRedirect("/csci4830-project1/landing2.html");
	   response.setContentType("text/html");
	  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      UtilDB.createDataModelPost(user_alias, null, null, post_body, sdf3.format(timestamp), "t");

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