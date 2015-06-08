package org.vm.entity.img.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vm.connections.ConnectionUtil;
import org.vm.entity.dao.EntityDAO;
import org.vm.entity.model.*;
import org.vm.entity.img.model.Image;

@Repository
public class ImageDAO implements EntityDAO<Image> {
	/*private DataSource dataSource;
	 
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	@Autowired
	private ConnectionUtil connUtil;

	public void insert(Image image){
		
		String sql = "INSERT INTO Entity " +
				"(type, name, path, filterType, uploadedOn, account_id) VALUES (?, ?, ?, ?, ?, ?)";
		//Connection conn = null;
		Connection conn = connUtil.getConnection();
		PreparedStatement ps = connUtil.getPreparedStatement(sql, conn);
		try {
			//conn = dataSource.getConnection();
			//PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, EntityType.IMAGE.getType()); 
			ps.setString(2, image.getName());
			ps.setString(3, image.getPath());
			ps.setInt(4, image.getFilterType().getTypeId()); 
			ps.setDate(5, image.getUploadedOn());
			ps.setInt(6, image.getAccountId());  //TODO : hardcoded accountId
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} /*finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}*/
		connUtil.releaseConnection(conn);
	}
	
	public Image findById(int imageId){
		String sql = "SELECT * FROM Entity WHERE id = ?";
		 
		//Connection conn = null;
		Connection conn = connUtil.getConnection();
		PreparedStatement ps = connUtil.getPreparedStatement(sql, conn);
		Image image = null;
		try {
			//conn = dataSource.getConnection();
			//PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, imageId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int type = rs.getInt("filterType");
				FilterType filterType = FilterType.getFilterById(type);
				image = new Image(
					rs.getInt("id"),
					rs.getString("name"),
					filterType, 
					rs.getString("path"),
					EntityType.IMAGE, 
					rs.getDate("uploadedOn"),
					rs.getInt("account_id")
				); 
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} /*finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}*/
		connUtil.releaseConnection(conn);
		return image;
	}
	}

