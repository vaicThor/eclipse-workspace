package amap.dao;

import java.util.ArrayList;
import java.util.List;

import amap.model.Basket  ;
import amap.model.Product ;

public class ProductMemoryDAO extends DAO <Product>{
	private List<Product> productList ;
	private int idSequence ;
	// Constructor
	public ProductMemoryDAO() {
		this.productList = new ArrayList<>() ;
		this.idSequence = 0 ;
	}
	
	@Override
	public  Product find(int id) {
		return this.productList
				.stream()
				.filter(product -> product.getId() == id)
				.findAny()
				.get() ;
	}

	@Override
	public  Product create(Product product) {
		product.setId(++idSequence) ; // Compteur d'id Séquenceur d'iD, responsable de tes id
		this.productList.add(product);
		return product ;
	}
	
	@Override
	// Préparer la maj du Product en modifiant l'instanciation de l'objet au préalable
	public Product update(Product newProduct) {
		Product oldProduct = this.find(newProduct.getId()) ;
		int indexOldProduct = this.productList.indexOf(oldProduct) ;
		this.productList.set( indexOldProduct,  newProduct) ;
		return newProduct ;
	}
	@Override
	public void delete(int id) {
		Product oldProduct = this.find(id) ;
		this.productList.remove(oldProduct);
	}

	@Override
	public List<Product> findAll() {
		return this.productList ;		
	}
		
}
