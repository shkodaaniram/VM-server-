package org.vm.entity.dao;

import java.util.List;

public interface EntityDAO<T> {
	public T findById(int entityId);
	public void insert(T t);
	public List<T> findAllForAccount(int accountId);
	public void deleteById(int id);
	public void deleteAllForAccount(int account_id);
	public void rename(int id, String newName);
}
