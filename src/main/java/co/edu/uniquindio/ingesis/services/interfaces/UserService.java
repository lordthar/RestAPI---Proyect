package co.edu.uniquindio.ingesis.services.interfaces;

import co.edu.uniquindio.ingesis.dtos.UsuarioCreadoRequest;
import co.edu.uniquindio.ingesis.dtos.UsuarioResponse;

public interface UserService {
    UsuarioResponse createUser(UsuarioCreadoRequest request);
}
