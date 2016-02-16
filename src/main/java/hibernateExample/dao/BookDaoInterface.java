package hibernateExample.dao;

import java.io.Serializable;
import java.util.List;



public interface BookDaoInterface<T, Id extends Serializable> {
	
	public void persist(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public void deleteAll();
	
	public T findById(Id id);
	
	public List<T> findAll();

}
