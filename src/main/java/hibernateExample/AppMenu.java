package hibernateExample;

import java.util.Scanner;

import hibernateExample.Controller.BookController;
import hibernateExample.service.BookService;

public class AppMenu {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		BookController bookController = new BookController();
		Scanner sc = new Scanner(System.in);
		String option = "";
		
		while (option != "q") {
		
			System.out.println("Vytaj v kniznici");
			System.out.println("Pokracuj stlacenim Enter");
			System.out.println("a - Pre pridanie novej knihy ");
			System.out.println("b - Pre zmazanie knihy podla id ");
			System.out.println("c - Pre hladanie knihy podla id ");
			System.out.println("d - Update titulu podla id ");
			System.out.println("e - List vsetkych knih v databaze ");
			System.out.println("q - Pre ukoncenie programu ");
			option = sc.nextLine();
			switch (option) {
			case "a":
				bookController.add();
				break;
			case "b":
				System.out.println("Zadaj index na ktorom chcete odstranit knihu");
				bookController.deleteAtIndex(sc.nextLine());
				break;
			case "c":
				System.out.println("Zadaj id hladanej knihy");
				bookController.findById(sc.nextLine());
				break;
			case "d":
				System.out.println("Zadaj id knihy ktorej titul chces updatnut ");
				bookController.update(sc.nextLine());
				break;
			case "e":
				System.out.println("List vsetkych knih");
				bookController.findAll();
				break;
			case "q":
				option ="q";
			default:
				break;
			}
		}
	}

}
