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

@WebServlet(name="/LoadCommentsDB", urlPatterns = "/post_comments/*")
public class LoadCommentsDB extends HttpServlet {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String pathInfo = request.getPathInfo();
	   String[] pathParts = pathInfo.split("/");
	   String postIdStr = pathParts[1];
	   postIdStr = postIdStr.substring(0, postIdStr.length() - 5);
	   int postId = Integer.parseInt(postIdStr);
	   
	   List<DataModelComment> DataModelComments = UtilDB.listDataModelComments(postId);
	   
	   System.out.println("the GET request has been made to /LoadCommentsDB");
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
	   
	   
	   
      String docType = "<!DOCTYPE html>\n"; //
      out.println(docType + "<html>\n");
      out.println("<head>");
      	out.println("<meta charset=\"UTF-8\">");
      	out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	      out.println("<title>Comments</title>");
	      out.println("<style>");
	      out.println("body {");
	      out.println("font-family: Arial, sans-serif;");
	      out.println("margin: 0;");
	      out.println("background-image: url('https://i.imgur.com/jdLBFcE.png');");
	      out.println("background-repeat: no-repeat;");
	      out.println("background-size: cover;");
	      out.println("color: white;");
	      out.println("display: flex;");
	      out.println("flex-direction: column;");
	      out.println("align-items: center;");
	      out.println("justify-content: flex-start;");
	      out.println("height: 100vh;");
	      out.println("}");   
	      //CREATE POST BUTTON
	      out.println("button1 {");
	      out.println("background-color: #ecaf05;");
	      out.println("width: 8%;");
	      out.println("color: #000000;");
	      out.println("text-align: center;");
	      out.println("font-size: 16px;");
	      out.println("font-weight: bold;");
	      out.println("height: 90%");
	      out.println("}");
	      
	      out.println("button1:hover {");
	      out.println("background-color: #b78702;");
	      out.println("color: #ffffff;");
	      out.println("}");
	      
	      
	      //NAVBAR
	      out.println(".navbar {");
	      out.println("background-color: #333;");
	      out.println("height: 5%;");
	      out.println("width: 66%;");
	      out.println("display: flex;");
	      out.println("flex-flow: row nowrap;");
	      out.println("justify-content: space-evenly;");

	      out.println("padding-top: .5%;");
	      out.println("padding-bottom: .5%;");
	      out.println("overflow: hidden;");
	      out.println("}");
	      
	      out.println(".navbar a {");
	      out.println("float: center;");
	      out.println("color: white;");
	      out.println("text-align: center;");
	      out.println("padding: 1% 1.5%;");
	      out.println("text-decoration: none;");
	      out.println("}");
	      
	      out.println(".navbar a:hover {");
	      out.println("background-color: #ddd;");
	      out.println("color: black;");
	      out.println("}");
	      
	      //POST CONTAINER
	      out.println(".post-container {");
	      out.println("height: 80%;");
	      out.println("width: 65%;");
	      out.println("overflow-y: scroll;");
	      out.println("padding: 10px;");
	      out.println("}");
	     

	      
	      //POST BODY
	      out.println(".post-body {");
	      out.println("color: black;");
	      out.println("background-color: #e0dede;");
	      out.println("max-width: 80%;");
	      out.println("position: relative;");
	      out.println("margin-top: 1%;");
	      out.println("margin-bottom: 1%;");
	      out.println("padding: 1%;");
	      out.println("word-wrap: break-word;");
	      out.println("}");
	      

	      
	      //POST
	      out.println(".post {");
	      out.println("margin-bottom: 20px;");
	      out.println("background-color: darkgrey;");
	      out.println("padding: 10px;");
	      out.println("border-radius: 2px;");
	      out.println("position: relative;");
	      out.println("padding-left: 5%;");
	      out.println("padding-right: 5%;");
	      out.println("}");
	      
	      //POST INFO
	      out.println(".post-info {");
	      out.println("font-weight: lighter;");
	      out.println("margin-left: 1%;");
	      out.println("margin-right: auto;");
	      out.println("text-align: left;");
	      out.println("max-width: 200px;");
	      out.println("font-size: 10px;");
	      out.println("position: relative;");
	      out.println("}");

	      //POST TEXT
	      out.println(".post-text {");
	      out.println("padding: 20px;");
	      out.println("max-width: 80%;");
	      out.println("text-align: left;");
	      out.println("}");
	      
	      out.println(".end-text {");
	      out.println("padding: 20px;");
	      out.println("text-align: center;");
	      out.println("}");
	      out.println("</style>");
	      out.println("</head>");
	      
	      // // // // // // // / // // // // // // / // // // // // // / // // // // // // / // // // // // // / // // // // // // 
	     
	      out.println("<body>");
	      out.println("<h1>Omaha Trail Conditions</h1>");
	      out.println("<div class=\"navbar\">");
	      out.println("<a href=\"#\">ALL TRAILS</a>");
	      out.println("<a href=\"#\">Platte</a>");
	      out.println("<a href=\"#\">Lewis & Clark</a>");
	      out.println("<a href=\"#\">Oxbow</a>");
	      out.println("<a href=\"#\">Mandan</a>");
	      out.println("<a href=\"#\">Tranquility</a>");
	      out.println("<a href=\"#\">Swanson</a>");
	      out.println("<a href=\"#\">Walnut Creek</a>");
	      out.println("<a href=\"#\">Jewell</a>");
	      out.println("<a href=\"#\">Other</a>");

	      out.println("<a href=/csci4830-project1/create_post.html class=\"button1\">");
	      out.println("Create Post");
	      out.println("</a>");
	      

	      out.println("</div>");

	      out.println("<div class='post-container'>");
	      out.println("</div>");
	      
	      out.println("</body>");
	      
	      //JS CLASS TO STORE "POST OBJECT" INFO, WHICH POPULATES A LIST OF "POST OBJECTS" FOR THE JS SCRIPT
	      out.println("<script>");
	      out.println("class PostObject {");
	      out.println("  constructor(comment_id, post_id, commenter_alias, comment_body, comment_timestamp, crcount) {");
	      out.println("    this.comment_id = comment_id;");
	      out.println("    this.post_id = post_id;");
	      out.println("    this.commenter_alias = commenter_alias;");
	      out.println("    this.comment_body = comment_body;");
	      out.println("    this.comment_timestamp = comment_timestamp;");
	      out.println("    this.crcount = crcount;");
	      out.println("  }");
	      out.println("}");

	      out.println("var postList = [];");
	      out.println("postList.push(new PostObject(1, 15, 'tporter2', 'good job!!!', '2023-12-10 23:51:57', 0));");
	      out.println("var postContainer = document.querySelector('.post-container');");

	      out.println("function populatePosts(data) {");
	      out.println("  var postContainer = document.querySelector('.post-container');");
	      out.println("  data.forEach(function (post) {");
	      out.println("    var postElement = document.createElement('div');");
	      out.println("    postElement.className = 'post';");

	      out.println("    var posterAlias = document.createElement('div');");
	      out.println("    posterAlias.className = 'post-text';");
	      out.println("    posterAlias.textContent = 'Poster: ' + post.commenter_alias;");
	      out.println("    postElement.appendChild(posterAlias);");

	      out.println("    var postTimestamp = document.createElement('div');");
	      out.println("    postTimestamp.className = 'post-text timestamp';");  // Add a class for styling
	      out.println("    postTimestamp.textContent = post.comment_timestamp;");
	      out.println("    postElement.appendChild(postTimestamp);");

	      out.println("    var postTextContainer = document.createElement('div');");
	      out.println("    postTextContainer.className = 'post-text-container';"); // Add a container for post text
	      out.println("    postElement.appendChild(postTextContainer);");

	      out.println("    var postText = document.createElement('div');");
	      out.println("    postText.className = 'post-text';");
	      out.println("    postText.textContent = post.comment_body;");
	      out.println("    postTextContainer.appendChild(postText);");
	      

	      out.println("var createComment = document.createElement('div');");
	      out.println("createComment.className = 'end-text';");
	      out.println("createComment.textContent = 'Create Comment';");
	      out.println("createComment.style.cursor = 'pointer';");
	      out.println("postContainer.appendChild(createComment);");
	      out.println("createComment.onclick = function() {");

	      out.println("window.location.href = \"create_comment/\"+post.post_id+\".html\"");

	      out.println("};");
	      
	      

	      out.println("    postContainer.appendChild(postElement);");
	      out.println("  });");
	      out.println("}");

	      out.println("populatePosts(postList);");
	      
	      
	 

	      out.println("</script>");
	      out.println("</html>");
	      
	      //display(listDataModelPosts, out);
	      
	      out.println("</html>");

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
