package co.edu.uniquindio.ingesis.resources;

import co.edu.uniquindio.ingesis.dtos.UsuarioCreadoRequest;
import co.edu.uniquindio.ingesis.dtos.UsuarioResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResources {

    @POST
    public Response create(@Valid UsuarioCreadoRequest request) {

        var response = new UsuarioResponse(UUID.randomUUID().toString(), request.nombre(), null,  request.email(), null, request.cedula(), null, request.password(), request.user(), null, request.roles());
        //TODO cambiar por Response.create
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}