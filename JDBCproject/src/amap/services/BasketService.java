package amap.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import amap.dao.BasketMemoryDAO;
import amap.dao.DAO;
import amap.model.Basket;
import amap.model.Product;

public class BasketService {
	
	private List<Basket> basketList ;
	private DAO<Basket> basketDAO ;
	
	public BasketService() {
		this.basketDAO = new BasketMemoryDAO();	
		this.basketList = new ArrayList<Basket>();
		}
	
	public void payBasket(Basket basket) {	
		basket.setIsPaid(true) ;
	}
	public void addBasket() {
		Basket createdBasket = this.basketDAO.create(new Basket()) ;
		basketList.add(createdBasket);
	}
	public void addProduct(int basketId,  Product product, int nbProducts) {
		Basket basket = basketDAO.find(basketId) ;
		
		Map<Product, Integer> products = basket.getProducts() ;
		Integer oldNbProducts = products.get(product);
		if (oldNbProducts!=null) {
			products.replace(product, oldNbProducts+nbProducts);			
		}else {
			products.put(product, nbProducts) ;
		}
		basket.setProducts(products) ;
		basketDAO.update(basket);
	}
	public void removeProduct(Basket basket , Product product, int quantity) {
		
	}
	public void displayBasket(Basket basket) {
		
	}
	
}

