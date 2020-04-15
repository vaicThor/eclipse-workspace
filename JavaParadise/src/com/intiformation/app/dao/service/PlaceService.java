package com.intiformation.app.dao.service;

import java.util.List;

import com.intiformation.app.dao.DaoFactory;
import com.intiformation.app.dao.PlaceDAO;
import com.intiformation.app.dao.TripDAO;
import com.intiformation.app.dao.jdbc.JdbcPlaceDAO;
import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;



public class PlaceService {

private JdbcPlaceDAO jdbcPlaceDAO ;
	
	public PlaceService() {
		this.jdbcPlaceDAO = new JdbcPlaceDAO() ;
	}
	
	public void addPlace(Place place) {
		PlaceDAO placeDAO = DaoFactory.getPlaceDao();
		placeDAO.createPlace(place);
		System.out.println("the city " + place.getName()+ " has been create");
	}
	
	public void removePlace(Long id) {
		PlaceDAO placeDAO = DaoFactory.getPlaceDao();
		Place place = placeDAO.findPlaceById(id);
		placeDAO.deletePlace(place);
		
		
		//TODO remove Trip here or in the interactiveManager??
		
	}
	public void update(Place newPlace) {
		PlaceDAO placeDAO = DaoFactory.getPlaceDao();
		placeDAO.updatePlace(newPlace);
		System.out.println("Now, at the id n°"+newPlace.getId()+" we'got " + newPlace.getId());
	}
	public List<Place> fetchAll() {
		PlaceDAO placeDAO = DaoFactory.getPlaceDao();
		
		List<Place> placeList = placeDAO.findAll();
		
		for (Place place : placeList) {
			System.out.println(place.getId()+" " +place.getName());
			}
		return placeList;
	}
	public Place fetchplaceById(Long id) {
		PlaceDAO placeDAO = DaoFactory.getPlaceDao();
		Place place = placeDAO.findPlaceById(id);
		System.out.println("the city's name is " + place.getName());
		return place;
	}
	public Place fetchplaceByName(String name) {
		PlaceDAO placeDAO = DaoFactory.getPlaceDao();
		Place place = placeDAO.findPlaceByName(name);
		System.out.println("the city's Id you wante to display is " + place.getId());
		return place;
	}
}
