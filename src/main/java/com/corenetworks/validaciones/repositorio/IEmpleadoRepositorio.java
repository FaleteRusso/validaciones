package com.corenetworks.validaciones.repositorio;


import com.corenetworks.validaciones.dto.ResumenDTO;
import com.corenetworks.validaciones.modelo.Empleado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpleadoRepositorio extends IGenericoRepositorio<Empleado,Integer> {
    @Query(value = "select count(id_empledo) as contador, avg(sueldo) as sueldo from empleados;",nativeQuery = true)
    public List<ResumenDTO>obtenerResumenes();

    }
