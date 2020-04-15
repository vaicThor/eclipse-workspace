package amap;

import java.sql.Connection;

import amap.dao.BasketMysqlDAO;
import amap.dao.DAO;
import amap.model.Basket;
import amap.model.Product;
import amap.model.Product.ProductTypeEnum;
import amap.services.ProductService;

public class MainAmap {

	public static void main(String[] args) {
		DAO<Basket> bsql= new BasketMysqlDAO() ;
		Basket basket = bsql.find(1); 
//			Product fr = new Product (1,"Fraise", 2,ProductTypeEnum.Fruits);
//			ProductMysqlDAO db = new ProductMysqlDAO();
//			db.create(fr);
//			
//		IntetractiveAMAP com = new IntetractiveAMAP();
//		com.interactive();
	}
}
