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

	// create topic
	@SqlUpdate("insert into topics (title, description, created) values(:title, :description, :created)")
	public void createTopic(@BindBean Topic topic);

	// get topics
	@SqlQuery("select * from topics where id = :id")
	public Topic getById(@Bind("id") int id);

	@SqlQuery("select * from topics where title = :title")
	public Set<Topic> getByTitle(@Bind("title") String title);

	@SqlQuery("select * from topics")
	public Set<Topic> getAll();

	// delete topics
	@SqlUpdate("delete from topics where id = :id")
	public void deleteById(@Bind("id") int id);

	// change topic
	@SqlUpdate("update topics set title = :title, description = :description where id = :id")
	public void updateById(@Bind("id") int id, @Bind("title") String title, @Bind("description") String description);

}
