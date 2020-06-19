package com.virtualpairprogrammers.avalon.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.avalon.domain.Book;
import com.virtualpairprogrammers.avalon.services.BookService;

public class ClientApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext container=
				new ClassPathXmlApplicationContext("application.xml");
		
		BookService bookService = container.getBean("bookService", BookService.class);
		
		bookService.registerNewBook(new Book("227799","book title5", "phani",22.55));
		bookService.registerNewBook(new Book("227801","book 2", "ganesh",11.77));
		
		List<Book> entireCatalog = bookService.getEntireCatalog();
		
		for (Book book : entireCatalog) {
			System.out.println(book);
		}
		
//		bookService.removeBook("227799");
//		System.out.println("Book id 227799 removed");
//		
//		bookService.removeBook("227801");
//		System.out.println("Book id 227801 removed");
		
		container.close();
	}

}
