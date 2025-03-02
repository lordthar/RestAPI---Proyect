package co.edu.uniquindio.ingesis.dtos;

import co.edu.uniquindio.ingesis.domain.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Collection;

public record UserResponse(
        @NotBlank(message = "El id es requerido")
        String id,
        @NotBlank(message = "El nombre es requerido")
        String nombre,
        @NotBlank(message = "El apellido es requerido")
        String apellido,
        @NotBlank(message = "El email es requerido")
        @Email
        String email,
        @NotBlank(message = "El semestre es requerido")
        String semestre,
        @NotBlank(message = "La cedula es requerida")
        String cedula,
        String telefono,
        @NotBlank(message = "La password es requerida")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
        String password,
        @Size(min=4,max = 20,message = "El username debe tener mínimo 4 caracteres y máximo 20")
        @NotBlank(message = "El user es requerido")
        String user,
        LocalDate fechaNacimiento,
        Collection<Rol> roles
) {
}
