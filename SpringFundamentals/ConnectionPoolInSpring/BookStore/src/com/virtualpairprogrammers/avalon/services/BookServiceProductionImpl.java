package com.virtualpairprogrammers.avalon.services;

import java.util.List;

import com.virtualpairprogrammers.avalon.data.BookDao;
import com.virtualpairprogrammers.avalon.domain.Book;

/**
 * This is the production implementation - it will be calling a "real" database.
 */
public class BookServiceProductionImpl implements BookService {

	private BookDao dao;
	
	public BookServiceProductionImpl(BookDao dao) {
		this.dao= dao;	
	}		

	@Override
	public Book getBookByISBN(String isbn) {
		return dao.findByIsbn(isbn);
	}

	@Override
	public List<Book> getEntireCatalog() {
		return dao.allBooks();
	}

	@Override
	public void registerNewBook(Book newBook) {
		// we want this book to be put into the database.
		dao.create(newBook);

	}
	
	@Override
	public List<Book> getallBooksByAuthor(String author) {
		return dao.findBooksByAuthor(author);
	}
	
	public void removeBook(String isbn) {
		dao.delete(isbn);
	}

//	 Not implemented ============================
	

	@Override
	public List<Book> getallRecommedBooks(String userid) {
		throw new UnsupportedOperationException();
	}

}
