package thesisportal.hw.ThesisPortalHW3.resources;


import thesisportal.hw.ThesisPortalHW3.core.Topic;
import thesisportal.hw.ThesisPortalHW3.db.TopicDAO;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.UnitOfWork;

import java.util.Set;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





@Path("/thesis-portal")
@Produces(MediaType.APPLICATION_JSON)
public class ThesisPortalResource {
	
	private final TopicDAO topicDAO;
	
	public ThesisPortalResource(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	
	
	// empty page
    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public String empty(){
    	return "Available endpoints:\n getById/{id} \n getByTitle/{title} \n getAll/ \n createTopic/{title}&&{description}";
    }
	
	//get content by ID
    @GET
    @Timed
    @Path("getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Topic getById(@PathParam("id") int id){
    	Topic existingTopic = topicDAO.getById(id);
		return existingTopic;
    }
    
    //get content by title
    @GET
    @Timed
    @Path("getByTitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Topic> getByTitle(@PathParam("title") String title){
    	Set<Topic> existingTopicList = topicDAO.getByTitle(title);
		return existingTopicList;
    }
    
    //get allcontent
    @GET
    @Timed
    @Path("getAll/")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Topic> getAll(){
    	Set<Topic> existingTopicList = topicDAO.getAll();
		return existingTopicList;
    }
    
    
		
	
    
	
    
    
    @GET
    @Timed
    @Path("createTopic/{title}&&{description}")
    @UnitOfWork
    @ExceptionMetered
    @Produces(MediaType.APPLICATION_JSON)
    public Topic createTopic(@PathParam("title") String title, @PathParam("description") String description){
    	Topic createdTopic = new Topic(title, description);
    	topicDAO.createTopic(createdTopic);
    	return createdTopic;
    	//return new Topic(title, description);
    }
   
	 
}
