package com.bytecode.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.model.Conexion;
import com.bytecode.core.services.PostService;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {
	
	@Autowired
	@Qualifier("com.bytecode.core.components.PostComponent")
	PostComponent postComponent;
	
	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;
	
	@Autowired
	@Qualifier("serviceDecorado")
	public PostService postService;

	/*
	@Autowired
	@Qualifier("serviceDecorado")
	public PostService postService;
	
	
	 OTROS EJEMPLOS DE CÓMO INYECTAR
	
	
	@Autowired
	@Qualifier("serviceDecorado")
	public void setPostService(PostService postService) {
		this.postService = postService;
		this.postService.addClass(CursoSpringApplication.class);
	}
	-------------------------------------
	public CursoSpringApplication(@Qualifier("serviceDecorado") PostService postService) {
		this.postService = postService;
	}
	
	
	*/
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Log log = LogFactory.getLog(this.getClass());
		try {
			postService.validation(postComponent.getPosts()).forEach(post -> {
				log.info(post.getTitulo());
			});
		} catch (Exception e) {
			log.error(e);
		}
	}

}
