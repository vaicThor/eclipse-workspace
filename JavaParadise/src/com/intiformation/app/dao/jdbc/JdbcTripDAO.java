package com.intiformation.app.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.intiformation.app.dao.TripDAO;
import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;



public class JdbcTripDAO extends JdbcDAO implements TripDAO{
	
	//Attributes
	private List<Trip> tripList ;
	
	//Constructor
	public JdbcTripDAO() {
		super();
	}
	// Methods
	@Override
	public Long createTrip(Trip trip) {
		String queryInsert = "INSERT INTO trip(departures, arrivals, price) VALUES (?,?,?)"; 
		Long autoIncrKey = -1L;
		try(PreparedStatement pSt = connection.prepareStatement(queryInsert,PreparedStatement.RETURN_GENERATED_KEYS)){
			
			pSt.setLong(1, trip.getDepartureId());
			pSt.setLong(2, trip.getArrivalId());
			pSt.setFloat(3,trip.getPrice());
			
			int row = pSt.executeUpdate() ;
			ResultSet generatedKeys = pSt.getGeneratedKeys() ;

			commit();
			
			if (generatedKeys.next()) {
				autoIncrKey=generatedKeys.getLong(1);
			}
			// Rows affected
			System.out.println(row);
			
//			DAO<Product> dao = new ProductMysqlDAO() ;
//			Product p = dao.find(product.getId());
			
		}catch (SQLException e) {
			System.err.format("SQL state : %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(autoIncrKey);
		trip.setId(autoIncrKey);
		return autoIncrKey;

	} 


	@Override
	public Trip findTripById(Long id) {
		Trip tripFound = null ;
// Query SQL in order to get a ResulSet where place's id in the table trip place's name  
 		String queryFind ="SELECT t.id AS trip_id, t.departures AS departure_id , p1.name city_departure, t.arrivals AS arrival_id, p2.name AS city_arrival, t.price as price "+
 							"FROM trip AS t "+
 							"JOIN place AS p1 ON p1.id_P = t.departures "+
 							"JOIN place AS p2 ON p2.id_P = t.arrivals "+
 							"WHERE t.id= ?;";
		// Le preparedStatemet est plus sécurisé, plus rapide et permet de paramètrer la requète 
		try (PreparedStatement pSt = connection.prepareStatement(queryFind,PreparedStatement.RETURN_GENERATED_KEYS)){
			
			pSt.setLong(1, id);
			
			ResultSet rs = pSt.executeQuery();

			commit();
			
			if (rs.next()) {
				
				tripFound= toTrip(rs);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return tripFound ;
		
	}
	private Trip toTrip (ResultSet rs) throws SQLException {
		
		Long idDeparture = rs.getLong("departure_id"); 	
		String nameDeparture = rs.getString("city_departure"); 
			Place placeDeparture = new Place(idDeparture, nameDeparture);
		Long idArrival 	   = rs.getLong("arrival_id"); 	
		String nameArrival = rs.getString("city_arrival"); 
			Place placeArrival = new Place (idArrival, nameArrival);
			
		Long id = rs.getLong("trip_id");
		Float price = rs.getFloat("price");
		
		return new Trip(id, placeDeparture, placeArrival, price) ;
	}

	@Override
	public Boolean updateTrip(Trip newTrip) {
		Boolean isUseless = false;
		String queryUpdate = "SELECT id, departures, arrivals, price FROM trip WHERE id= ?";
		try (PreparedStatement pSt = connection.prepareStatement(queryUpdate)){
			pSt.setLong(1,  newTrip.getId());
			ResultSet rs = pSt.executeQuery();

			commit();
			
	// Get the old Value in order to compare with the attributes of the newPlace
				Trip tripOld = toTrip(rs);
				
			if ( tripOld.equals(newTrip)){
				isUseless = true ;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return isUseless ;
	}
public void deleteTripByPlace(Long idDelete){
	String queryDelete = "DELETE FROM `trip` WHERE departures = ? OR arrivals = ?";
	try (PreparedStatement pSt = connection.prepareStatement(queryDelete)){
		pSt.setLong(1,idDelete); 
		pSt.setLong(2,idDelete);
		
				int row = pSt.executeUpdate();
				commit();
				
				System.out.println(row);
			}catch (SQLException e) {
				System.err.format("SQL state : %s\n%s", e.getSQLState(), e.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
			}
}

	@Override
	public Boolean deleteTrip(Trip trip) {
		Boolean isDelete = false;
		String queryDelete = "DELETE FROM `trip` WHERE id = ?";
		try (PreparedStatement pSt = connection.prepareStatement(queryDelete)){
			pSt.setLong(1, trip.getId()); 
			
					int row = pSt.executeUpdate();
					if (row!=0) {
						isDelete = true;
					}

					commit();
					
					System.out.println(row);
				}catch (SQLException e) {
					System.err.format("SQL state : %s\n%s", e.getSQLState(), e.getMessage());
				}catch (Exception e) {
					e.printStackTrace();
				}
		return isDelete ;
	}

	@Override
	public List<Trip> findAll() {

		String queryFindAll = "SELECT t.id AS trip_id, t.departures AS departure_id , p1.name city_departure, t.arrivals AS arrival_id, p2.name AS city_arrival, t.price as price " + 
								"FROM trip AS t " + 
								"JOIN place AS p1 ON p1.id_P = t.departures " + 
								"JOIN place AS p2 ON p2.id_P = t.arrivals " + 
								"WHERE t.id= ?";
		
		if (tripList==null) {
		
			tripList = new ArrayList<Trip>();
			try(PreparedStatement pSt = connection.prepareStatement(queryFindAll)){
	
				ResultSet rs= pSt.executeQuery();

				commit();
				
				// List construction
				while (rs.next()) {
					Trip trip =toTrip(rs);
					tripList.add(trip);
//					System.out.println(trip.getId()+"  | FROM " +trip.getDeparture()+"  | TO  " +trip.getArrival()+"   |  FOR "+ trip.getPrice()+"€");
				}
			}catch(SQLException sqle){//Treatment}
			}
	
		}
		return tripList;

	}
	public void commit() {
		try {
			// Do SQL updates...
			// Commit updates
			connection.commit();
			System.out.println("Successfully commited!");
		} catch (SQLException e) {
			try {
				// Rollback update
				connection.rollback();
				System.out.println("Successfully rolled back changes from the database !");
				} catch (SQLException e1) {
					System.out.println("Could not rollback updates " + e1.getMessage());
			}
		}
	}
}
