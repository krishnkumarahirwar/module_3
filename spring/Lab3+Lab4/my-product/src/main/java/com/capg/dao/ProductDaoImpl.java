package com.capg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capg.entity.Product;
import com.capg.exceptions.IncompleteProductDetailException;
@Repository
public class ProductDaoImpl implements IProductDao{
	
	 private EntityManager entityManager;

	    public EntityManager getEntityManager() {
	        return entityManager;
	    }

	    /**
	     * this is equal to @Autowired
	     */
	    @PersistenceContext
	    public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }



	@Override
	public Product addProduct(Product product) {
		if(product.getProductName()=="" || product.getProductPrice()==0) {
			throw new IncompleteProductDetailException("fill complete details of product");
		}
		Product p = getEntityManager().merge(product);
		return p;
	}

	@Override
	public List<Product> retrieveAllProduct() {
		 String jql = "from Product";
	        TypedQuery<Product> query = entityManager.createQuery(jql, Product.class);
	        List<Product> list = query.getResultList();
	        return list;
	}

}
