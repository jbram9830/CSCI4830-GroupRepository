package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE Post (
  post_id INT NOT NULL AUTO_INCREMENT,
  poster_alias VARCHAR(30) NOT NULL,
  trail_name VARCHAR(30), //this is allowed to be NULL because not all posts require the trail name. We will need to check for NULL at runtime.
  trail_score INT, //same here, allowed to be NULL.
  post_textbody VARCHAR(500) //same here, allowed to be NULL.
  post_report_count INT DEFAULT 0, //this should be initialized to zero when a post is created
  post_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  event_timestamp TIMESTAMP
  PRIMARY KEY (id));
 */

@Entity
@Table(name = "postTable")
public class DataModelPost {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "post_id")
   private Integer post_id;
   
   @Column(name = "poster_alias")
   private String poster_alias;

   @Column(name = "trail_name")
   private String trail_name;
   
   @Column(name = "trail_score")
   private Integer trail_score;
   
   @Column(name = "post_textbody")
   private String post_body;
   
   @Column(name = "post_report_count")
   private Integer post_report_count;

   @Column(name = "post_timestamp")
   private String post_timestamp;
   
   @Column(name = "event_timestamp")
   private String post_etimestamp;
   
   @Column(name = "post_type")
   private String post_type;
   
   
   public DataModelPost() {
	   
   }
   
   public DataModelPost(String palias, String tname, Integer tscore, String pbody, Integer prcount, String timestamp, String etimestamp, String post_type) {
	 this.poster_alias = palias;
	 this.trail_name = tname;
	 this.trail_score = tscore;
	 this.post_body = pbody;
     this.post_report_count = prcount;
     this.post_timestamp = timestamp;
     this.post_etimestamp = etimestamp;
     this.post_type = post_type;
   }
   
   
   public DataModelPost(Integer id, String poster_alias, String trail_name, Integer trail_score, String post_body, Integer prcount, String timestamp, String etimestamp, String post_type) {
      this.post_id = id;
      this.poster_alias = poster_alias;
      this.trail_name = trail_name;
      this.trail_score = trail_score;
      this.post_body = post_body;
      this.post_report_count = prcount;
      this.post_timestamp = timestamp;
      this.post_etimestamp = etimestamp;
      this.post_type = post_type;
   }

   
   	public Integer getPost_id() {
	   return post_id;
	}
	
	
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	
	
	public String getPoster_alias() {
		return poster_alias;
	}
	
	
	public void setPoster_alias(String poster_alias) {
		this.poster_alias = poster_alias;
	}
	
	
	public String getTrail_name() {
		return trail_name;
	}
	
	
	public void setTrail_name(String trail_name) {
		this.trail_name = trail_name;
	}
	
	
	public Integer getTrail_score() {
		return trail_score;
	}
	
	
	public void setTrail_score(Integer trail_score) {
		this.trail_score = trail_score;
	}
	
	
	public String getPost_body() {
		return post_body;
	}
	
	
	public void setPost_body(String post_body) {
		this.post_body = post_body;
	}
	
	
	public Integer getPost_report_count() {
		return post_report_count;
	}
	
	
	public void setPost_report_count(Integer post_report_count) {
		this.post_report_count = post_report_count;
	}
	
	
	public String getPost_timestamp() {
		return post_timestamp;
	}
	
	public String getPost_etimestamp() {
		return post_etimestamp;
	}
	
	
	public void setPost_timestamp(String post_timestamp) {
		this.post_timestamp = post_timestamp;
	}
	
	public void setPost_etimestamp(String post_etimestamp) {
		this.post_etimestamp = post_etimestamp;
	}
	
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	
	public String getPost_type() {
		return post_type;
	}


@Override
   public String toString() {
      return "Post: " + this.post_id + this.poster_alias + this.trail_name + this.trail_score + this.post_body + this.post_report_count + this.post_timestamp + this.post_type;
   }
}