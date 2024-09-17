package org.carlos.bootcamp.restdemo.init;

import org.carlos.bootcamp.restdemo.model.Empleado;
import org.carlos.bootcamp.restdemo.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDataBase(EmpleadoRepository repository){
            return args -> {
                Empleado juan = new Empleado("Juan Carlos", "CTO");
                Empleado sof = new Empleado("Sofia Hidalgo", "Project Manager");
                Empleado ari = new Empleado("Ariana Asomoza", "CEO");

                log.info("Carga inicial: {}", repository.save(juan));
                log.info("Carga inicial: {}", repository.save(sof));
                log.info("Carga inicial: {}", repository.save(ari));
            };
    }
}
