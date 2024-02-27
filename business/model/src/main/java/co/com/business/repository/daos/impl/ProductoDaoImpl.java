package co.com.business.repository.daos.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.business.repository.entities.Producto;
import co.com.business.repository.daos.ProductoDao;
import co.com.business.repository.generics.GenericDaoImpl;

@Repository("productoDao")
@Transactional
public class ProductoDaoImpl extends GenericDaoImpl<Producto, BigDecimal> implements ProductoDao {
	
	public ProductoDaoImpl(){
		super(Producto.class);
	}
	
	@Override
	public List<Producto> getProductos() {
	    Query<?> query = getSessionFactory().getCurrentSession().getNamedQuery("Producto.findAll");
	    
	    List<Producto> productos = new ArrayList<Producto>();
	    
	    for (Object producto : query.getResultList()){
	    	if (producto instanceof Producto){
	    		productos.add((Producto)producto);
	    	}
	    }
	    
		return productos;
	}
	
	@Override
	public List<Producto> getByNombre(String nombreProducto) {
		
		StringBuilder sbQuery = new StringBuilder();
		StringBuilder sbParam = new StringBuilder();
		
		sbQuery.append("SELECT p \n");
		sbQuery.append("FROM Producto p \n");
		sbQuery.append("WHERE p.nombre LIKE :nomProducto \n");
		sbQuery.append("ORDER BY p.nombre");
		
		sbParam.append("%");
		sbParam.append(nombreProducto.toUpperCase());
		sbParam.append("%");
		
		Query<?> query = getSessionFactory()
				         .getCurrentSession()
				         .createQuery(sbQuery.toString());
		
		query.setParameter("nomProducto", sbParam.toString());
		
		List<Producto> productos = new ArrayList<Producto>();
	    
	    for (Object producto : query.getResultList()){
	    	if (producto instanceof Producto){
	    		productos.add((Producto)producto);
	    	}
	    }
		
		return productos;
	}


	@Override
	public Producto getByCodigo(String codigo) {
		StringBuilder sbQuery = new StringBuilder();
		
		sbQuery.append("SELECT p \n");
		sbQuery.append("FROM Producto p \n");
		sbQuery.append("WHERE p.codigo = :codigo");
		
		Query<?> query = getSessionFactory()
					     .getCurrentSession()
					     .createQuery(sbQuery.toString());
	    query.setParameter("codigo", codigo);
	    
	    Producto producto = null;
	    
	    if (query.getResultList().size() > 0){
	        producto = (Producto) query.getResultList().get(0);
	    }
	    
		return producto;
	}

	@Override
	public boolean isProductExist(Producto producto) {
		
		try {
			if (producto != null){
				Query<?> query = getSessionFactory().getCurrentSession().getNamedQuery("Producto.findByCodigo");
				query.setParameter("codigo", producto.getCodigo());
				
				int numProdcuts = query.getResultList().size();
				
				if (numProdcuts != 0)				
					return true;
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean isProductExist(String codigo) {
		try {
			if (codigo != null){
				Query<?> query = getSessionFactory().getCurrentSession().getNamedQuery("Producto.findByCodigo");
				query.setParameter("codigo", codigo);
				
				int numProdcuts = query.getResultList().size();
				
				if (numProdcuts != 0)				
					return true;
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByCode(String codigo) {
		try {
			if (codigo != null){
				Query<?> query = getSessionFactory().getCurrentSession().getNamedQuery("Producto.findByCodigo");
				query.setParameter("codigo", codigo);
				
				if (query.getResultList().size() > 0){
					Producto producto = (Producto) query.getResultList().get(0);
					
					getSessionFactory().getCurrentSession().delete(producto);
					return true;
				}				
				
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return false;
		
	}
	
}