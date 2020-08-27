package com.gtime.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gtime.springboot.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{
	
	

}
