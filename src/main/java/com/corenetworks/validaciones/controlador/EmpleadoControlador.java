package com.corenetworks.validaciones.controlador;

import com.corenetworks.validaciones.dto.EmpleadoDTO;
import com.corenetworks.validaciones.dto.ResumenDTO;
import com.corenetworks.validaciones.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.corenetworks.validaciones.modelo.Empleado;
import com.corenetworks.validaciones.servicio.IEmpleadoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
    @Autowired
    private IEmpleadoServicio servicio;
    @PostMapping
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@Valid @RequestBody EmpleadoDTO e) throws Exception {
        Empleado e1=e.castEmpleado();
        e1= servicio.insertar(e1);
        return new ResponseEntity<>(e.castEmpleadoADto(e1), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<EmpleadoDTO> modificarEmpleado(@Valid @RequestBody EmpleadoDTO e) throws Exception {
        Empleado e1=servicio.consultarUno(e.getIdEmpleado());
        if(e1==null){
            throw new ExcepcionPersonalizadaNoEncontrado("No re seconoce el ID "+ e.getIdEmpleado());
        }
        e1= servicio.modificar(e.castEmpleado());
        return new ResponseEntity<>(e.castEmpleadoADto(e1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO>consultarUno(@PathVariable(name = "id") Integer id) throws Exception {
        Empleado e1 = servicio.consultarUno(id);
        if (e1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        return new ResponseEntity<>((new EmpleadoDTO()).castEmpleadoADto(e1), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ("id")int id)throws Exception {
        Empleado e1 = servicio.consultarUno(id);
        if (e1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrado("recurso no encontrado con ID " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> consultarTodos() throws Exception {
        List<Empleado>empleadosBBDD=servicio.consultarTodos();
        List<EmpleadoDTO>empleadosDto=new ArrayList<>();
        for (Empleado elemento:
             empleadosBBDD) {
            EmpleadoDTO eDto= new EmpleadoDTO();
            empleadosDto.add(eDto.castEmpleadoADto(elemento));
        }
        return new ResponseEntity<>(empleadosDto,HttpStatus.OK);
    }
    @GetMapping("/resumenes")
    public ResponseEntity<List<ResumenDTO>>obtenerResumen(){
        return new ResponseEntity<>(servicio.obtenerResumenes(),HttpStatus.OK);
    }

}
