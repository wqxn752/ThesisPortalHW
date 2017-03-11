package thesisportal.hw.ThesisPortalHW3.db;



import java.util.Set;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import thesisportal.hw.ThesisPortalHW3.core.Topic;
import thesisportal.hw.ThesisPortalHW3.mappers.TopicsMapper;

@RegisterMapper(TopicsMapper.class)
public interface TopicDAO {
	
	@SqlUpdate("insert into topics (title, description, created) values(:title, :description, :created)") 
	public void createTopic(@BindBean Topic topic);
	
	
	@SqlQuery("select * from topics where id = :id")
    public Topic getById(@Bind("id") int id);
	
	@SqlQuery("select * from topics where title = :title")
    public Set<Topic> getByTitle(@Bind("title") String title);
	
	
	
	@SqlQuery("select * from topics")
    public Set<Topic> getAll();

    

    @SqlUpdate("update topics set title = :title, description = :description, where id = :id")
    public void update(@BindBean Topic topic);

    @SqlUpdate("delete from topics where id = :id")
    public void delete(@BindBean Topic topic);
}
