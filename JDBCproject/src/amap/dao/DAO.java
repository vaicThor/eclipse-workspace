package amap.dao;

import java.util.List;

public abstract class DAO<T> {

		public abstract T find(int id) ;
		
		public abstract T create(T obj) ;
		
		public abstract T update(T obj) ;
		
		public abstract void delete(int id) ;

		public abstract List<T> findAll() ;
}
