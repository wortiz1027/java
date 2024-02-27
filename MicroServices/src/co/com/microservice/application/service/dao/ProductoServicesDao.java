package co.com.microservice.application.service.dao;

import java.util.List;

import co.com.microservice.application.model.Producto;

public interface ProductoServicesDao {
	
	public void createProduct(Producto producto);
	
	public List<Producto> getAllProducts();
	
	public Producto getInfoProduct(String codigo);
	
	public void deleteProduct(Producto producto);
	
	public void updateProduct(Producto producto);
	
	public List<Producto> getProductsByName(String nombre);
	
	public boolean isProductExist(Producto producto);
	
	public boolean isProductExist(String codigo);
	
	public boolean deleteProductByCode(String codigo);
	
}
