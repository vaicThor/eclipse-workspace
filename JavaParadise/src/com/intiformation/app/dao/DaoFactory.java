package com.intiformation.app.dao;

import com.intiformation.app.dao.jdbc.JdbcPlaceDAO;
import com.intiformation.app.dao.jdbc.JdbcTripDAO;

public class DaoFactory {

	
	
	
	// constructor private
	private DaoFactory() {}
	
	// Methods
	public static TripDAO getTripDao() {
		return new JdbcTripDAO() ;
	}
	
	public static PlaceDAO getPlaceDao() {
		
		return new JdbcPlaceDAO() ;
	}
}
