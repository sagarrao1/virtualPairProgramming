package com.virtualpairprogrammers.avalon.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.virtualpairprogrammers.avalon.domain.Book;

public class BookDaoCleanerJdbcImpl implements BookDao {
	
	private JdbcTemplate jdbcTemplate;

	private static final String CREATE_TABLE_SQL 
	= "create table BOOK(ISBN VARCHAR(20), TITLE VARCHAR(50), AUTHOR VARCHAR(50), PRICE DOUBLE)";
	private static final String INSERT_BOOK_SQL 
	= "insert into BOOK (ISBN, TITLE, AUTHOR,PRICE) values (?, ?, ?, ?) ";
	private static final String GET_ALL_BOOKS_SQL 
	= "select * from BOOK";

	public BookDaoCleanerJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private void createTables() {
		try {
			jdbcTemplate.update(CREATE_TABLE_SQL);
		} catch (DataAccessException e) {
			System.out.println("Assuming that the table already exists");
//			e.printStackTrace();
		}
	}
	
	@Override
	public List<Book> allBooks() {
		return jdbcTemplate.query(GET_ALL_BOOKS_SQL, new BookMapper());
	}

	@Override
	public Book findByIsbn(String isbn) {
		return jdbcTemplate.queryForObject
				("SELECT * FROM BOOK WHERE ISBN=?", new BookMapper(), isbn);
	}

	@Override
	public void create(Book newBook) {
		jdbcTemplate.update(INSERT_BOOK_SQL, 
				newBook.getIsbn(),newBook.getTitle(),newBook.getAuthor(),newBook.getPrice());

	}

	@Override
	public void delete(String isbn) {
		jdbcTemplate.update("DELETE FROM BOOK WHERE ISBN=?", isbn);
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		return jdbcTemplate.query("SELECT * FROM BOOK WHERE AUTHOR=?", 
				new BookMapper(), author);
	}

}

class BookMapper implements RowMapper<Book>
{
	@Override
	public Book mapRow(ResultSet rs, int rowNumber) throws SQLException {
	
	String isbn = rs.getString("ISBN");
	String title= rs.getString("TITLE");
	String author= rs.getString("AUTHOR");
	Double price= rs.getDouble("PRICE");
	
	Book theBook= new Book(isbn,title,author,price);	
	return theBook;
	}
}
