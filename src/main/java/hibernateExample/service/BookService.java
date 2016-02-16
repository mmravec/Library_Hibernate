package hibernateExample.service;

import hibernateExample.model.Book.BookDao;

import java.util.List;

import hibernateExample.Book;

public class BookService {

	private static BookDao bookDao;

	public BookService() {
		bookDao = new BookDao();
	}

	public void persist(Book entity) {
		bookDao.openCurrentSessionWithTransaction();
		bookDao.persist(entity);
		bookDao.closeCurrentSessionWithTransaction();
	}

	// tu som robil zmeny
	public void update(Book entity) {
		bookDao.openCurrentSessionWithTransaction();
		bookDao.update(entity);
		bookDao.closeCurrentSessionWithTransaction();
	}

	public Book findById(String id) {
		bookDao.openCurrentSession();
		Book book = bookDao.findById(id);
		bookDao.closeCurrentSession();
		return book;
	}

	public void delete(String id) {
		bookDao.openCurrentSessionWithTransaction();
		Book book = bookDao.findById(id);
		bookDao.delete(book);
		bookDao.closeCurrentSessionWithTransaction();
	}

	public void deleteAll() {
		bookDao.openCurrentSessionWithTransaction();
		bookDao.deleteAll();
		bookDao.closeCurrentSessionWithTransaction();
	}

	public List<Book> findAll() {
		bookDao.openCurrentSession();
		List<Book> books = bookDao.findAll();
		bookDao.closeCurrentSession();
		return books;
	}

	public BookDao bookDao() {
		return bookDao;
	}

}
