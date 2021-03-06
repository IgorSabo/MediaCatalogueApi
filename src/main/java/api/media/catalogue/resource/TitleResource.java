package api.media.catalogue.resource;

import api.media.catalogue.model.Title;
import api.media.catalogue.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gile on 5/28/2017.
 */
//http://localhost:8080/resources/titles/listResults?type=movie&page=1&perPage=1&genre=comedy&year=2010
@Component
@Path("/titles")
public class TitleResource {

    @Autowired
    TitleService titleService;

    @GET
    @Path("/hello")
    public String hello() {
        return "hello";
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addTitle(Title title){

        //titleService.createTitle(title);

        return Response.status(Response.Status.CREATED.getStatusCode()).build();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Title getTitle(@PathParam("id") int id){

        return titleService.getTitle(id);
    }

    @GET
    @Path("/listResults")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Title> getTitles(@QueryParam("type") String type,
                                 @QueryParam("page") int page,
                                 @QueryParam("perPage") String perPage,
                                 @QueryParam("genre") String genre,
                                 @QueryParam("year") String year){

        ArrayList<Title> list = (ArrayList<Title>) titleService.getResults(type, Integer.valueOf(page), Integer.valueOf(perPage), genre, year);
        return list;
    }

    @GET
    @Path("/findByTitle")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Title> findByTitle(@QueryParam("title") String title){
        return titleService.findByImdbTitle(title);
    }




}
