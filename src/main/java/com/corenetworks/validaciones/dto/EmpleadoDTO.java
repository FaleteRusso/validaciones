package com.corenetworks.validaciones.dto;

import com.corenetworks.validaciones.modelo.Empleado;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {
    private int idEmpleado;
    @NotEmpty
    @Size(min=3,max=60)//solo para Strings
    private String nombreEmpleado;
    @NotNull
    private String dni;
    @Min(400)
    @Max(32000)
    private double sueldo;

    public Empleado castEmpleado(){
        Empleado e1 = new Empleado();
        e1.setIdEmpledo(idEmpleado);
        e1.setNombreEmpleado(nombreEmpleado);
        e1.setDni(dni);
        e1.setSueldo(sueldo);
        return e1;
    }
    public EmpleadoDTO castEmpleadoADto(Empleado e){
        idEmpleado=e.getIdEmpledo();
        nombreEmpleado=e.getNombreEmpleado();
        dni=e.getDni();
        sueldo=e.getSueldo();
        return this;
    }
}
