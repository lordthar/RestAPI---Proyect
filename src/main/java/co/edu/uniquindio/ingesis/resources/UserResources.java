package co.edu.uniquindio.ingesis.resources;

import co.edu.uniquindio.ingesis.dtos.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.dtos.UserResponse;
import co.edu.uniquindio.ingesis.services.interfaces.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class UserResources {

    final UserService userService;

    @POST
    public Response create(@Valid UserRegistrationRequest request) {

        var response = new UserResponse(UUID.randomUUID().toString(), request.nombre(), null,  request.email(), null, request.cedula(), null, request.password(), request.user(), null, request.roles());
        //TODO cambiar por Response.create
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    public Response obtenerUsuarios(@Valid @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("limit") @DefaultValue("20") Integer limit) {

        var usuarios = new ArrayList<UserResponse>();

        for (int i = (offset * limit); i < (limit + offset * limit); i++) {
            usuarios.add(
                    new UserResponse(
                            "id: "+i,
                            "nombre "+i,
                            "apellido "+i,
                            "email "+i,
                            "semestre 2",
                            "cedula "+i,
                            "telefono "+i,
                            "password "+i,
                            "user "+i,
                            LocalDate.now(),
                            null
                            )
            );
        }

        return Response.status(Response.Status.CREATED).entity(usuarios).build();
    }

    @Path("/{id}")
    @PUT
    public Response actualizar(@Valid UserRegistrationRequest request, @PathParam("id") String id) {
        // aquí va la logica
        var response = new UserResponse(id, request.nombre(), null,  request.email(), null, request.cedula(), null, request.password(), request.user(), null, request.roles());

        return Response.status(Response.Status.OK).entity(response).build();
    }

    private List<UserResponse> usuarios = new ArrayList<>();
    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") String id) {
        Iterator<UserResponse> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            UserResponse usuario = iterator.next();
            if(usuario.id().equals(id)) {
                iterator.remove();
            }
        }
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}")
    @GET
    public Response obtenerUsuario(@PathParam("id") String id){
        UserResponse usuario = new UserResponse(
                id,
                "Juan",
                "Perez",
                "juan@gmail.com",
                "3!",
                "1234",
                "3222334354",
                "Aaa@6789aaA-",
                "juanito",
                LocalDate.now(),
                null);
        for (UserResponse user: usuarios){
            if (user.id().equals(id)){
                usuario = user;
            }
        }
        return Response.status(Response.Status.OK).entity(usuario).build();
    }

    @PATCH
    @Path("/{id}")
    public Response update(@PathParam("id") String id, @Valid UserRegistrationRequest request) {
        var response = new UserResponse(id, request.nombre(), null,  request.email(), null, request.cedula(), null, request.password(), request.user(), null, request.roles());


        return Response.status(Response.Status.OK).entity(response).build();
    }
}