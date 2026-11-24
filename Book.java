public class Book {
	// instance variables
	private String title;
	private String author;
	private int yearPublished;
	public boolean isCheckedOut;
	
	// static variables
	private static int totalBooksCreated = 0;
	
	// constructor
	public Book(String title, String author, int yearPublished) {
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
		isCheckedOut = false;
		totalBooksCreated++;
	}
	
	// getters (why cant you have one line methods in java)
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public int getYear() { return yearPublished; }
	public boolean getCheckedOut() { return isCheckedOut; }
	public static int getTotalBooksCreated() { return totalBooksCreated; }
	
	// instance methods
	
	public void printInfo() {
		System.out.println("Title: " + getTitle());
		System.out.println("Author: " + getAuthor());
		System.out.println("Year published: " + getYear());
		System.out.println("Checked out: " + getCheckedOut());
	}
	
	public void checkOut() {
		if (getCheckedOut() == false) isCheckedOut = true;
		else System.out.println("sorry someone else is using this book (this library only has one copy of each book we're low on funding ok)");
	}
	
	public void returnBook() {
		if (getCheckedOut() == true) isCheckedOut = false;
		else System.out.println("you dont have that book dumbass");
	}
	
	public boolean isAvailable() { return !getCheckedOut(); }
	
	// static methods
	
	public static boolean isValidYear(int y) { return (0 < y && y <= 2026); }
	
	public static void printBookCount() { System.out.println(Book.getTotalBooksCreated()); }
	
	public static void dontWorryAboutIt(String s, boolean last) throws InterruptedException {
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
			System.out.flush();
			Thread.sleep(last ? 33 : 66);
		}
	}
	
	public static void comparePublicationYears(Book b1, Book b2) throws InterruptedException {
		if (b1.getYear() > b2.getYear()) System.out.println(b2.getTitle() + " <- old ass book");
		else if (b1.getYear() < b2.getYear()) System.out.println(b1.getTitle() + " <- old ass book");
		else { // i was bored ok
			Thread.sleep(2000);
			System.out.print("\033[2J\n\n\n\n");
			Book.dontWorryAboutIt("YOUR WONDERFUL", false);
			Thread.sleep(1000);
			Book.dontWorryAboutIt("\nBOOKS", false);
			Thread.sleep(1500);
			System.out.print("\033[2J\n\n\n\n");
			Thread.sleep(1000);
			Book.dontWorryAboutIt("Have an equal", false);
			Thread.sleep(500);
			Book.dontWorryAboutIt("\npublication date.", false);
			Thread.sleep(1500);
			System.out.print("\033[2J\n\n\n\n");
			Book.dontWorryAboutIt("No one can choose\nto compare publication dates\nin this world.", true);
			Thread.sleep(1000);
			System.out.print("\033[2J\n\n\n\n");
		}
	}
	
	public static void printLibraryStatistics() { System.out.println(getTotalBooksCreated()); }
}

class LibraryTest {
	public static void main(String[] args) throws InterruptedException {
		Book book1 = new Book("Real Analysis", "N. L. Carothers", 2000);
		Book book2 = new Book("\u001B[34m" + "House" + "\u001B[0m" + " of Leaves", "Mark Z. Danielewski", 2000);
		Book book3 = new Book("English as She Is Spoke", "Jose de Fonseca", 1855);
		Book book4 = new Book("The 2009-2014 World Outlook for 60-Milligram Containers of Fromage Frais", "Phillip M. Parker", 2008);
		book1.printInfo();
		book2.printInfo();
		book3.printInfo();
		book4.printInfo();
		System.out.println("total books created: " + Book.getTotalBooksCreated());
		book2.checkOut();
		book4.checkOut();
		book2.checkOut();
		book4.returnBook();
		System.out.println(book1.isAvailable());
		System.out.println(book2.isAvailable());
		System.out.println(book3.isAvailable());
		System.out.println(book4.isAvailable());
		System.out.println(Book.isValidYear(7777));
		Book.comparePublicationYears(book1, book2);
		System.out.println("total books created: " + Book.getTotalBooksCreated());
	}
}
