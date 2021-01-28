
package com.mycompany.services;

import com.mycompany.entidades.Personal;
import com.mycompany.session.PersonalFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("Personal")
public class PersonalRest {
    
    @EJB
    private PersonalFacade personalFacade;
    
    @GET
    
    @Produces({MediaType.APPLICATION_JSON})
    public List<Personal> findAll(){
        
        return personalFacade.findAll();
        
    }
    
    @GET
    
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Personal findBtId(@PathParam("id") Integer id){
        
        return personalFacade.find(id);
    }
    
    @DELETE 
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id){
        personalFacade.remove( personalFacade.find(id));
        return Response.ok("DATO ELIMINADO", MediaType.APPLICATION_JSON).build();
    }
    
    @POST 
    @Consumes({MediaType.APPLICATION_JSON})
    
    public Response create ( Personal personal){
        personalFacade.create(personal);
        return Response.ok("DATO INGRESADO", MediaType.APPLICATION_JSON).build();
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Personal personal){
        personalFacade.edit(personal);
        return Response.ok("DATO EDITADO", MediaType.APPLICATION_JSON).build();
    }
    
}
