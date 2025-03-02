package co.edu.uniquindio.ingesis.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends PanacheEntity {

    private String nombre;
    private String apellido;
    private String email;
    private int semestre;
    private String cedula;
    private String telefono;
    private String password;
    private String User;
    private LocalDate fechaNacimiento;
}
