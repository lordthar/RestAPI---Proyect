package co.edu.uniquindio.ingesis.resources;

import co.edu.uniquindio.ingesis.dtos.UsuarioCreadoRequest;
import co.edu.uniquindio.ingesis.dtos.UsuarioResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.annotations.Param;

import java.util.*;
import java.util.function.BiConsumer;

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

    @GET
    public Response obtenerUsuarios(@Valid @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("limit") @DefaultValue("20") Integer limit) {

        var usuarios = new ArrayList<UsuarioResponse>();

        for (int i = (offset * limit); i < (limit + offset * limit); i++) {
            usuarios.add(
                    new UsuarioResponse(
                            "id: "+i,
                            "nombre "+i,
                            "apellido "+i,
                            "email "+i,
                            "semestre 2",
                            "cedula "+i,
                            "telefono "+i,
                            "password "+i,
                            "user "+i,
                            "edad "+i,
                            null
                            )
            );
        }

        return Response.status(Response.Status.CREATED).entity(usuarios).build();
    }

    @Path("/{id}")
    @PUT
    public Response actualizar(@Valid UsuarioCreadoRequest request, @PathParam("id") String id) {
        // aquí va la logica
        var response = new UsuarioResponse(id, request.nombre(), null,  request.email(), null, request.cedula(), null, request.password(), request.user(), null, request.roles());

        return Response.status(Response.Status.OK).entity(response).build();
    }

    private List<UsuarioResponse> usuarios = new ArrayList<>();
    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") String id) {
        Iterator<UsuarioResponse> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            UsuarioResponse usuario = iterator.next();
            if(usuario.id().equals(id)) {
                iterator.remove();
            }
        }
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}")
    @GET
    public Response obtenerUsuario(@PathParam("id") String id){
        UsuarioResponse usuario = new UsuarioResponse(
                id,
                "Juan",
                "Perez",
                "juan@gmail.com",
                "3!",
                "1234",
                "3222334354",
                "Aaa@6789aaA-",
                "juanito",
                "38",
                null);
        for (UsuarioResponse user: usuarios){
            if (user.id().equals(id)){
                usuario = user;
            }
        }
        return Response.status(Response.Status.OK).entity(usuario).build();
    }

    @PATCH
    @Path("/{id}")
    public Response update(@PathParam("id") String id, @Valid UsuarioCreadoRequest request) {
        var response = new UsuarioResponse(id, request.nombre(), null,  request.email(), null, request.cedula(), null, request.password(), request.user(), null, request.roles());


        return Response.status(Response.Status.OK).entity(response).build();
    }
}