package com.corenetworks.validaciones.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpledo;
    @Column(length = 60,nullable = false)
    private String nombreEmpleado;
    @Column(length = 9,nullable = false,unique = true)
    private String dni;
    @Column(nullable = false)
    private double sueldo;
}
