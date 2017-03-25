package thesisportal.hw.ThesisPortalHW3.mappers;

import thesisportal.hw.ThesisPortalHW3.core.Topic;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicsMapper implements ResultSetMapper<Topic> {

	@Override
	public Topic map(int arg0, ResultSet arg1, StatementContext arg2) throws SQLException {
		Topic topic = new Topic();
		topic.setID(arg1.getLong("ID"));
		topic.setTitle(arg1.getString("title"));
		topic.setDescription(arg1.getString("description"));
		topic.setCreated(arg1.getDate("created"));
		return topic;
	}

}
