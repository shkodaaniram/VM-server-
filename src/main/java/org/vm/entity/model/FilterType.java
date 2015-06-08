package org.vm.entity.model;

public enum FilterType {
	NONE(0),
	SEPIA(1),
	AQUA(2),
	NEGATIVE(3),
	POSTERIZE(4),
	SOLARIZE(5),
	MONO(6),
	WHITEBOARD(7),
	BLACKBOARD(8);
	
	private int typeId;

	private FilterType(int typeId){
		this.typeId = typeId;
	}
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public static FilterType getFilterById(int id){
		for(FilterType filterType : FilterType.values()){
			if(filterType.getTypeId() == id){
				return filterType;
			}
		}
		return NONE;
	}
}
