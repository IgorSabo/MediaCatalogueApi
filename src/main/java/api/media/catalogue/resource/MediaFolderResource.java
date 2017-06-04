package api.media.catalogue.resource;

import api.media.catalogue.model.MediaFolder;
import api.media.catalogue.service.MediaFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Gile on 6/4/2017.
 */
@Component
@Path("/mediaFolders")
public class MediaFolderResource {

    @Autowired
    MediaFolderService mediaFolderService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public Response getAllMediaFolders(){
        List<MediaFolder> list = mediaFolderService.getAllMediaFolders();
        return Response.ok(list).build();
    }


}
