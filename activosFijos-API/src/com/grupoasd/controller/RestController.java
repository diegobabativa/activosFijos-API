package com.grupoasd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupoasd.pojo.ActivoFijo;
import com.grupoasd.service.ActivoFijoService;

@Controller
public class RestController {
	
	
	@Autowired
	private ActivoFijoService activoFijoService;

	@RequestMapping("/")
	public String showIndex() {
		List<ActivoFijo> activosFijos = activoFijoService.findAll();
		System.out.println("Cantidad de  activos fijos:" + activosFijos.size());
		System.out.println("La consultada es:" + activosFijos.get(0));
		return "index";
	}
	
	@RequestMapping("/activosFijos")
	public String listarActivosFijos() {
		
	
		List<ActivoFijo> activosFijos = activoFijoService.findAll();
		System.out.println("Cantidad de  activos fijos:" + activosFijos.size());
		System.out.println("La consultada es:" + activosFijos.get(0));
		
		
		return "index";
	}
	
}
