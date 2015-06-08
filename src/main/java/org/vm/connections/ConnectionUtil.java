package org.vm.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionUtil {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() {
		Connection conn;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public PreparedStatement getPreparedStatement(String query, Connection conn){
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ps;
	}
	
	public void releaseConnection(Connection conn){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
