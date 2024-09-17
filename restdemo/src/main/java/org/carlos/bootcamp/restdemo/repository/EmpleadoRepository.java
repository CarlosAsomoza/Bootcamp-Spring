package org.carlos.bootcamp.restdemo.repository;

import org.carlos.bootcamp.restdemo.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
