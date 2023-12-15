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

@WebServlet(name="/LoadCommentsCreator", urlPatterns = "/post_comments/create_comment/*")
public class LoadCommentCreator extends HttpServlet {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("the GET request has been made to /LoadCommentsCreator");
	   StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
	   String[] pathParts = requestURL.toString().split("/",0);
	   String postIdStr = pathParts[6];
	   postIdStr = postIdStr.substring(0, postIdStr.length() - 5);
	   //postIdStr ="15";
	   int postId = Integer.parseInt(postIdStr.trim());
	   int okay = postId;
	   
	   
	   List<DataModelComment> DataModelComments = UtilDB.listDataModelComments(postId);
	   request.setAttribute("comments", DataModelComments);
	   
	   
	   List<DataModelPost> listDataModelPosts = UtilDB.listDataModelPosts();
	   DataModelPost post = null;
	   for (DataModelPost derp : listDataModelPosts) {
		      if (derp.getPost_id() == postId) {
	    		  post = derp;
	    	  }
		      }
	   
	   DataModelComments = UtilDB.listDataModelComments(postId);
	   request.setAttribute("comments", DataModelComments);
	   
	   
	   PrintWriter out = response.getWriter();
	   //response.sendRedirect("/csci4830-project1/landing2.html");
	   response.setContentType("text/html");
	   
	   
	   
      String docType = "<!DOCTYPE html>\n"; //
      out.println(docType + "<html>\n");
	      out.println("<head>");
	      out.println("<style>");
	      out.println("header {");
	      out.println("    background-color:black;");
	      out.println("    color:white;");
	      out.println("    text-align:center;");
	      out.println("    padding:5px;");
	      out.println("}");
	      out.println("");
	      out.println("section {");
	      out.println("    width:350px;");
	      out.println("    float:left;");
	      out.println("    padding:10px;");
	      out.println("}");
	      out.println("footer {");
	      out.println("    background-color:rgb(0, 0, 0);");
	      out.println("    color:rgb(0, 0, 0);");
	      out.println("    clear:both;");
	      out.println("    text-align:center;");
	      out.println("    padding:5px;");
	      out.println("}");
	      out.println("");
	      out.println("body {");
	      out.println("    font-family: Arial, sans-serif;");
	      out.println("    margin: 0;");
	      out.println("    background-color: black;");
	      out.println("    color: white;");
	      out.println("    display: flex;");
	      out.println("    flex-direction: column;");
	      out.println("    align-items: center;");
	      out.println("    justify-content: top;");
	      out.println("    height: 100vh;");
	      out.println("}");
	      out.println("");
	      out.println(".post-container {");
	      out.println("    max-height: 80%;");
	      out.println("    width: 65%;");
	      out.println("    border: 1px solid #ccc;");
	      out.println("    padding: 10px;");
	      out.println("    background-color: #e6cd8a;");
	      out.println("    color: black;");
	      out.println("}");
	      out.println("</style>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<header>");
	      out.println("<h1> Create Comment </h1>");
	      out.println("</header>");
	      out.println("<div class=\"post-container\">");
	      out.println("<section>");
	      out.println("");
	      //out.println("    <form action=\"InsertCommentDB\"" + okay + " method=\"POST\">");
	      out.println("    <form action=\"InsertCommentDB/" + okay + " method=\"POST\">");
	      out.println("");
	      out.println("        Commenter Alias: <input type=\"text\" name=\"CommenterAlias\" required=\"required\" maxlength=\"30\" placeholder=\"Max 30 characters...\"> <br />");
	      out.println("        Comment Body: <input type=\"text\" name=\"CommentBody\" required=\"required\" maxlength=\"500\"> <br />");
	      
	      
	      out.println("        <input type=\"hidden\" name=\"postId\" required=\"required\"  value=\""+okay+"\"> <br />");
	      out.println("");
	      out.println("        <input type=\"submit\" value=\"Submit\" />");
	      out.println("    </form>");
	      out.println("");
	      out.println("</section>");
	      out.println("</div>");
	      out.println("</body>");
	      out.println("</html>");

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
