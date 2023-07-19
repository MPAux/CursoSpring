package com.bytecode.core.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bytecode.core.model.Conexion;
import com.bytecode.core.model.Usuario;

@Component
public class CreandoConexion {
	
	@Bean(name = "beanUsuario")
	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		
		return usuario;
	}
	
	@Bean(name = "beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setDb("mysql");
		conexion.setUrl("localhost");
		return conexion;
	}
	
}
