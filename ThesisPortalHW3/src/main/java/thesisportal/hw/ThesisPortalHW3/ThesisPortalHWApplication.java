package thesisportal.hw.ThesisPortalHW3;



import org.hibernate.cfg.Configuration;
import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import thesisportal.hw.ThesisPortalHW3.core.Topic;
import thesisportal.hw.ThesisPortalHW3.db.TopicDAO;

import thesisportal.hw.ThesisPortalHW3.resources.ThesisPortalResource;

import io.dropwizard.jdbi.*;




public class ThesisPortalHWApplication extends Application<ThesisPortalHWConfiguration> {

    public static void main(final String[] args) throws Exception {
    	Configuration conf = new Configuration().configure();
    	
    	new ThesisPortalHWApplication().run(args);
    }
    
    private final HibernateBundle<ThesisPortalHWConfiguration> hibernate = new HibernateBundle<ThesisPortalHWConfiguration>(Topic.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(ThesisPortalHWConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };
    
    @Override
    public String getName() {
        return "ThesisPortalHW";
    }

    @Override
    public void initialize(final Bootstrap<ThesisPortalHWConfiguration> bootstrap) {
    	bootstrap.addBundle(hibernate);
    }


   
    @Override
    public void run(final ThesisPortalHWConfiguration configuration, final Environment environment){
	    
    	
    	final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        
       
        final TopicDAO dao = jdbi.onDemand(TopicDAO.class);
       
        ThesisPortalResource resource = new ThesisPortalResource(dao);
        
    	environment.jersey().register(resource);
    	
    	    
    	 
    	    
    	    
    }
    

}
