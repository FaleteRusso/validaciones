package com.corenetworks.validaciones.servicio.impl;



import com.corenetworks.validaciones.modelo.Empleado;
import com.corenetworks.validaciones.repositorio.IEmpleadoRepositorio;
import com.corenetworks.validaciones.repositorio.IGenericoRepositorio;
import com.corenetworks.validaciones.servicio.IEmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicioImpl extends CRUDImpl<Empleado,Integer>implements IEmpleadoServicio {
    @Autowired
    private IEmpleadoRepositorio repo;
    @Override
    protected IGenericoRepositorio<Empleado, Integer> getRepo() {

        return repo;
    }
}
