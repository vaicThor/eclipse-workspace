package amap.dao;

import java.util.ArrayList;
import java.util.List;

import amap.model.Basket;
import amap.model.Product;

public class BasketMemoryDAO extends DAO<Basket> {
	
	private List<Basket> basketList ;
	private int idSequence ;
	
	// Constructeur
	public BasketMemoryDAO() {
		this.basketList = new ArrayList<>() ;
		this.idSequence = 0 ;
	}

	@Override 
	// On veut que ma DAO me donne le panier à l'id "int id"
	// conversion de liste en stream(flux) , puis filtrage pour récupérer et trouver l'id et nous renvoyez le resultat 
	public Basket find(int id) {
		return this.basketList
				.stream()
				.filter(basket -> basket.getId() == id)
				.findAny()
				.get() ;
	}
	
	@Override
	public Basket create(Basket basket) {
		basket.setId(++idSequence) ;
		basketList.add(basket);
		return basket ;
	}
	@Override
	public Basket update(Basket newBasket) {
		Basket oldBasket = this.find(newBasket.getId());
		int indexOldBasket = this.basketList.indexOf(oldBasket) ;
		this.basketList.set( indexOldBasket,  newBasket) ;
		return newBasket ;
	}
	@Override 
	public void delete(int id) {
		Basket oldBasket = this.find(id);
		this.basketList.remove(oldBasket);
	}
	@Override
	public List<Basket> findAll() {
		return this.basketList;
	}

}
