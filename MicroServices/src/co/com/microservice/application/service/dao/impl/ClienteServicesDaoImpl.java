package co.com.microservice.application.service.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.microservice.application.model.Cliente;
import co.com.microservice.application.repository.dao.ClienteDao;
import co.com.microservice.application.service.dao.ClienteServicesDao;

@Service("clienteServices")
public class ClienteServicesDaoImpl implements ClienteServicesDao {
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	public void createCliente(Cliente client) {
		try{
			if (client != null){
				clienteDao.save(client);
			}			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Cliente> getAllClientes() {
		try{
			return clienteDao.getAllRows();
		}catch(Exception e){
			   System.out.println("Error en el servicio Cliente --> " + e.toString());	
		}
		return null;
	}

	@Override
	public Cliente getInfoCliente(BigInteger cedula) {		
		if (cedula != null){
			System.out.println("2. CEDULA --> " + cedula);
			return clienteDao.getClienteByCedula(cedula);
		}
			
		return null;
	}

	@Override
	public boolean deleteCliente(BigInteger cedula) {
		if (cedula != null){
			clienteDao.deleteClienteByCedula(cedula);
			return true;
		}		
		
		return false;
	}

	@Override
	public void updateCliente(Cliente client) {
		if (client != null){
			clienteDao.update(client);
		}
	}

	@Override
	public boolean isClientExist(Cliente client) {		
		return clienteDao.isExist(client);
	}

	@Override
	public boolean isClientExist(BigInteger cedula) {
		return clienteDao.isExistByCedula(cedula);
	}

	@Override
	public void deleteCliente(Cliente client) {
		if (client != null){
			clienteDao.delete(client.getIdCliente());
		}	
	}

	@Override
	public List<Cliente> getAllClientes(Integer offset, Integer limit) {
		
		if (offset != null && limit != null){
			return clienteDao.getClientes(offset, limit);
		}
		
		return null;
	}
	
}