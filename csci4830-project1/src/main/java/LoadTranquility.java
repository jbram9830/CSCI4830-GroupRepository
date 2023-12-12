


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

@WebServlet(name="/LoadTranquility", urlPatterns = "/tranquility.html")
public class LoadTranquility extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   List<DataModelPost> listDataModelPosts = UtilDB.listDataModelPosts();
	   request.setAttribute("posts", listDataModelPosts); // Will be available as ${products} in JSP
	   //request.getRequestDispatcher("/WEB-INF/posts.jsp").forward(request, response);
	   
	   for (DataModelPost post : listDataModelPosts) {
		      if (post.getPost_report_count() > 1) {
	    		  UtilDB.deletePost(post.getPost_id().toString());
	    	  }
		      }
	   
	   listDataModelPosts = UtilDB.listDataModelPosts();
	   request.setAttribute("posts", listDataModelPosts);
	   
	   System.out.println("the GET request has been made to /LoadTranquility");
	   PrintWriter out = response.getWriter();
	   response.setContentType("text/html");
	   
	   
	   
      String docType = "<!DOCTYPE html>\n"; //
      out.println(docType + "<html>\n");
      out.println("<head>");
      	out.println("<meta charset=\"UTF-8\">");
      	out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	      out.println("<title>Omaha Trail Conditions</title>");
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
	      
	      //
	      //IMAGES
	      //platte https://i.imgur.com/UCmjzJJ.png
	      //
	      //w1 https://i.imgur.com/wI2KGxe.png
	      //w2 https://i.imgur.com/dqS665W.png
	      //w3 https://i.imgur.com/RRrQBbD.png
	      //w4 https://i.imgur.com/nLK11iE.png
	      //w5 https://i.imgur.com/WbDkNkz.png

	      
	      //REFRESH BUTTON
	      out.println("button2 {");
	      out.println("background-color: #ecaf05;");
	      out.println("background-image: url('https://i.imgur.com/aXxy9qq.png');");
	      out.println("background-size: 47%;");
	      out.println("background-position: center;");
	      out.println("width: 3%;");
	      out.println("background-repeat: no-repeat;");
	      out.println("color: #000000;");
	      out.println("text-align: center;");
	      out.println("height: 90%");
	      out.println("}");
	      
	      out.println("button2:hover {");
	      out.println("background-color: #b78702;");
	      out.println("color: #ffffff;");
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
	     

	      //EVENT BODY
	      out.println(".event-body {");
	      out.println("color: black;");
	      out.println("background-color: #e68a8a;");
	      out.println("max-width: 400px;");
	      out.println("position: relative;");
	      out.println("margin-bottom: 20px;");
	      out.println("padding-left: 1%;");
	      out.println("padding-right: 1%;");
	      out.println("padding-top: 1%;");
	      out.println("padding-bottom: 1%;");
	      out.println("word-wrap: break-word;");
	      out.println("}");
	      
	    //AV BODY
	      out.println(".av-body {");
	      out.println("color: black;");
	      out.println("background-color: #ecaf05;");
	      out.println("max-width: 80%;");
	      out.println("position: relative;");
	      out.println("margin-top: 1%;");
	      out.println("margin-bottom: 1%;");
	      out.println("padding: 1%;");
	      out.println("word-wrap: break-word;");
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
	      
	      //SCORE BODY
	      out.println(".score-body {");
	      out.println("color: black;");
	      out.println("max-width: 80%;");
	      out.println("object-position: right center;");
	      out.println("margin-top: 1%;");
	      out.println("margin-bottom: 1%;");
	      out.println("padding: 1%;");
	      out.println("text-align: center;");
	      out.println("}");
	      
	    //INFO BODY
	      out.println(".info-body {");
	      out.println("color: black;");
	      out.println("position: relative;");
	      out.println("max-width: 80%;");
	      out.println("margin-top: 1%;");
	      out.println("margin-bottom: 1%;");
	      out.println("padding: 1%;");
	      out.println("text-align: center;");
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
	      

	      
	      //POST TYPE
	      out.println(".post-type {");
	      out.println("font-weight: bold;");
	      out.println("margin-top: 20px;");
	      out.println("margin-bottom: 5px;");
	      out.println("margin-left: auto;");
	      out.println("margin-right: 1%;");
	      out.println("position: relative;");
	      out.println("text-align: left;");
	      out.println("}");
	      
	      //POST ALIAS
	      out.println(".post-alias {");
	      out.println("font-weight: bold;");
	      out.println("margin-left: 1%;");
	      out.println("margin-right: auto;");
	      out.println("text-align: left;");
	      out.println("max-width: 200px;");
	      out.println("font-size: 14px;");
	      out.println("position: relative;");
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
	      
	    //POST AVATAR
	      out.println(".post-avatar {");
	      out.println("padding: 20px;");
	      out.println("max-width: 400px;");
	      out.println("text-align: left;");
	      out.println("}");
	      out.println(".end-text {");
	      out.println("padding: 20px;");
	      out.println("text-align: center;");
	      out.println("}");
	      
	    //TC CONTAINER
	      out.println(".post-tc-container {");
	      out.println("padding: 20px;");
	      out.println("max-width: 400px;");
	      out.println("text-align: center;");
	      out.println("}");
	      
	      out.println(".end-text {");
	      out.println("padding: 20px;");
	      out.println("text-align: center;");
	      out.println("}");
	     
	    //TRAIL TEXT
	      out.println(".trail-text {");
	      out.println("padding: 10px;");
	      out.println("max-width: 100%;");
	      out.println("text-align: center;");
	      out.println("font-size: 24px;");
	      out.println("font-weight: bold;");
	      out.println("}");
	      
	    //SCORE TEXT
	      out.println(".score-text {");
	      out.println("padding: 10px;");
	      out.println("max-width: 100%;");
	      out.println("text-align: center;");
	      out.println("font-size: 24px;");
	      out.println("font-weight: bold;");
	      out.println("color: #2364cd");
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
	      out.println("<a href=\"landing.html\">ALL TRAILS</a>");
	      out.println("<a href=\"platte.html\">Platte</a>");
	      out.println("<a href=\"lewisandclark.html\">Lewis & Clark</a>");
	      out.println("<a href=\"oxbow.html\">Oxbow</a>");
	      out.println("<a href=\"mandan.html\">Mandan</a>");
	      out.println("<a href=\"tranquility.html\">Tranquility</a>");
	      out.println("<a href=\"swanson.html\">Swanson</a>");
	      out.println("<a href=\"walnutcreek.html\">Walnut Creek</a>");
	      out.println("<a href=\"jewell.html\">Jewell</a>");
	      out.println("<a href=\"other.html\">Other</a>");

	      
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
	      out.println("constructor(post_id, poster_alias, trail_name, trail_score, post_body, post_report_count, post_timestamp, post_etimestamp, post_type) {");
	      out.println("this.post_id = post_id;");
	      out.println("this.poster_alias = poster_alias;");
	      out.println("this.trail_name = trail_name;");
	      out.println("this.trail_score = trail_score;");
	      out.println("this.post_body = post_body;");
	      out.println("this.post_report_count = post_report_count;");
	      out.println("this.post_timestamp = post_timestamp;");
	      out.println("this.post_etimestamp = post_etimestamp;");
	      out.println("this.post_type = post_type;");
	      out.println("}");
	      out.println("}");
	      out.println("var postList = [];");
	     
	      
	      
	      
	      //POST INFO POPULATE TO JS LIST
	      for (DataModelPost post : listDataModelPosts) {
	    	  if (post.getTrail_name() == null && (post.getPost_body().contains("Tranquility") || post.getPost_body().contains("tranquility"))){
			    	  //EVENT TYPE POST
			    	  if (post.getPost_type() == "e") {
			    	  		out.println("postList.push(new PostObject("+post.getPost_id()+", '"
			    	  +post.getPoster_alias()+"', '"+post.getTrail_name()+"', '"+post.getTrail_score()+"', '"
			    	  +post.getPost_body()+"', '"+post.getPost_report_count()+"', '"+ post.getPost_timestamp()+"', '"
			    	  +post.getPost_etimestamp()+"', '"+ post.getPost_type()+"'));");      
			    	  }
			    	  //CONDITION TYPE POST
			    	  else if (post.getPost_type() == "c") {
			    		  out.println("postList.push(new PostObject("+post.getPost_id()+", '"
			    	  +post.getPoster_alias()+"', '"+post.getTrail_name()+"', '"+post.getTrail_score()+"', '"
			    	  +post.getPost_body()+"', '"+post.getPost_report_count()+"', '"+ post.getPost_timestamp()+"', '"
			    	  + post.getPost_etimestamp()+"', '" + post.getPost_type()+"'));");
			    	  		}
			    	  //TEXT TYPE POST
			    	  else if (post.getPost_type() == " t") {
			    		  out.println("postList.push(new PostObject("+post.getPost_id()+", '"
			    	  +post.getPoster_alias()+"', '"+post.getTrail_name()+"', '"+post.getTrail_score()+"', '"
			    	  +post.getPost_body()+"', '"+post.getPost_report_count()+"', '"+ post.getPost_timestamp()+"', '"
			    	  +post.getPost_etimestamp()+"', '" + post.getPost_type()+"'));"); 
			    	  		}
			    	  //WORK TYPE POST
			          else
			          {
			        	  out.println("postList.push(new PostObject("+post.getPost_id()+", '"+post.getPoster_alias()+"', '"
			          +post.getTrail_name()+"', '"+post.getTrail_score()+"', '"+post.getPost_body()+"', '"+post.getPost_report_count()+"', '"
			          + post.getPost_timestamp()+"', '"+ post.getPost_etimestamp()+"', '" + post.getPost_type()+"'));"); 
			          }
	    	  }
	    	  else if(post.getTrail_name() == null){
	    		  continue;
	    	  }
	    	  else if(post.getTrail_name().contains("Tranquility")) {
		    	  //EVENT TYPE POST
		    	  if (post.getPost_type() == "e") {
		    	  		out.println("postList.push(new PostObject("+post.getPost_id()+", '"
		    	  +post.getPoster_alias()+"', '"+post.getTrail_name()+"', '"+post.getTrail_score()+"', '"
		    	  +post.getPost_body()+"', '"+post.getPost_report_count()+"', '"+ post.getPost_timestamp()+"', '"
		    	  +post.getPost_etimestamp()+"', '"+ post.getPost_type()+"'));");      
		    	  }
		    	  //CONDITION TYPE POST
		    	  else if (post.getPost_type() == "c") {
		    		  out.println("postList.push(new PostObject("+post.getPost_id()+", '"
		    	  +post.getPoster_alias()+"', '"+post.getTrail_name()+"', '"+post.getTrail_score()+"', '"
		    	  +post.getPost_body()+"', '"+post.getPost_report_count()+"', '"+ post.getPost_timestamp()+"', '"
		    	  + post.getPost_etimestamp()+"', '" + post.getPost_type()+"'));");
		    	  		}
		    	  //TEXT TYPE POST
		    	  else if (post.getPost_type() == " t") {
		    		  out.println("postList.push(new PostObject("+post.getPost_id()+", '"
		    	  +post.getPoster_alias()+"', '"+post.getTrail_name()+"', '"+post.getTrail_score()+"', '"
		    	  +post.getPost_body()+"', '"+post.getPost_report_count()+"', '"+ post.getPost_timestamp()+"', '"
		    	  +post.getPost_etimestamp()+"', '" + post.getPost_type()+"'));"); 
		    	  		}
		    	  //WORK TYPE POST
		          else
		          {
		        	  out.println("postList.push(new PostObject("+post.getPost_id()+", '"+post.getPoster_alias()+"', '"
		          +post.getTrail_name()+"', '"+post.getTrail_score()+"', '"+post.getPost_body()+"', '"+post.getPost_report_count()+"', '"
		          + post.getPost_timestamp()+"', '"+ post.getPost_etimestamp()+"', '" + post.getPost_type()+"'));"); 
		          }
	    	  }
	   }
	      
	      
	      out.println("postList.reverse();");
	      out.println("var postContainer = document.querySelector('.post-container');");
	      out.println("function populatePosts(data) {");
	      out.println("    var postContainer = document.querySelector('.post-container');");
	      
	      out.println("    data.forEach(function(post) {");
	      out.println("        var postElement = document.createElement('div');");
	      out.println("        postElement.className = 'post';");
	      
	      
	      
	      
	      //EVENT POST
	      out.println("if (post.post_type == 'e') {");
	      
	      out.println("        var postType = document.createElement('div');");
	      out.println("        postType.className = 'post-type';");
	      out.println("        postType.textContent = 'EVENT POST';");
	      out.println("        postElement.appendChild(postType);");
	      
	      
	      
	      
	      out.println("        var avatarBody = document.createElement('div');");
	      out.println("        avatarBody.className = 'av-body';");
	      out.println("        postElement.appendChild(avatarBody);");
	      
	      out.println("var avatar = document.createElement('div');");
	      out.println("avatar.className = 'post-avatar';");
	      out.println("var img = document.createElement('img');");
	      out.println("img.src = 'https://i.imgur.com/FYgOL3s.png';");
	      out.println("avatar.appendChild(img);");
	      out.println("avatarBody.appendChild(avatar);");
	      
	      out.println("        var posterAlias = document.createElement('div');");
	      out.println("        posterAlias.className = 'post-alias';");
	      out.println("        posterAlias.textContent = 'Poster: ' + post.poster_alias;");
	      out.println("        avatarBody.appendChild(posterAlias);");
	      
	      out.println("        var postTimestamp = document.createElement('div');");
	      out.println("        postTimestamp.className = 'post-info';");
	      out.println("        postTimestamp.textContent = post.post_timestamp;");
	      out.println("        avatarBody.appendChild(postTimestamp);");
	      
	      out.println("        var postId = document.createElement('div');");
	      out.println("        postId.className = 'post-info';");
	      out.println("        postId.textContent = 'Post ID: ' + post.post_id;");
	      out.println("        avatarBody.appendChild(postId);");
	      
	      out.println("        var eTimeBody = document.createElement('div');");
	      out.println("        eTimeBody.className = 'event-body';");
	      out.println("        postElement.appendChild(eTimeBody);");
	         
	      out.println("        var postEtimestamp = document.createElement('div');");
	      out.println("        postEtimestamp.className = 'post-text';");
	      out.println("        postEtimestamp.textContent = 'WHEN:' + post.post_etimestamp;");
	      out.println("        eTimeBody.appendChild(postEtimestamp);");
	      
	      
	      out.println("        var trailName = document.createElement('div');");
	      out.println("        trailName.className = 'post-text';");
	      out.println("        trailName.textContent = 'WHERE: ' + post.trail_name;");
	      out.println("        eTimeBody.appendChild(trailName);");
	      
	     
	      
	      out.println("}");
	      
	      //TRAIL CONDITION POST
	      out.println("if (post.post_type == 'c') {");
	      
	      out.println("        var postType = document.createElement('div');");
	      out.println("        postType.className = 'post-type';");
	      out.println("        postType.textContent = 'TRAIL CONDITION POST';");
	      out.println("        postElement.appendChild(postType);");
	      
	      out.println("        var avatarBody = document.createElement('div');");
	      out.println("        avatarBody.className = 'av-body';");
	      out.println("        postElement.appendChild(avatarBody);");
	      
	      out.println("var avatar = document.createElement('div');");
	      out.println("avatar.className = 'post-avatar';");
	      out.println("var img = document.createElement('img');");
	      out.println("img.src = 'https://i.imgur.com/UtMHtlM.png';");
	      out.println("avatar.appendChild(img);");
	      out.println("avatarBody.appendChild(avatar);");
	      
	      out.println("        var posterAlias = document.createElement('div');");
	      out.println("        posterAlias.className = 'post-alias';");
	      out.println("        posterAlias.textContent = 'Poster: ' + post.poster_alias;");
	      out.println("        avatarBody.appendChild(posterAlias);");
	      
	      out.println("        var postTimestamp = document.createElement('div');");
	      out.println("        postTimestamp.className = 'post-info';");
	      out.println("        postTimestamp.textContent = post.post_timestamp;");
	      out.println("        avatarBody.appendChild(postTimestamp);");
	      
	      out.println("        var postId = document.createElement('div');");
	      out.println("        postId.className = 'post-info';");
	      out.println("        postId.textContent = 'Post ID: ' + post.post_id;");
	      out.println("        avatarBody.appendChild(postId);");
	      
	      
	      out.println("var scoreImg = document.createElement('img');");
	      out.println("if (post.trail_score == 1) {");
	      out.println("scoreImg.src = 'https://i.imgur.com/wI2KGxe.png';}");
	      out.println("else if (post.trail_score == 2) {");
	      out.println("scoreImg.src = 'https://i.imgur.com/dqS665W.png';}");
	      out.println("else if (post.trail_score == 3) {");
	      out.println("scoreImg.src = 'https://i.imgur.com/RRrQBbD.png';}");
	      out.println("else if (post.trail_score == 4) {");
	      out.println("scoreImg.src = 'https://i.imgur.com/nLK11iE.png';}");
	      out.println("else if (post.trail_score == 5) {");
	      out.println("scoreImg.src = 'https://i.imgur.com/WbDkNkz.png';}");
	      
	      out.println("        var scoreBody = document.createElement('div');");
	      out.println("        scoreBody.className = 'score-body';");
	      out.println("scoreBody.appendChild(scoreImg);");
	      out.println("        postElement.appendChild(scoreBody);");
	      
	      
	      out.println("        var infoBody = document.createElement('div');");
	      out.println("        infoBody.className = 'info-body';");
	      out.println("        postElement.appendChild(infoBody);");
	      
	      
	      out.println("        var trailName = document.createElement('div');");
	      out.println("        trailName.className = 'trail-text';");
	      out.println("        trailName.textContent = 'Trail: ' + post.trail_name;");
	      out.println("        infoBody.appendChild(trailName);");
	      
	      out.println("        var trailScore = document.createElement('div');");
	      out.println("        trailScore.className = 'score-text';");
	      out.println("if (post.trail_score == 1) {");
	      out.println("trailScore.textContent = 'Trail Rating: Dry & Dusty';}");
	      out.println("else if (post.trail_score == 2) {");
	      out.println("trailScore.textContent = 'Trail Rating: Hero Dirt';}");
	      out.println("else if (post.trail_score == 3) {");
	      out.println("trailScore.textContent = 'Trail Rating: Damp';}");
	      out.println("else if (post.trail_score == 4) {");
	      out.println("trailScore.textContent = 'Trail Rating: Wet Spots';}");
	      out.println("else if (post.trail_score == 5) {");
	      out.println("trailScore.textContent = 'Trail Rating: Soaked';}");
	      out.println("        infoBody.appendChild(trailScore);");

	      
	      out.println("}");
	      
	      //TEXT POST
	      out.println("if (post.post_type == 't') {");
	      
	      out.println("        var postType = document.createElement('div');");
	      out.println("        postType.className = 'post-type';");
	      out.println("        postType.textContent = 'TEXT POST';");
	      out.println("        postElement.appendChild(postType);");
	      
	      out.println("        var avatarBody = document.createElement('div');");
	      out.println("        avatarBody.className = 'av-body';");
	      out.println("        postElement.appendChild(avatarBody);");
	      
	      out.println("var avatar = document.createElement('div');");
	      out.println("avatar.className = 'post-avatar';");
	      out.println("var img = document.createElement('img');");
	      out.println("img.src = 'https://i.imgur.com/UtMHtlM.png';");
	      out.println("avatar.appendChild(img);");
	      out.println("avatarBody.appendChild(avatar);");
	      
	      out.println("        var posterAlias = document.createElement('div');");
	      out.println("        posterAlias.className = 'post-alias';");
	      out.println("        posterAlias.textContent = 'Poster: ' + post.poster_alias;");
	      out.println("        avatarBody.appendChild(posterAlias);");
	      
	      out.println("        var postTimestamp = document.createElement('div');");
	      out.println("        postTimestamp.className = 'post-info';");
	      out.println("        postTimestamp.textContent = post.post_timestamp;");
	      out.println("        avatarBody.appendChild(postTimestamp);");
	      
	      out.println("        var postId = document.createElement('div');");
	      out.println("        postId.className = 'post-info';");
	      out.println("        postId.textContent = 'Post ID: ' + post.post_id;");
	      out.println("        avatarBody.appendChild(postId);");
	      
	      out.println("if (post.trail_name !== 'null') {"); //Trail name not required field; must check is null to attempt to populate
	      out.println("        var trailName = document.createElement('div');");
	      out.println("        trailName.className = 'post-text';");
	      out.println("        trailName.textContent = 'Trail: ' + post.trail_name;");
	      out.println("        postElement.appendChild(trailName);");
	      out.println("}");
	      
	      out.println("}");
	      
	      //WORK POST
	      out.println("if (post.post_type == 'w') {");
	      
	      out.println("        var postType = document.createElement('div');");
	      out.println("        postType.className = 'post-type';");
	      out.println("        postType.textContent = 'WORK REQUEST POST';");
	      out.println("        postElement.appendChild(postType);");
	      
	      out.println("        var avatarBody = document.createElement('div');");
	      out.println("        avatarBody.className = 'av-body';");
	      out.println("        postElement.appendChild(avatarBody);");
	      
	      out.println("var avatar = document.createElement('div');");
	      out.println("avatar.className = 'post-avatar';");
	      out.println("var img = document.createElement('img');");
	      out.println("img.src = 'https://i.imgur.com/UtMHtlM.png';");
	      out.println("avatar.appendChild(img);");
	      out.println("avatarBody.appendChild(avatar);");
	      
	      out.println("        var posterAlias = document.createElement('div');");
	      out.println("        posterAlias.className = 'post-alias';");
	      out.println("        posterAlias.textContent = 'Poster: ' + post.poster_alias;");
	      out.println("        avatarBody.appendChild(posterAlias);");
	      
	      out.println("        var postTimestamp = document.createElement('div');");
	      out.println("        postTimestamp.className = 'post-info';");
	      out.println("        postTimestamp.textContent = post.post_timestamp;");
	      out.println("        avatarBody.appendChild(postTimestamp);");
	      
	      out.println("        var postId = document.createElement('div');");
	      out.println("        postId.className = 'post-info';");
	      out.println("        postId.textContent = 'Post ID: ' + post.post_id;");
	      out.println("        avatarBody.appendChild(postId);");
	      
	      out.println("        var infoBody = document.createElement('div');");
	      out.println("        infoBody.className = 'info-body';");
	      out.println("        postElement.appendChild(infoBody);");
	      
	      
	      out.println("        var trailName = document.createElement('div');");
	      out.println("        trailName.className = 'trail-text';");
	      out.println("        trailName.textContent = 'Trail: ' + post.trail_name;");
	      out.println("        infoBody.appendChild(trailName);");
	      out.println("}");
	      
	      //TYPE-INDEPENDENT DATA POPULATION
	      out.println("if (post.post_body !== 'null') {"); //Body text not always a required field; must check is null to attempt to populate
	      
	      out.println("        var postBody = document.createElement('div');");
	      out.println("        postBody.className = 'post-body';");
	      out.println("        postElement.appendChild(postBody);");
	      
	      out.println("        var postText = document.createElement('div');");
	      out.println("        postText.className = 'post-text';");
	      out.println("        postText.textContent = post.post_body;");
	      out.println("        postBody.appendChild(postText);");
	      out.println("}");

	      
	      out.println("var reportPost = document.createElement('div');");
	      out.println("reportPost.className = 'post-text';");
	      out.println("reportPost.textContent = 'Report Post';");
	      out.println("reportPost.style.cursor = 'pointer';");
	      out.println("reportPost.onclick = function() {");
	      out.println("window.location.href = \"reporter.html\"");
	      out.println("};");
	      out.println("postElement.appendChild(reportPost);");
	      
	      out.println("var postComments = document.createElement('div');");
	      out.println("postComments.className = 'post-text';");
	      out.println("postComments.textContent = 'Comments';");
	      out.println("postComments.style.cursor = 'pointer';");
	      out.println("postComments.onclick = function() {");
	      //out.println("window.location.href = \"post_comments.html\"");
	      out.println("window.location.href = \"post_comments/\"+post.post_id+\".html\"");
	      out.println("};");
	      out.println("postElement.appendChild(postComments);");
	      
	      








	      

	      out.println("        postContainer.appendChild(postElement);");
	      out.println("    });");
	      out.println("}");

	      out.println("populatePosts(postList);");
	      
	      out.println("        var endNote = document.createElement('div');");
	      out.println("        endNote.className = 'end-text';");
	      out.println("        endNote.textContent = '-- End of Posts --';");
	      out.println("        postContainer.appendChild(endNote);");
	      
	      
	      
	      out.println("</script>");
	      
	      //display(listDataModelPosts, out);
	      
	      out.println("</html>");

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
               + post.getPost_etimestamp() + "\nPost Type: " //
               + post.getPost_type());

         
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
