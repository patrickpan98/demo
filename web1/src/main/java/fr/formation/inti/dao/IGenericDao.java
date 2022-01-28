package fr.formation.inti.dao;

import java.io.Serializable;
import java.util.List;


public interface IGenericDao<T, I extends Serializable> {
	public I save(T t);

	public void update(T t);

	public void delete(T t);

	public T findById(I i);

	public List<T> findAll();
}
