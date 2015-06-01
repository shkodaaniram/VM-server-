package org.vm.entity.img.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.vm.entity.dao.EntityDAO;
import org.vm.entity.model.*;
import org.vm.entity.img.model.Image;

public class ImageDAO implements EntityDAO<Image> {
	private DataSource dataSource;
	private TypeEntity entityType;
	 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Image image){
		 
		String sql = "INSERT INTO Entity " +
				"(entity_type, entity_name, entity_path, entity_typeFilter, account_id) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, entityType.IMAGE); //????????????????????????????????????
			ps.setString(2, image.getName());
			ps.setString(3, image.getPath());
			//ps.setInt(4, image.getFilter_type()); //???????????????
			//ps.setInt(5, image.getAccount());  add accountId field to Entity class
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Image findById(int imageId){
		String sql = "SELECT * FROM Entity WHERE entity_id = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, imageId);
			Image image = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				/*image = new Image(
					rs.getInt("entity_id"),
					rs.getInt("entity_type"), 
					rs.getString("entity_name"),
					rs.getString("entity_path"),
					rs.getInt("entity_typeFilter")
					//rs.getInt("account_id")
				); */
			}
			rs.close();
			ps.close();
			return image;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	}

