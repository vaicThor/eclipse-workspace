package com.intiformation.app.dao;

import java.util.List;

import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;

public interface PlaceDAO {
	
	public abstract Long createPlace(Place place) ; 
	
	public abstract Place findPlaceById(Long id) ;// retournera une Place

	public abstract Place findPlaceByName(String placeName) ;
	
	public abstract Boolean updatePlace(Place place) ;// retourne un booléen

	public abstract Boolean deletePlace(Place place) ;// retournera un booléen

	public abstract List<Place> findAll();// retournera une liste de Place

}

