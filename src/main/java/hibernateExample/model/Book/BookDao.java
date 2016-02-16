package hibernateExample.model.Book;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernateExample.Book;
import hibernateExample.dao.BookDaoInterface;

public class BookDao implements BookDaoInterface<Book, String> {

	private Session currentSession;

	private Transaction currentTransaction;

	public BookDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionWithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession(){
		currentSession.close();
	}

	public void closeCurrentSessionWithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Book entity) {
		getCurrentSession().save(entity);
	}

	public void update(Book entity) {
		getCurrentSession().update(entity);
	}

	public void delete(Book entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteAll() {
		List<Book> entityList = findAll();
		for (Book entity : entityList) {
			delete(entity);
		}
	}
	
	public Book findById(String id) {
		Book book = (Book) getCurrentSession().get(Book.class, id);
		return book;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findAll() {
		List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
		return books;
	}

}
