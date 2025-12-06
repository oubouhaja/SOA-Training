package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mb")
public class ModuleWs {
    ModuleBusiness helper=new ModuleBusiness();
    @Path("/listmodule")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response
                .status(200)
                .entity(helper.getAllModules())
                .build();
    }
    @Path("/addmodule")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addMB(Module m){
        if (helper.addModule(m)){
            return Response.status(201).entity("Module created").build();
        }
        else return Response.status(400).entity("Module not created").build();
    }
    @Path("/deletemodule/{matricule}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUE(@PathParam("matricule") String code){
        if (helper.deleteModule(code)){
            return Response.status(200).entity("Object deleted").build();
        }
        else return Response.status(400).entity("Object not deleted").build();
    }
}
