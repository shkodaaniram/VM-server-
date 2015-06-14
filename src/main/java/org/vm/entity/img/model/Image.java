package org.vm.entity.img.model;

import java.sql.Date;

import org.vm.entity.model.*;

public class Image extends Entity {
	public Image() {
		super();
	}

	public Image(int id, String name, FilterType filterType, String path,
			EntityType entityType, Date uploadedOn, int accountId) {
		super(id, name, filterType.getTypeId(), path, EntityType.IMAGE, uploadedOn,
				accountId);
	}

	@Override
	public String toString() {
		return "Image [getId()=" + getId() + ", getName()=" + getName()
				+ ", getFilterType()=" + getFilterType() + ", getPath()="
				+ getPath() + ", getEntityType()=" + getEntityType()
				+ ", getUploadedOn()=" + getUploadedOn() + ", accountId()="
				+ getAccountId() + ", getClass()=" + getClass() + "]";
	}

}