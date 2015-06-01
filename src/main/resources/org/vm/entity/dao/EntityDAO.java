package org.vm.entity.dao;

import org.vm.entity.model.Entity;

public interface EntityDAO<T> {
	public Entity findById(int entityId);
	public void insert(T t);
}
