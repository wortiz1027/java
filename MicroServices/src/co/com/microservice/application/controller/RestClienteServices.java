package co.com.microservice.application.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.com.microservice.application.anotaciones.InfoLogger;
import co.com.microservice.application.model.Cliente;
import co.com.microservice.application.service.dao.ClienteServicesDao;

@RestController
@RequestMapping(value = "/api/v1.0")
public class RestClienteServices {
	
	@Autowired
	private ClienteServicesDao clienteServicesDao;
	
	//------------------- Get All Clientes --------------------------------------------------------
	@InfoLogger(origen = "obtenerClientes")
	@RequestMapping(value    = "/clientes",
			        method   = RequestMethod.GET,
			        headers  = "Accept=application/json",
			        consumes = MediaType.APPLICATION_JSON_VALUE, 
			        produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<List<Cliente>> obtenerClientes() {
		
		List<Cliente> clientes = clienteServicesDao.getAllClientes();
		
		if (clientes.isEmpty()){
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);		
	}
	
	//------------------- Get All Clientes Paginacion --------------------------------------------------------
	
	@RequestMapping(value    = "/clientes/paginacion",
			        method   = RequestMethod.GET,
			        headers  = "Accept=application/json",
			        consumes = MediaType.APPLICATION_JSON_VALUE, 
			        produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<List<Cliente>> obtenerClientesPaginacion(@RequestParam(value = "offset", required = true) Integer offset, 
														           @RequestParam(value = "limit", required = true)  Integer limit) {
		
		if (offset == null || limit == null){
			return new ResponseEntity<List<Cliente>>(HttpStatus.BAD_REQUEST);
		}
		
		List<Cliente> clientes = clienteServicesDao.getAllClientes(offset, limit);
		
		if (clientes.isEmpty()){
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);		
	}
	
	
	//------------------- Get Cliente by cedula --------------------------------------------------------
	@InfoLogger(origen = "obtenerInfoCliente")
	@RequestMapping(value    = "/clientes/{cedula}",
			        method   = RequestMethod.GET,
			        headers  = "Accept=application/json",
			        consumes = MediaType.APPLICATION_JSON_VALUE, 
			        produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Cliente> obtenerInfoCliente(@PathVariable("cedula") BigInteger cedula) {
		
		Cliente cliente = clienteServicesDao.getInfoCliente(cedula);
		
		if (cliente == null){
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	//------------------- Create Cliente --------------------------------------------------------
	
	@RequestMapping(value    = "/clientes",
			        method   = RequestMethod.POST,
			        headers  = "Accept=application/json",
			        consumes = MediaType.APPLICATION_JSON_VALUE, 
			        produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Void> crearCliente(@RequestBody(required = true) Cliente cliente, UriComponentsBuilder ucBuilder) {
		
		if (clienteServicesDao.isClientExist(cliente)){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		clienteServicesDao.createCliente(cliente);
		
		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/clientes/{id}").buildAndExpand(cliente.getIdCliente()).toUri());
		
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	//------------------- Delete Cliente --------------------------------------------------------
	
	@RequestMapping(value    = "/clientes/{cedula}",
			        method   = RequestMethod.DELETE,
			        headers  = "Accept=application/json",
			        consumes = MediaType.APPLICATION_JSON_VALUE, 
			        produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Cliente> eliminarCliente(@PathVariable("cedula") BigInteger cedula) {
		
		if (!clienteServicesDao.isClientExist(cedula)){
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
		boolean exito = clienteServicesDao.deleteCliente(cedula);
		
		if (!exito){
			return new ResponseEntity<Cliente>(HttpStatus.NOT_MODIFIED);
		}
		
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@RequestMapping(value    = "/clientes/{cedula}",
			        method   = RequestMethod.PUT,
			        headers  = "Accept=application/json",
			        consumes = MediaType.APPLICATION_JSON_VALUE, 
			        produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("cedula") BigInteger cedula,@RequestBody(required = true) Cliente client) {
		
		if (!clienteServicesDao.isClientExist(cedula)){
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
		clienteServicesDao.updateCliente(client);
		
		return new ResponseEntity<Cliente>(client, HttpStatus.OK);
	}
	
}
