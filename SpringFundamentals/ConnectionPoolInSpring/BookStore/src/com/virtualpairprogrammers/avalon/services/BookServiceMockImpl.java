package com.virtualpairprogrammers.avalon.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.virtualpairprogrammers.avalon.domain.Book;

public class BookServiceMockImpl implements BookService {
	Map<String, Book> bookList = new HashMap<>();

	public BookServiceMockImpl() {

		Book book1 = new Book("ISBN1", "book title1", "sagar", 12.34);
		Book book2 = new Book("ISBN2", "book title2", "Raju", 9.65);
		Book book3 = new Book("ISBN3", "book title3", "Murali", 15.11);
		Book book4 = new Book("ISBN4", "book title4", "Lokesh", 23.56);
		bookList.put("ISBN1", book1);
		bookList.put("ISBN2", book2);
		bookList.put("ISBN3", book3);
		bookList.put("ISBN4", book4);

	}

	@Override
	public Book getBookByISBN(String isbn) {
		return bookList.get(isbn);
	}

	@Override
	public List<Book> getEntireCatalog() {
		return new ArrayList<Book>(bookList.values()) ;
	}

	@Override
	public void registerNewBook(Book newBook) {
		bookList.put(newBook.getIsbn(), newBook);

	}
	
	@Override
	public void removeBook(String isbn) {
	}

	// Not implemented below ===============================
	
	@Override
	public List<Book> getallBooksByAuthor(String author) {
		return null;
	}

	@Override
	public List<Book> getallRecommedBooks(String userid) {
		return null; // (List<Book>) bookList.get(userid);
	}


}
