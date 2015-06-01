package org.vm.entity.model;

public class Entity {
	private int id;
	private String name;
	private TypeFilter filter_type;
	private String path;
	private TypeEntity entity_type;
	//private Account accountId;  add set, get methods
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id; 
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name; 
	}
	
	public void setFilter_type(TypeFilter filter_type){
		this.filter_type = filter_type;
	}
	
	public TypeFilter getFilter_type(){
		return filter_type;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setEntity_type(TypeEntity entity_type){
		this.entity_type = entity_type;
	}
	
	public TypeEntity getEntity_type(){
		return entity_type;
	}
}

