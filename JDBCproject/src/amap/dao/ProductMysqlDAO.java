package amap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import amap.ConnectionManager;
import amap.model.Product;
import amap.model.Product.ProductTypeEnum;

public class ProductMysqlDAO extends DAO<Product>{

	private Connection connection ;
	private List <Product> productList ;
	
	public ProductMysqlDAO() {
	connection = ConnectionManager.getConnection();
}

	@Override
	public Product find(int id) {
		Product productFound = null ;
		
		String query = "SELECT id, name, price, type FROM tabletestamap WHERE id = " ; // on pourrait pour tout charger, remplacer "id, name, price, type" par *
		// Le preparedStatemet est plus sécurisé, plus rapide et permet de paramètrer la requète 
		try (PreparedStatement pSt = connection.prepareStatement(query)){
			pSt.setInt(1,  id);
			
			ResultSet rs = pSt.executeQuery();
			if (rs.next()) {
				productFound= toProduct(rs);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			return productFound ;
		
	}
	private Product toProduct (ResultSet rs) throws SQLException {
		int id 		= rs.getInt("id");
		String name = rs.getString("name");
		float price = rs.getFloat("price");
		String type = rs.getString("type");
		Product.ProductTypeEnum typeEnum = Product.ProductTypeEnum.valueOf(type) ;
		return new Product (id, name, price, typeEnum) ;
	}

	@Override
	public Product create(Product product) {
		String queryInsert = "INSERT INTO tabletestamap(id, name, price, type) VALUES (?,?,?,?)"; 
		try(PreparedStatement pSt = connection.prepareStatement(queryInsert,PreparedStatement.RETURN_GENERATED_KEYS)){
			
			pSt.setInt(1, product.getId());
			pSt.setString(2, product.getName());
			pSt.setFloat(3, product.getPrice());
			pSt.setString(4, product.getType().name());
			
			int row = pSt.executeUpdate() ;
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
			
			// Rows affected
			System.out.println(row);
			
//			DAO<Product> dao = new ProductMysqlDAO() ;
//			Product p = dao.find(product.getId());
			
		}catch (SQLException e) {
			System.err.format("SQL state : %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return product ;
	} 
	@Override
	public Product update(Product productUpdated) {
		//!!!Ne pas faire ça avec la requète ! pas sécurisé!
		String queryUpdate = "UPDATE tabletestamap SET name='"+productUpdated.getName()+
													"', price ="+productUpdated.getPrice()+
													" WHERE id ="+productUpdated.getId();
		
		try (PreparedStatement pSt = connection.prepareStatement(queryUpdate)){
			
			int row = pSt.executeUpdate();
			
			System.out.println(row);
		}catch (SQLException e) {
			System.err.format("SQL state : %s\n%s", e.getSQLState(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

		return productUpdated ;
	}

	@Override
	public void delete(int id) {
		String queryDelete = "DELETE FROM `tabletestamap` WHERE id = ?";
		try (PreparedStatement pSt = connection.prepareStatement(queryDelete)){
			pSt.setInt(1, id);
			
					int row = pSt.executeUpdate();
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
					System.out.println(row);
				}catch (SQLException e) {
					System.err.format("SQL state : %s\n%s", e.getSQLState(), e.getMessage());
				}catch (Exception e) {
					e.printStackTrace();
				}
	}

	@Override
	public List<Product> findAll() {
		String queryFindAll = "SELECT * FROM tabletestamap ";
		
		if (productList==null) {
		
			productList = new ArrayList<Product>();
			try(PreparedStatement pSt = connection.prepareStatement(queryFindAll)){
	
				ResultSet rs= pSt.executeQuery(queryFindAll);
				while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				ProductTypeEnum type = ProductTypeEnum.valueOf(rs.getString("type"));
				Product prod =new Product(id, name,price,type);//l'ordre est important 
				productList.add(prod);
				}
			}catch(SQLException sqle){//traitement}
			}
	
		}
		return productList;
	}
		
}
