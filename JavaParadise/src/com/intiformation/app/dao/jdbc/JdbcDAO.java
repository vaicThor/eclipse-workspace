package com.intiformation.app.dao.jdbc;

import java.sql.Connection;

import com.intiformation.app.util.ConnectionManager;

public abstract class JdbcDAO {
	
	protected Connection connection ;
	
	public JdbcDAO() {
	this.connection = ConnectionManager.getConnection();
	}
}
