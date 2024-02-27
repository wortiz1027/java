package co.com.microservice.application.repository.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import co.com.microservice.application.model.Cliente;
import co.com.microservice.application.repository.generics.GenericDAO;

public interface ClienteDao extends GenericDAO<Cliente, BigDecimal> {
	
	public Cliente getClienteByCedula(BigInteger cedula);
	
	public boolean isExist(Cliente cliente);
	
	public boolean isExistByCedula(BigInteger cedula);
	
	public boolean deleteClienteByCedula(BigInteger cedula);
	
	public List<Cliente> getClientes(Integer offset, Integer limit);
	
}