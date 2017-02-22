package com.grupoasd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupoasd.pojo.Ciudad;
import com.grupoasd.pojo.EstadoActivoFijo;
import com.grupoasd.pojo.TipoActivoFijo;
import com.grupoasd.service.CiudadService;
import com.grupoasd.service.EstadoActivoFijoService;
import com.grupoasd.service.TipoActivoFijoService;

@Controller
public class RestController {
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private TipoActivoFijoService tipoActivoFijoServe;
	
	@Autowired
	private EstadoActivoFijoService estadoActivoFijoService;

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout() {
		List<Ciudad> ciudades= ciudadService.findAll();
		List<TipoActivoFijo> tiposActivosFijos = tipoActivoFijoServe.findAll();
		List<EstadoActivoFijo> estadosActivosFijos = estadoActivoFijoService.findAll();
		
		System.out.println("Cantidad de ciudades:" + ciudades.size());
		System.out.println("La ciudad consultada es:" + ciudades.get(0));
		
		System.out.println("Cantidad de Tipos activos fijos:" + tiposActivosFijos.size());
		System.out.println("La consultada es:" + tiposActivosFijos.get(0));
		
		System.out.println("Cantidad de estados activos fijos:" + estadosActivosFijos.size());
		System.out.println("La consultada es:" + estadosActivosFijos.get(0));
		
		return "about";
	}
}
