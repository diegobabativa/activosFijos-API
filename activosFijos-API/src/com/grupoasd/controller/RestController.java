package com.grupoasd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.grupoasd.dao.JsonTransformer;
import com.grupoasd.pojo.ActivoFijo;
import com.grupoasd.service.ActivoFijoService;

/**
 * Controlador encargado de atender las peticiones del servicio REST Estas son
 * redireccionadas de acuerdo a la acción sobre la API
 * 
 * @author Diego
 * @since 22-02-2017
 */
@Controller
public class RestController {

	/**
	 * Atributos de la clase donde se inyectan las dependencias
	 */
	@Autowired
	private ActivoFijoService activoFijoService;

	@Autowired
	private JsonTransformer jsonTransformer;

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	/**
	 * Método del controlador encargado de atender las peticiones de consulta de
	 * todos los activos Fijos, atiende peticiones vía GET y retorna data de
	 * tipo JSON
	 * 
	 * @param httpServletResponse
	 */
	@RequestMapping(value = "/activosFijos", method = RequestMethod.GET, produces = "application/json")
	public void findAll(HttpServletResponse httpServletResponse) {
		try {
			List<ActivoFijo> activosFijos = activoFijoService.findAll();
			if( activosFijos != null && !activosFijos.isEmpty()){
				String jsonSalida = jsonTransformer.toJson(activosFijos);
				httpServletResponse.getWriter().print(jsonSalida);
				httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			}else{
				httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
			}
		} catch (Exception e) {
			httpServletResponse
					.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		httpServletResponse
		.setContentType("application/json; charset=UTF-8");
	}
	

}
