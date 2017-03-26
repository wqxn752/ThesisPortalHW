package thesisportal.hw.ThesisPortalHW3.resources;

import thesisportal.hw.ThesisPortalHW3.core.Topic;
import thesisportal.hw.ThesisPortalHW3.db.TopicDAO;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.UnitOfWork;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/topics")
@Produces(MediaType.APPLICATION_JSON)
public class ThesisPortalResource {

	private final TopicDAO topicDAO;

	public ThesisPortalResource(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	// empty page
	@OPTIONS
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public String empty() {
		return "Available endpoints:\n getById/{id} \n getByTitle/{title} \n getAll/ \n \n createTopic/{title}&&{description} \n \n deleteById/{id} \n \n changeTopicById/{id}&&{title}&&{description}";
	}

	// get content by ID
	@GET
	@Timed
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id) {
		// return topicDAO.getById(id);
		if (topicDAO.getById(id) == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Topic with id "+id+" not found").build();
		} else {
			return Response.ok(topicDAO.getById(id)).build();
		}
	}

	/*
	 * // get content by title
	 * 
	 * @GET
	 * 
	 * @Timed
	 * 
	 * @Path("getByTitle/{title}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Set<Topic>
	 * getByTitle(@PathParam("title") String title) { Set<Topic>
	 * existingTopicList = topicDAO.getByTitle(title); return existingTopicList;
	 * }
	 */

	// get all content
	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Topic> getAll() {
		return topicDAO.getAll();
	}

	// create a new topic
	@POST
	@Timed
	@Path("/{title}&&{description}")
	@UnitOfWork
	@ExceptionMetered
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTopic(@PathParam("title") String title, @PathParam("description") String description) {
		Topic createdTopic = new Topic(title, description);
		topicDAO.createTopic(createdTopic);
		return Response.created(UriBuilder.fromResource(ThesisPortalResource.class).build(createdTopic.getID()))
				.entity(createdTopic).build();
	}

	// delete topic by id
	@DELETE
	@Timed
	@Path("/{id}")
	@UnitOfWork
	@ExceptionMetered
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteById(@PathParam("id") int id) {
		topicDAO.deleteById(id);
	}

	// change topic
	@PUT
	@Timed
	@Path("/{id}&&{title}&&{description}")
	@UnitOfWork
	@ExceptionMetered
	@Produces(MediaType.APPLICATION_JSON)
	public void changeTopic(@PathParam("id") int id, @PathParam("title") String title,
			@PathParam("description") String description) {
		topicDAO.updateById(id, title, description);
	}

}
