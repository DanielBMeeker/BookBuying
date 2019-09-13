//This start program shell was adapted from the Java II lab ConsoleShoppingList
//provided by Kelli Kleindorfer
import java.util.List;
import java.util.Scanner;

import controller.BookBuyingLogic;
import model.Book;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static BookBuyingLogic bbl = new BookBuyingLogic();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a title: ");
		String title = in.nextLine().toUpperCase();
		System.out.print("Enter an author: ");
		String author = in.nextLine().toUpperCase();
		System.out.println("Enter an ISBN: ");
		String ISBN = in.nextLine();
		//Not every book has an ISBN number, especially when dealing with old/antique books
		//therefore this program does not validate ISBN numbers
		System.out.println("How much will you sell the book for?");
		double salePrice = in.nextDouble();
		if (salePrice < 0)
		{
			salePrice = salePrice * -1;
			//if the sale price is accidentally entered as a negative number the program
			//assumes it was meant to be a positive number - this is still an early build
			//of the program so more intricate validation may be required in a later build
		}
		System.out.println("How long does it usually take to sell? (rounded to the nearest day)");
		int avgDaysToSell = in.nextInt();
		if (avgDaysToSell < 0)
		{
			avgDaysToSell = avgDaysToSell * -1;
			//if the average days to sell is accidentally entered as a negative number the program
			//assumes it was meant to be a positive number - this is still an early build
			//of the program so more intricate validation may be required in a later build
		}
		Book toAdd = new Book(title, author, ISBN, salePrice, avgDaysToSell);
		bbl.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title to delete: ");
		String title = in.nextLine().toUpperCase();
		System.out.print("Enter the author to delete: ");
		String author = in.nextLine().toUpperCase();
		Book toDelete = new Book(title, author);
		bbl.deleteItem(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Title");
		System.out.println("2 : Search by Author");
		int searchBy = in.nextInt();
		in.nextLine();

		List<Book> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the title: ");
			String title = in.nextLine().toUpperCase();
			foundItems = bbl.searchForItemByTitle(title);
		} else {
			System.out.print("Enter the author: ");
			String author = in.nextLine().toUpperCase();
			foundItems = bbl.searchForItemByAuthor(author);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Book l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Book toEdit = bbl.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getTitle() + " by " + toEdit.getAuthor());
			System.out.println("1 : Update Title");
			System.out.println("2 : Update Author");
			System.out.println("3 : Update ISBN");
			System.out.println("4 : Update Sale Price");
			System.out.println("5 : Update Average Days to Sell");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Title: ");
				String title = in.nextLine().toUpperCase();
				toEdit.setTitle(title);
			} else if (update == 2) {
				System.out.print("New Author: ");
				String author = in.nextLine().toUpperCase();
				toEdit.setAuthor(author);
			} else if (update == 3) {
				System.out.println("New ISBN: ");
				String ISBN = in.nextLine();
				toEdit.setISBN(ISBN);
			} else if (update == 4) {
				System.out.println("New Sale Price: ");
				double salePrice = in.nextDouble();
				if (salePrice < 0)
				{
					salePrice = salePrice * -1;
				}
				toEdit.setSalePrice(salePrice);
			} else if (update == 5) {
				System.out.println("New Average Days to Sell: ");
				int avgDaysToSell = in.nextInt();
				if (avgDaysToSell < 0)
				{
					avgDaysToSell = avgDaysToSell * -1;
				}
				toEdit.setAvgDaysToSell(avgDaysToSell);
				toEdit.getPercentPaid();
			}

			bbl.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to Book Buying ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else {
				bbl.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

}