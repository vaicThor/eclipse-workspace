package amap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import amap.ConnectionManager;
import amap.model.Basket;
import amap.model.Product;

public class BasketMysqlDAO extends DAO<Basket> {
	
	private Connection connection ;
	private List<Basket> basketList ;
	
	public BasketMysqlDAO() {
		connection = ConnectionManager.getConnection();
	}
	@Override
	public Basket find(int id) {
		Basket basketFound = null ;
		
		String queryFind = "SELECT b.id_B AS basketId, b.price AS b_price, b.isPaid , p.id_P AS productId, p.name AS productName, p.price AS productPrice, p.type AS productType, tables_link.quantity as quantity\r\n" + 
							"FROM tables_link \r\n" + 
							"JOIN tabletestamap AS p ON p.id_P = tables_link.P_id \r\n" + 
							"JOIN basket AS b ON b.id_B = ?";
		 // on pourrait pour tout charger, remplacer "id, name, price, type" par *
		// Le preparedStatemet est plus sécurisé, plus rapide et permet de paramètrer la requète 
		try (PreparedStatement pSt = connection.prepareStatement(queryFind)){
			pSt.setInt(1,  id);
			
			ResultSet rs = pSt.executeQuery();
			try {
				// Do SQL updates...
				// Commit updates
				connection.commit();
				System.out.println("Successfully commited changes to the database !");
				} catch (SQLException e) {
				try {
				// Rollback update
				connection.rollback();
				System.out.println("Successfully rolled back changes from the database !");
				} catch (SQLException e1) {
				System.out.println("Could not rollback updates " + e1.getMessage());
				}
			}
			while (rs.next()) {
				if (rs.isFirst()) {
				// Fullfilling Basket
	// utiliser Integer pour les porchaines foi			
					int idBasket = rs.getInt("basketId");
					float priceBasket = rs.getFloat("b_price");
					boolean isPaidBasket = rs.getBoolean("isPaid");
					basketFound =new Basket(idBasket, priceBasket, isPaidBasket);
				}	
					// Fill Product
					int idProduct  = rs.getInt("productId");
					float price    = rs.getFloat("productPrice");
					String nameP   = rs.getString("productName");
					String type    = rs.getString("productType");
					Product.ProductTypeEnum typeEnum = Product.ProductTypeEnum.valueOf(type) ;
					Product p = new Product (idProduct, nameP, price, typeEnum) ;
					int quantity = rs.getInt("quantity");
					basketFound.addProductWithQuantity(p, quantity);			
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return basketFound ;
		
	}

	@Override
	public Basket create(Basket obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Basket update(Basket obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Basket> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
