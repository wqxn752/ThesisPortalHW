package thesisportal.hw.ThesisPortalHW3.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



import java.util.Date;


import java.util.Objects;


@Entity
@Table(name = "topic")
@NamedQueries({
    @NamedQuery(name = "thesisportal.hw.ThesisPortalHW3.core.Topic.findAll",
            query = "select u from Topic u"),
    
})
public class Topic {
    
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "created")
    private Date created;;
    
    
    
    public Topic() {
    }
    
    public Topic(String title, String description) {
    	this.title = title;
        this.description = description;
        this.created = new Date();
        
        
        System.out.println("\nCREATED NEW TOPIC " +"("+created.toGMTString()+"):");
        System.out.println("Title: " +title);
        System.out.println("Desctiption: " +description+"\n");
        
        
        
        
   }
    
   
    
    
    //getters and setters

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
	@Override
	public int hashCode(){
	    return Objects.hash(ID, title, description, created);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Topic)) {
            return false;
        }

        final Topic that = (Topic) o;

        return Objects.equals(this.ID, that.ID) &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.created, that.created);
    }

	/*@Override
	public String toString(){
		return ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}*/
	
	
    
    
  }