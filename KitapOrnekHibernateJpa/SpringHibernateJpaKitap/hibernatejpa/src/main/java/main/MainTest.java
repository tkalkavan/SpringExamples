 package main;

import java.util.List;

import model.Kitap;
import service.KitapServis;

public class MainTest {

	public static void main(String[] args) {
		KitapServis bookService = new KitapServis();
		Kitap book1 = new Kitap("The Brothers Karamazov", "Fyodor Dostoevsky");
		Kitap book2 = new Kitap("War and Peace", "Leo Tolstoy");
		Kitap book3 = new Kitap("Pride and Prejudice", "Jane Austen");
		
		
		System.out.println("*** Persist - start ***");
		bookService.persist(book1);
		bookService.persist(book2);
		bookService.persist(book3);
		
		List<Kitap> books1 = bookService.findAll();
		System.out.println("Kitaps Persisted are :");
		for (Kitap b : books1) {
			System.out.println("-" + b.toString());
		}
		System.out.println("*** Persist - end ***");
		System.out.println("*** Update - start ***");
		book1.setBaslik("The Idiot");
		bookService.update(book1);
		System.out.println("Kitap Updated is =>" +bookService.findById(book1.getId()).toString());
		System.out.println("*** Update - end ***");
		System.out.println("*** Find - start ***");
		int id1 = book1.getId();
		
		Kitap another = bookService.findById(id1);
		System.out.println("Kitap found with id " + id1 + " is =>" + another.toString());
		System.out.println("*** Find - end ***");
		System.out.println("*** Delete - start ***");
		int id3 = book3.getId();
		bookService.delete(id3);
		System.out.println("Deleted book with id " + id3 + ".");
		System.out.println("Now all books are " + bookService.findAll().size() + ".");
		System.out.println("*** Delete - end ***");
		System.out.println("*** FindAll - start ***");
		List<Kitap> books2 = bookService.findAll();
		System.out.println("Kitaps found are :");
		for (Kitap b : books2) {
			System.out.println("-" + b.toString());
		}
		System.out.println("*** FindAll - end ***");
		System.out.println("*** DeleteAll - start ***");
		bookService.deleteAll();
		System.out.println("Kitaps found are now " + bookService.findAll().size());
		System.out.println("*** DeleteAll - end ***");
		 System.exit(0);
	}
}