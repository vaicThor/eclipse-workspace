package amap.services;

import java.util.ArrayList;
import java.util.List;

import amap.dao.ProductMysqlDAO;
import amap.model.Product;
import amap.model.Product.ProductTypeEnum;

public class ProductService {
	
	private ProductMysqlDAO productDAO ;
	
	public ProductService() {
		this.productDAO = new ProductMysqlDAO() ;
	}
	
	public void addProduct(String name, float price, ProductTypeEnum type ) {
		Product theProduct = new Product(name, price, type);
		productDAO.create(theProduct);
		
	}
	
	public void removeProduct(int id) {
		Product product = productDAO.find(id);
		productDAO.delete(id);
	}
	public void updateProduct(Product newProduct ) {
		productDAO.update(newProduct);
	}
	public List<Product> fetchAll() {
		return productDAO.findAll();
	}
	public Product fetchProduct(int id) {
		Product product = productDAO.find(id);
		return product;
	}
//	public List<Product> search(String name) {
//		
//		return productList ;
//	}
}
