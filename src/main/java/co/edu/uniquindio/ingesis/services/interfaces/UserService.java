package co.edu.uniquindio.ingesis.services.interfaces;

import co.edu.uniquindio.ingesis.domain.User;
import co.edu.uniquindio.ingesis.dtos.PaginacionRequest;
import co.edu.uniquindio.ingesis.dtos.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.dtos.UserResponse;

import java.util.ArrayList;

public interface UserService {
    UserResponse createUser(UserRegistrationRequest request);
    UserResponse obtenerUser(Long id);
    String eliminarUser(Long id);
    UserResponse actualizarUser(UserRegistrationRequest request);
    ArrayList<User> obtenerUsers(PaginacionRequest request);

}
