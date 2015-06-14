package org.vm.entity.img.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.vm.entity.dao.EntityDAO;
import org.vm.entity.model.*;
import org.vm.entity.img.model.Image;

@Repository
public class ImageDAO implements EntityDAO<Image> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(Image image){
		
		String sql = "INSERT INTO Entity " +
				"(type, name, path, filterType, uploadedOn, account_id) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { EntityType.IMAGE.getType(), image.getName(), image.getPath(), 
				image.getFilterType(), image.getUploadedOn(), image.getAccountId()
		});
	}
	
	public Image findById(int imageId){
		String sql = "SELECT * FROM Entity WHERE id = ?";
		Image image = jdbcTemplate.queryForObject(sql, new Object[]{imageId}, new BeanPropertyRowMapper<Image>(Image.class));
		return image;
	}
	
	public List<Image> findAllForAccount(int accountId){
		String sql = "SELECT * FROM Entity WHERE account_id = ?";
		List<Image> results = jdbcTemplate.query(sql, new Object[] {accountId}, new BeanPropertyRowMapper<Image>(Image.class));
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
