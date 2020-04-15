package com.intiformation.app.dao;

import java.util.List;

import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;

public interface TripDAO  {
	
	public abstract Long createTrip(Trip trip) ; 
	
	public abstract Trip findTripById(Long id) ;// retournera une Place

	public abstract Boolean updateTrip(Trip trip) ;// retourne un booléen

	public abstract Boolean deleteTrip(Trip trip) ;// retournera un booléen

	public abstract List<Trip> findAll();// retournera une liste de Place

}
