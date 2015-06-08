package org.vm.entity.dao;

public interface EntityDAO<T> {
	public T findById(int entityId);
	public void insert(T t);
}
