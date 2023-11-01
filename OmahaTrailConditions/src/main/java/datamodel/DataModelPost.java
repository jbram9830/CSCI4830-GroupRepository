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
  id INT NOT NULL AUTO_INCREMENT,    
  ... ...
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "Post")
public class DataModelPost {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   public DataModelPost() {
   }

   public DataModelPost(Integer id) {
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
      return "Post: " + this.id;
   }
}