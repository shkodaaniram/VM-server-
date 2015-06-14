package org.vm.entity.video.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.vm.entity.model.EntityType;
import org.vm.entity.dao.EntityDAO;
import org.vm.entity.video.model.Video;

public class VideoDAO implements EntityDAO<Video>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(Video video){
		 
		String sql = "INSERT INTO Entity " +
				"(type, name, path, filterType, uploadedOn, account_id) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { EntityType.VIDEO.getType(), video.getName(), video.getPath(), 
				video.getFilterType(), video.getUploadedOn(), video.getAccountId()
		});
	}
	
	public Video findById(int videoId){
		String sql = "SELECT * FROM Entity WHERE id = ?";
		Video video = jdbcTemplate.queryForObject(sql, new Object[]{videoId}, new BeanPropertyRowMapper<Video>(Video.class));
		return video;
	}
	
	public List<Video> findAllForAccount(int accountId){
		String sql = "SELECT * FROM Entity WHERE account_id = ?";
		List<Video> results = jdbcTemplate.query(sql, new Object[] {accountId}, new BeanPropertyRowMapper<Video>(Video.class));
		return results;
	}
	
	public void deleteById(int id){
		String sql = "DELETE FROM Entity WHERE id = ?";
		jdbcTemplate.update(sql, new Object[]{id});
	}
	
	public void deleteAllForAccount(int account_id){
		String sql = "DELETE FROM Entity WHERE account_id = ?";
		jdbcTemplate.update(sql, new Object[]{account_id});
	}
	
	public void rename(int id, String newName){
		String sql = "UPDATE Entity SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[]{newName, id});
	}
}
