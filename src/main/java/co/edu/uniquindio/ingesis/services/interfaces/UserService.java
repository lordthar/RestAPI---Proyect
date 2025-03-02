package co.edu.uniquindio.ingesis.services.interfaces;

import co.edu.uniquindio.ingesis.domain.User;
import co.edu.uniquindio.ingesis.dtos.PaginacionRequest;
import co.edu.uniquindio.ingesis.dtos.UsuarioCreadoRequest;
import co.edu.uniquindio.ingesis.dtos.UsuarioResponse;

import java.util.ArrayList;

public interface UserService {
    UsuarioResponse createUser(UsuarioCreadoRequest request);
    UsuarioResponse obtenerUser(Long id);
    String eliminarUser(Long id);
    UsuarioResponse actualizarUser(UsuarioCreadoRequest request);
    ArrayList<User> obtenerUsers(PaginacionRequest request);

}
