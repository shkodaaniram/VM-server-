package org.vm.entity.model;

import java.sql.Date;

public class Entity {
	private int id;
	private String name;
	private FilterType filterType;
	private String path;
	private EntityType entityType;
	private Date uploadedOn;
	private int accountId;  

	public Entity(int id, String name, FilterType filterType, String path, EntityType entityType, Date uploadedOn, int accountId){
		this.id = id;
		this.name = name;
		this.filterType = filterType;
		this.path = path;
		this.entityType = entityType;
		this.uploadedOn = uploadedOn;
		this.accountId = accountId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FilterType getFilterType() {
		return filterType;
	}

	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}

