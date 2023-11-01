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
  id INT NOT NULL AUTO_INCREMENT,    
  ... ...
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "Comment")
public class DataModelComment {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") 
   private Integer id;

   public DataModelComment() {
   }

   public DataModelComment(Integer id) {
      this.id = id;
   }


   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   
   @Override
   public String toString() {
      return "Comment: " + this.id;
   }
}