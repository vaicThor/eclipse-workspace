package com.intiformation.app.model;

import java.io.Serializable;

public class Trip implements Serializable{
	
	//Attributes
	private Long id;
	private Place departure ;
	private Place arrival ;
	private Float price ;
	
	//Constructor
	public Trip() {
	}
	public Trip(Long id, Place departure, Place arrival, Float price) {
		this.id = id;
		this.departure=departure ;
		this.arrival =arrival ;
		this.price = price ;
		
	}
	// Methods
	
	public Trip(Place departure, Place arrival, float price) {
		this.departure = departure ;
		this.arrival = arrival ;
		this.price = price ;
	}
	public Long getId() {
		return id;
	}
	public Long getDepartureId() {
		return departure.getId();
	}
	public Long getArrivalId() {
		return arrival.getId();
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeparture() {
		return departure.getName();
	}
	public void setDeparture(Place departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival.getName();
	}
	public void setArrival(Place arrival) {
		this.arrival = arrival;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Boolean equals(Trip trip) {
	      return (trip instanceof Trip) && 
		  ((Trip)trip).getId().equals(id) && 
		  ((Trip)trip).getDeparture()== departure.getName() &&
		  ((Trip)trip).getArrival()== arrival.getName() &&
		  ((Trip)trip).getPrice()== price;
		   }
}
