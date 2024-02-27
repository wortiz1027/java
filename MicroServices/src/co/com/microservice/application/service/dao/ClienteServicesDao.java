package co.com.microservice.application.service.dao;

import java.math.BigInteger;
import java.util.List;

import co.com.microservice.application.model.Cliente;


public interface ClienteServicesDao {
	
	public void createCliente(Cliente client);
	
	public List<Cliente> getAllClientes();
	
	public List<Cliente> getAllClientes(Integer offset, Integer limit);
	
	public Cliente getInfoCliente(BigInteger cedula);
	
	public void deleteCliente(Cliente client);
	
	public boolean deleteCliente(BigInteger cedula);
	
	public void updateCliente(Cliente client);
	
	public boolean isClientExist(Cliente client);
	
	public boolean isClientExist(BigInteger cedula);
	
}
