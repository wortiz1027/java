package co.com.microservice.application.repository.dao;

import java.math.BigDecimal;
import java.util.List;

import co.com.microservice.application.model.Producto;
import co.com.microservice.application.repository.generics.GenericDAO;

public interface ProductoDao extends GenericDAO<Producto, BigDecimal>{
	
	public List<Producto> getProductos();
	
	public List<Producto> getByNombre(String nombreProducto);
	
	public Producto getByCodigo(String codigo);
	
	public boolean isProductExist(Producto producto);
	
	public boolean isProductExist(String codigo);
	
	public boolean deleteByCode(String codigo);
	
}