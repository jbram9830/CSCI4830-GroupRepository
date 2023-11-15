import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.DataModelPost;
import datamodel.DataModelComment;
import util.UtilDB;

@WebServlet("/SearchDB")
public class SearchDB extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public SearchDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String keyword = request.getParameter("keyword");
		   if (keyword != null && !keyword.isEmpty()) {
	    	  keyword = keyword.trim();
	      }
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Database Result";
	      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<head><title>" + title + "</title></head>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" + //
	            "<h1 align=\"center\">" + title + "</h1>\n");
	      out.println("<ul>");
	
	      
	      List<DataModelPost> listDataModelPosts = null;
	      if (keyword != null && !keyword.isEmpty()) {
	    	  listDataModelPosts = UtilDB.listDataModelPosts(keyword);
	      } else {
	    	  listDataModelPosts = UtilDB.listDataModelPosts();
	      }
	      display(listDataModelPosts, out);
	      out.println("</ul>");
	      out.println("<a href=/csci4830-project1/search_porter.html>Try Again</a> <br>");
	      out.println("</body></html>");
   }

   void display(List<DataModelPost> listDataModelPosts, PrintWriter out) {
      for (DataModelPost post : listDataModelPosts) {
         System.out.println("[DBG]:::::::::::::::::\nID: " + post.getPost_id() + "\nAlias: " //
               + post.getPoster_alias() + "\nTrail name: "//
               + post.getTrail_name() + "\nTrail score: " //
               + post.getTrail_score() + "\nPost body: " //
               + post.getPost_body() + "\nReport count: " //
               + post.getPost_report_count() + "\nTimestamp: " //
               + post.getPost_timestamp() + "\nEvent Timestamp: " //
               + post.getPost_etimestamp());
         
         

         out.println("<li>" + post.getPost_timestamp() + ", " + post.getPost_id() + ", " //
               + post.getPoster_alias() + ", " //
               + post.getTrail_name() + ", " //
               + post.getTrail_score() + ", " //
               + post.getPost_body() + ", " //
               + post.getPost_report_count() + ", " //
               + post.getPost_etimestamp() + "</li>");
         
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
