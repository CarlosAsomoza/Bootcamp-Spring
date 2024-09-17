package org.carlos.bootcamp.restdemo.controller;

import org.carlos.bootcamp.restdemo.model.Empleado;
import org.carlos.bootcamp.restdemo.repository.EmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {
    private final EmpleadoRepository repository;

    public EmpleadoController(EmpleadoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable Long id){
        Optional<Empleado> empleado = repository.findById(id);
        if(empleado.isPresent()){
            return ResponseEntity.ok(empleado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        // Previa implementación con public Empleado getEmpleado(..)
        // return repository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @PostMapping("/empleados")
    public Empleado createEmpleado(@RequestBody Empleado empleado){
        return repository.save(empleado);
    }

    @PutMapping("/empleados/{id}")
    public Empleado updateEmpleado(@RequestBody Empleado empleadoActualizado,
                                   @PathVariable Long id){
        return repository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(empleadoActualizado.getNombre());
                    empleado.setPuesto(empleadoActualizado.getPuesto());
                    return repository.save(empleado);
                }).orElseGet(() ->{
                    return repository.save(empleadoActualizado);
                });
    }

    @DeleteMapping("/empleados/{id}")
    public void deleteEmpleado(@PathVariable Long id){
        repository.deleteById(id);
    }


}
