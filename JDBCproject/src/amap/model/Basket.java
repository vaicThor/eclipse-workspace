package amap.model;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	private int id ;
	private float price;
	private boolean isPaid = false ;
	private int quantity ;
	private Map<Product , Integer> mapProducts ;
	
	public Basket() {
		this.mapProducts = new HashMap<Product, Integer>() ; // Integer = quantity of the Product
	}
	public Basket(int id, float price, boolean isPaid) {
		this();
		this.id = id;
		this.price = price ;
		this.isPaid = isPaid;
	}
	public int getId() {
		return id;
	}


	public float getPrice() {
		return price;
	}
	public boolean setIsPaid(boolean b) {
		// TODO Auto-generated method stub
		return true;
	}


	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}
	public Map<Product, Integer> getProducts() {
		// TODO Auto-generated method stub
		return mapProducts;
	}
	public void setProducts(Map<Product, Integer> mapProducts) {
		this.mapProducts = mapProducts ;
	}
	public void addProductWithQuantity(Product p, int quantity) {
		this.mapProducts.put(p,quantity);	
	}

}
