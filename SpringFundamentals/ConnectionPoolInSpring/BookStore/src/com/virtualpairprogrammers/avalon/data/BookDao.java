package com.virtualpairprogrammers.avalon.data;

import java.util.List;

import com.virtualpairprogrammers.avalon.domain.Book;

public interface BookDao {
	   public List<Book> allBooks();
	   public Book findByIsbn(String isbn);
	   public void create(Book newBook);
	   public void delete(String isbn);
	   public List<Book> findBooksByAuthor(String author);   
}
