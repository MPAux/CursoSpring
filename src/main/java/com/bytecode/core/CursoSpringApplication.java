package com.bytecode.core;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.model.Conexion;
import com.bytecode.core.services.PostService;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {
	Log log = LogFactory.getLog(getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${cursospring.jdbc.import.ruta}")
	private String ruta;
	
	@Value("${cursospring.jdbc.import}")
	private boolean importar;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//jdbcTemplate.execute("insert into permiso (Nombre) values ('Ejemplo2')");
		if(importar) {
			Path path = Paths.get(ruta);
			BufferedReader bufferReader = Files.newBufferedReader(path);
			String line;
			while((line = bufferReader.readLine()) != null) {
				jdbcTemplate.execute(line);
				log.info("Se ejecutó: ");
				log.info(line);
			}
		} else {
			log.info("No se importó el DML de "+ruta);
		}
		
		log.info("Número de permisos: " + jdbcTemplate.queryForObject("SELECT count(*) FROM permiso", Integer.class));
	}

}
