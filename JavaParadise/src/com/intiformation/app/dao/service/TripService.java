package com.intiformation.app.dao.service;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.intiformation.app.dao.DaoFactory;
import com.intiformation.app.dao.TripDAO;
import com.intiformation.app.dao.jdbc.JdbcTripDAO;
import com.intiformation.app.model.Trip;

public class TripService {
private JdbcTripDAO jdbcTripDAO ;
	
	public TripService() {
		this.jdbcTripDAO = new JdbcTripDAO() ;
	}
// Entrer le nom de la ville et accéder à la table place pour récuperer l'id et la mettre dans la table de Trip
	// Pour ça : on récupère la ville en String (donc constructeur de Trip avec D/A en String)
	  // Puis on recherche dans la bdd la ville avec l'id et créer donc ensuite un tr
	//Ouaiiiiiii ta gueule!
	
	
	public void addTrip(Trip trip) {
		TripDAO tripDAO = DaoFactory.getTripDao();
		tripDAO.createTrip(trip);
		// TODO 
		
	}
	
	public void removeTrip(Long id) {
		TripDAO tripDAO = DaoFactory.getTripDao();
		Trip trip = tripDAO.findTripById(id);
		tripDAO.deleteTrip(trip);
	}
	public void update(Trip newTrip) {
		TripDAO tripDAO = DaoFactory.getTripDao();
		Trip trip = tripDAO.findTripById(newTrip.getId());
		tripDAO.updateTrip(newTrip);
	}
	public void fetchAll() {
		
		List<Trip> tripList = jdbcTripDAO.findAll();
			
			}
		
	public void fetchTripById(Long id) {
		Trip trip = jdbcTripDAO.findTripById(id);
		
		System.out.println(trip.getId()+"  | FROM " +trip.getDeparture()+"  | TO  " +trip.getArrival()+"   |  FOR "+ trip.getPrice()+"€");

	}
	public void removeTripByPlace(Long idDelete) {
		TripDAO tripDAO = DaoFactory.getTripDao();
		((JdbcTripDAO) tripDAO).deleteTripByPlace(idDelete);
	}
}

