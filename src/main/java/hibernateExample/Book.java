package hibernateExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 *  CREATE TABLE `library`.`book` ( 
	id VARCHAR(50) NOT NULL, 
	title VARCHAR(20) default NULL, 
	author VARCHAR(50) default NULL, 
	PRIMARY KEY (id) 
	);
 * 
 * 
 * @author P3502441
 *
 */


@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	String author;

	public Book(String id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public Book(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

} 	
