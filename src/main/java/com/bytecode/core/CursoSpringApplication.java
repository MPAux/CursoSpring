package com.bytecode.core;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//jdbcTemplate.execute("insert into permiso (Nombre) values ('Ejemplo2')");
		/*
		String sql = "SELECT Nombre FROM permiso WHERE IdPermiso=?";

	    String nombre = (String) jdbcTemplate.queryForObject(
	            sql, new Object[] { 1 }, String.class);
	    log.info("Resultado: "+nombre);
		*/
		Path path = Paths.get("src/main/resources/import.sql");
		BufferedReader bufferReader = Files.newBufferedReader(path);
		String line;
		while((line = bufferReader.readLine()) != null) {
			log.info(line);
		}
		//log.info(path);
	}

}
