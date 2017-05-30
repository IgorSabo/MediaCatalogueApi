package api.media.catalogue.conf;

import api.media.catalogue.model.Title;
import api.media.catalogue.resource.TitleResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gile on 5/28/2017.
 */
//@Configuration
//@ComponentScan("api.media.catalogue.resource")
@ApplicationPath("/resources")
public class RestConfig extends ResourceConfig {

    public RestConfig(){
        packages("api.media.catalogue");
    }
    /*public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(
                Arrays.asList(
                        TitleResource.class));
    }*/
}
