package org.vm.entity.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.vm.entity.model.EntityType;
import org.vm.entity.model.FilterType;
import org.vm.entity.dao.EntityDAO;
import org.vm.entity.video.model.Video;

public class VideoDAO implements EntityDAO<Video>{
	private DataSource dataSource;
	 
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(Video video){
		 
		String sql = "INSERT INTO Entity " +
				"(type, name, path, filterType, uploadedOn, account_id) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, EntityType.VIDEO.getType()); 
			ps.setString(2, video.getName());
			ps.setString(3, video.getPath());
			ps.setInt(4, video.getFilterType().getTypeId()); 
			ps.setDate(5, video.getUploadedOn());
			ps.setInt(6, video.getAccountId());  
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
	
	public Video findById(int videoId){
		String sql = "SELECT * FROM Entity WHERE id = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, videoId);
			Video video = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int type = rs.getInt("filterType");
				FilterType filterType = FilterType.getFilterById(type);
				long videoDuration = 2000; //???
				byte [] videoThumb = new byte[50000]; // dimension of array?
				video = new Video(
					rs.getInt("id"),
					rs.getString("name"),
					filterType, 
					rs.getString("path"),
					EntityType.VIDEO, 
					rs.getDate("uploadedOn"),
					rs.getInt("account_id"),
					videoDuration,
					videoThumb
				); 
			}
			rs.close();
			ps.close();
			return video;
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
