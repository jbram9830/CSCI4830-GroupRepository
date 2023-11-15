package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE Comment (
  comment_id INT NOT NULL AUTO_INCREMENT,
  post_id INT NOT NULL,
  comment_textbody VARCHAR(500),
  comment_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  comment_report_count INT DEFAULT 0, //this should be initialized to zero when a comment is created
  PRIMARY KEY(comment_id),
  FOREIGN KEY(post_id) REFERENCES postTable(post_id);
);
 */
@Entity
@Table(name = "commentTable")
public class DataModelComment {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "comment_id") 
   private Integer comment_id;
   
   @Column(name = "post_id") 
   private Integer post_id;
   
   @Column(name = "comment_body") 
   private String comment_body;
   
   @Column(name = "comment_timestamp") 
   private String comment_timestamp;
   
   @Column(name = "comment_report_count") 
   private Integer comment_report_count;
   
   
   public DataModelComment() {
   }
   
   public DataModelComment(Integer post_id, String comment_body, String comment_timestamp, Integer comment_report_count) {
	   this.post_id = post_id;
	   this.comment_body = comment_body;
	   this.comment_timestamp = comment_timestamp;
	   this.comment_report_count = comment_report_count;
   }

   public DataModelComment(Integer comment_id, Integer post_id, String comment_body, String comment_timestamp, Integer comment_report_count) {
      this.comment_id = comment_id;
      this.post_id = post_id;
      this.comment_body = comment_body;
      this.comment_timestamp = comment_timestamp;
      this.comment_report_count = comment_report_count;
   }

   
   
   	public Integer getComment_id() {
   		return comment_id;
	}
	
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	
	public Integer getPost_id() {
		if (post_id != null)
		{
		return post_id;
		}
		return -1;
	}
	
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	
	public String getComment_body() {
		if (comment_body != null)
		{
		return comment_body;
		}
		return "none";
	}
	
	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}
	
	public String getComment_timestamp() {
		if (comment_timestamp != null)
		{
		return comment_timestamp;
		}
		return "none";
	}
	
	public void setComment_timestamp(String comment_timestamp) {
		this.comment_timestamp = comment_timestamp;
	}
	
	public Integer getComment_report_count() {
		if (comment_report_count != null)
		{
		return comment_report_count;
		}
		return -1;
	}
	
	public void setComment_report_count(Integer comment_report_count) {
		this.comment_report_count = comment_report_count;
	}

@Override
   public String toString() {
      return "Comment: " + this.comment_id + this.post_id + this.comment_body + this.comment_timestamp + this.comment_report_count;
   }
}