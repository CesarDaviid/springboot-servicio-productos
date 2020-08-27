package com.gtime.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gtime.springboot.app.productos.models.entity.Producto;
import com.gtime.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	Logger logger = LoggerFactory.getLogger(ProductoController.class);
	

	private Integer port=7001;
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		    
		    logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");
		
		
		
		return productoService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
		return producto;
		}).collect(Collectors.toList());		
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable long id){
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);				
		return productoService.findById(id);
	}

}
