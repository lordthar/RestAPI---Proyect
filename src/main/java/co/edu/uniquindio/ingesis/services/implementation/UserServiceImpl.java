package co.edu.uniquindio.ingesis.services.implementation;

import co.edu.uniquindio.ingesis.domain.User;
import co.edu.uniquindio.ingesis.dtos.PaginacionRequest;
import co.edu.uniquindio.ingesis.dtos.UsuarioCreadoRequest;
import co.edu.uniquindio.ingesis.dtos.UsuarioResponse;
import co.edu.uniquindio.ingesis.mappers.UserMapper;
import co.edu.uniquindio.ingesis.services.interfaces.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    @Transactional
    public UsuarioResponse createUser(UsuarioCreadoRequest request) {
        return null;
    }

    @Override
    public UsuarioResponse obtenerUser(Long id) {
        return null;
    }

    @Override
    public String eliminarUser(Long id) {
        return null;
    }

    @Override
    public UsuarioResponse actualizarUser(UsuarioCreadoRequest request) {
        return null;
    }

    @Override
    public ArrayList<User> obtenerUsers(PaginacionRequest request) {
        return null;
    }

}
