package org.vm.entity.model;

public enum EntityType {
	IMAGE("IMAGE"),
	VIDEO("VIDEO");
	private String type;
	private EntityType(String type){
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
