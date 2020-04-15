package com.intiformation.app.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.intiformation.app.dao.PlaceDAO;
import com.intiformation.app.model.Place;


public class JdbcPlaceDAO extends JdbcDAO  implements PlaceDAO  {
	
	private List <Place> placeList ;
	public JdbcPlaceDAO() {
			super();
		}
	@Override
	public Long createPlace(Place place) {
		String queryInsert = "INSERT INTO place(name) VALUES (?)"; 
		Long autoIncrKey = -1L;
		try(PreparedStatement pSt = connection.prepareStatement(queryInsert,PreparedStatement.RETURN_GENERATED_KEYS)){
			
//			pSt.setLong(1, place.getId());
			pSt.setString(1, place.getName());
			
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
		place.setId(autoIncrKey);
		return autoIncrKey ;
	} 

	@Override
	public Place findPlaceById(Long id) {
		Place placeFound = null ;
		
		String queryFind = "SELECT id_P,name FROM place WHERE id_P = ? " ; // on pourrait pour tout charger, remplacer "id, name, price, type" par *
		// Le preparedStatemet est plus sécurisé, plus rapide et permet de paramètrer la requète 
		try (PreparedStatement pSt = connection.prepareStatement(queryFind)){
			pSt.setLong(1,  id);
			
			ResultSet rs = pSt.executeQuery();
			
			commit();
			
				while (rs.next()) {
					Long idPlace = rs.getLong("id_P");
					String name = rs.getString("name");
					placeFound = new Place(idPlace, name);
				}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return placeFound ;
		
	}
	public Place findPlaceByName(String name) {
		Place placeFound = null ;
		
		String queryFind = "SELECT id_P,name FROM place WHERE name = ? " ; // on pourrait pour tout charger, remplacer "id, name, price, type" par *
		// Le preparedStatemet est plus sécurisé, plus rapide et permet de paramètrer la requète 
		try (PreparedStatement pSt = connection.prepareStatement(queryFind)){
			pSt.setString(1,  name);
			
			ResultSet rs = pSt.executeQuery();
			
			commit();
			
				while (rs.next()) {
					Long idPlace = rs.getLong("id_P");
					String namePlace = rs.getString("name");
					placeFound = new Place(idPlace, namePlace);
				}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return placeFound ;
		
	}
	@Override
	public Boolean updatePlace(Place newPlace) {
		Boolean isUseless = false;
		String queryUpdate = "UPDATE place SET name = ? WHERE id_P = ?";
		try (PreparedStatement pSt = connection.prepareStatement(queryUpdate)){
			pSt.setString(1, newPlace.getName());
			pSt.setLong(2,  newPlace.getId());

			int row = pSt.executeUpdate();
			
			commit();
			
	// Get the old Value in order to compare with the attributes of the newPlace
//			Long idOld	   = rs.getLong("id_P");
//			String nameOld = rs.getString("name");
//			int compare = nameOld.compareTo(newPlace.getName());
//			if ( idOld == newPlace.getId() && compare == 0) {
				isUseless = true ;
//		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return isUseless ;
	}

	@Override
	public Boolean deletePlace(Place place) {
		Boolean isDelete = false;
		String queryDelete = "DELETE FROM place WHERE id_P = ?";
		try (PreparedStatement pSt = connection.prepareStatement(queryDelete)){
			pSt.setLong(1, place.getId()); 
			
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
	public List<Place> findAll() {
		String queryFindAll = "SELECT * FROM place ";
		
		if (placeList==null) {
		
			placeList = new ArrayList<Place>();
			try(PreparedStatement pSt = connection.prepareStatement(queryFindAll)){
	
				ResultSet rs= pSt.executeQuery();
				commit();
				while (rs.next()) {
				Long id = rs.getLong("id_P");
				String name = rs.getString("name");
				Place city =new Place(id, name);//l'ordre est important 
				placeList.add(city);
				}
			}catch(SQLException sqle){//traitement}
			}
	
		}
		return placeList;

	}
	public void commit() {
		try {
			// Do SQL updates...
			// Commit updates
			connection.commit();
			System.out.println("-------------------------------------------");
			System.out.println("Successfully commited");
			System.out.println("-------------------------------------------");
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
