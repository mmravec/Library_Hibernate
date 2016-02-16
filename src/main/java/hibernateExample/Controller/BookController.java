package hibernateExample.Controller;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import hibernateExample.Book;
import hibernateExample.service.BookService;

public class BookController implements Serializable {

	private static final long serialVersionUID = 1L;

	public void add() {
		BookService bookService = new BookService();

		Scanner sc = new Scanner(System.in);
		System.out.println("Zadaj id produktu");
		String id = sc.nextLine();
		System.out.println("Zadaj titul knihy");
		String title = sc.nextLine();
		System.out.println("Zadaj autora knihy");
		String author = sc.nextLine();

		Book newBook = new Book(id, title, author);
		bookService.persist(newBook);
	}

	public void deleteAtIndex(String id) {
		BookService bookService = new BookService();
		bookService.delete(id);
	}

	public void findById(String id) {
		BookService bookService = new BookService();
		bookService.findById(id);
	}
	
	public void findAll(){
		BookService bookService = new BookService();
		System.out.println("*** Prehladavam... ***");
		List<Book> books = bookService.findAll();
		System.out.println("Nasiel som tieto knihy: ");
		for (Book b : books) {
			System.out.println("-" + b.toString());
		}
	}
	
	public void update(String id){
		BookService bookService = new BookService();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Zadaj titul knihy");
		String title = sc.nextLine();
		System.out.println("Zadaj autora knihy");
		String author = sc.nextLine();
		
		Book newBook = new Book(); 
		newBook.setId(id);
		newBook.setTitle(title);
		newBook.setAuthor(author);
		bookService.update(newBook);
	}
}
