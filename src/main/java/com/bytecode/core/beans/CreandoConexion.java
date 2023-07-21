package com.bytecode.core.beans;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
	
	@Bean
	public DataSource getDataSource() {
		/*
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/blog");
		dataSource.setUsername("bytecode");
		dataSource.setPassword("root1234");
		return dataSource;
		*/
	
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost/blog");
        dataSourceBuilder.username("bytecode");
        dataSourceBuilder.password("root1234");
        return dataSourceBuilder.build();
        
	}
	
	
}
