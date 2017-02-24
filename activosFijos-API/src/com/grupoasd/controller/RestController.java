package com.grupoasd.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grupoasd.dao.JsonTransformer;
import com.grupoasd.pojo.ActivoFijo;
import com.grupoasd.service.ActivoFijoService;

/**
 * Controlador encargado de atender las peticiones del servicio REST Estas son
 * redireccionadas de acuerdo a la acción sobre la API
 * 
 * @author Diego Babativa
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
	public ResponseEntity<Object> findAll(
			HttpServletResponse httpServletResponse) {
		try {
			List<ActivoFijo> activosFijos = activoFijoService.findAll();
			if (activosFijos != null && !activosFijos.isEmpty()) {
				String jsonSalida = jsonTransformer.toJson(activosFijos);
				return new ResponseEntity<Object>(jsonSalida, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(
						"No se encontraron resultados", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("Se ha producido un error: "
					+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Método del controlador encargado de atender las peticiones de consulta de
	 * todos los activos Fijos filtrados por tipo, atiende peticiones vía GET y
	 * retorna data de tipo JSON
	 * 
	 * @param httpServletResponse
	 */
	@RequestMapping(value = "/activosFijos/tipo/{idTipo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findByType(
			HttpServletResponse httpServletResponse,
			@PathVariable("idTipo") int idTipo) {
		try {
			List<ActivoFijo> activosFijos = activoFijoService
					.findByType(idTipo);

			if (!activosFijos.isEmpty()) {
				String jsonSalida = jsonTransformer.toJson(activosFijos);
				return new ResponseEntity<Object>(jsonSalida, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(
						"LA búsqueda no trajo resultados", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("Se ha producido un errr: "
					+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Método del controlador encargado de atender las peticiones de consulta de
	 * todos los activos Fijos filtrados por Fecha de Compra, atiende peticiones
	 * vía GET y retorna data de tipo JSON
	 * 
	 * @param httpServletResponse
	 */
	@RequestMapping(value = "/activosFijos/fechaCompra/{fechaCompra}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findByBuyDate(
			HttpServletResponse httpServletResponse,
			@PathVariable("fechaCompra") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCompra) {
		try {
			List<ActivoFijo> activosFijos = activoFijoService
					.findByBuyDate(fechaCompra);

			if (activosFijos != null && !activosFijos.isEmpty()) {

				String jsonSalida = jsonTransformer.toJson(activosFijos);
				return new ResponseEntity<Object>(jsonSalida, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>(
						"LA búsqueda no trajo resultados", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Método del controlador encargado de atender las peticiones de consulta de
	 * todos los activos Fijos filtrados por serial, atiende peticiones vía GET
	 * y retorna data de tipo JSON
	 * 
	 * @param httpServletResponse
	 */
	@RequestMapping(value = "/activosFijos/serial/{serial}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> findBySerial(
			HttpServletResponse httpServletResponse,
			@PathVariable("serial") String serial) {
		try {
			List<ActivoFijo> activosFijos = activoFijoService
					.findBySerial(serial);

			if (activosFijos != null && !activosFijos.isEmpty()) {

				String jsonSalida = jsonTransformer.toJson(activosFijos);
				return new ResponseEntity<Object>(jsonSalida, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Búsqueda sin resultados",
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("Se produjo un error: "
					+ e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param jsonEntrada
	 */
	@RequestMapping(value = "/activoFijo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> save(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@RequestBody String jsonEntrada) {
		try {
			ActivoFijo activofijo = (ActivoFijo) jsonTransformer.fromJson(
					jsonEntrada, ActivoFijo.class);
			activoFijoService.save(activofijo);
			String jsonSalida = jsonTransformer.toJson(activofijo);
			return new ResponseEntity<Object>(jsonSalida, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<Object>("Se ha producido un Error: "
					+ ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
