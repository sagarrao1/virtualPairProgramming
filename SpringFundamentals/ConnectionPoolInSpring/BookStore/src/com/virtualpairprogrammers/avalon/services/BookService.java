package com.virtualpairprogrammers.avalon.services;

import java.util.List;

import com.virtualpairprogrammers.avalon.domain.Book;

public interface BookService {
	
	public List<Book> getallBooksByAuthor(String author);
	public List<Book> getallRecommedBooks(String userid);
	public Book getBookByISBN(String isbn);
	public List<Book> getEntireCatalog();
	public void registerNewBook(Book newBook);
	public void removeBook(String isbn);
}
