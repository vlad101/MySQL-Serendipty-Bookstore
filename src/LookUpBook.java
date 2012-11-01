import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LookUpBook {
	
	static Scanner keyboard = new Scanner(System.in);
	
	static BookInfo bookinfo = new BookInfo();
	static MainMenu mainmenu = new MainMenu();
	
	static String connectionUser = "root";
	static String connectionPassword = "password";
	static String connectionUrl = "jdbc:mysql://localhost:3306/serendipity";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	
	static int k = 0;
	static String title;
	static String isbn;
	static String author;
	static String publisher;
	static String id;
	static int count = 0;
	static int bookNum;
	static boolean b;
	
	public static Connection getConnection(){
				
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();	//Class.forName("myDriver.ClassName"); ?

		} 		
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 

		try {
			
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		return conn;
		
	}
	
	public static int searchTitle() {
		
		try {
			
			System.out.println("+---------------------------+");
			System.out.println("|  Search by the Book Title |");
			System.out.println("+---------------------------+\n");			
			
			System.out.print("Enter Book Title: ");
			title = mainmenu.validateString(keyboard.nextLine());
			title = "%" + title + "%";
			System.out.println();

			conn = bookinfo.getConnection();
			
			String test = "SELECT * FROM books WHERE title LIKE ?";
			pstmt = conn.prepareStatement(test);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			System.out.println("+-----------------------+");
			System.out.println(" Search results:");
			System.out.println("+-----------------------+");
			
			count = 0;
			
			while (rs.next()) {
				
				int book_id = rs.getInt("book_id");
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String dateAdded = rs.getString("dateAdded");
				int qtyOnHand = rs.getInt("qtyOnHand");
				double wholesale = rs.getDouble("wholesale");
				double retail = rs.getDouble("retail");
				
				System.out.println("+------------------------------------------+");
				System.out.printf("|  Book # %d                               |\n", book_id);
				System.out.println("+------------------------------------------+");
				System.out.println("\tISBN: " + isbn);
				System.out.println("\tTitle: " + title);
				System.out.println("\tAuthor: " + author);
				System.out.println("\tPublisher: " + publisher);
				System.out.println("\tDate Added: " + dateAdded);
				System.out.println("\tQuantity-On-Hand: " + qtyOnHand);
				System.out.printf("\tWholesale Cost: $ %6.2f\n", wholesale);
				System.out.printf("\tRetail Cost: $ %6.2f\n", retail);
				System.out.println("+------------------------------------------+\n");
				
				count++;
				
			}
			
			System.out.println(count + " books retrieved");
			
			System.out.println("+-----------------------+");
			System.out.println(" Search completed!");
			System.out.println("+-----------------------+");
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		finally {
			
			try { 
				
				if (rs != null){ 
					
					rs.close(); 
				
				}
				
			} 
			
			catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
			try { 
				
				if (conn != null){ 
					
					conn.close(); 
					
				}
				
			} catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
		}
		
		return count;
	
	}
	
	public static int searchIsbn() {
		
		try {
			
			System.out.println("+---------------------------+");
			System.out.println("|  Search by the Book ISBN  |");
			System.out.println("+---------------------------+\n");			
			
			System.out.print("Enter Book ISBN: ");
			isbn = "%" + mainmenu.validateString(keyboard.nextLine()) + "%";
			System.out.println();

			conn = bookinfo.getConnection();
			
			String test = "SELECT * FROM books WHERE isbn LIKE ?";
			pstmt = conn.prepareStatement(test);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			
			System.out.println("+-----------------------+");
			System.out.println(" Search results:");
			System.out.println("+-----------------------+");
			
			while (rs.next()) {
				
				int book_id = rs.getInt("book_id");
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String dateAdded = rs.getString("dateAdded");
				int qtyOnHand = rs.getInt("qtyOnHand");
				double wholesale = rs.getDouble("wholesale");
				double retail = rs.getDouble("retail");
				
				System.out.println("+------------------------------------------+");
				System.out.printf("|  Book # %d                               |\n", book_id);
				System.out.println("+------------------------------------------+");
				System.out.println("\tISBN: " + isbn);
				System.out.println("\tTitle: " + title);
				System.out.println("\tAuthor: " + author);
				System.out.println("\tPublisher: " + publisher);
				System.out.println("\tDate Added: " + dateAdded);
				System.out.println("\tQuantity-On-Hand: " + qtyOnHand);
				System.out.printf("\tWholesale Cost: $ %6.2f\n", wholesale);
				System.out.printf("\tRetail Cost: $ %6.2f\n", retail);
				System.out.println("+------------------------------------------+\n");
				
				count++;
				
			}
			
			System.out.println(count + " books retrieved");
			
			System.out.println("+-----------------------+");
			System.out.println(" Search completed!");
			System.out.println("+-----------------------+");
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		finally {
			
			try { 
				
				if (rs != null){ 
					
					rs.close(); 
				
				}
				
			} 
			
			catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
			try { 
				
				if (conn != null){ 
					
					conn.close(); 
					
				}
				
			} catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
		}
		
		return count;
	
	}
	
	public static int searchAuthor() {
		
		try {
			
			System.out.println("+-----------------------------+");
			System.out.println("|  Search by the Book Author  |");
			System.out.println("+-----------------------------+\n");			
			
			System.out.print("Enter Book Author: ");
			author = "%" + mainmenu.validateString(keyboard.nextLine()) + "%";
			System.out.println();

			conn = bookinfo.getConnection();
			
			String test = "SELECT * FROM books WHERE author LIKE ?";
			pstmt = conn.prepareStatement(test);
			pstmt.setString(1, author);
			rs = pstmt.executeQuery();
			
			System.out.println("+-----------------------+");
			System.out.println(" Search results:");
			System.out.println("+-----------------------+");
			
			while (rs.next()) {
				
				int book_id = rs.getInt("book_id");
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String dateAdded = rs.getString("dateAdded");
				int qtyOnHand = rs.getInt("qtyOnHand");
				double wholesale = rs.getDouble("wholesale");
				double retail = rs.getDouble("retail");
				
				System.out.println("+------------------------------------------+");
				System.out.printf("|  Book # %d                               |\n", book_id);
				System.out.println("+------------------------------------------+");
				System.out.println("\tISBN: " + isbn);
				System.out.println("\tTitle: " + title);
				System.out.println("\tAuthor: " + author);
				System.out.println("\tPublisher: " + publisher);
				System.out.println("\tDate Added: " + dateAdded);
				System.out.println("\tQuantity-On-Hand: " + qtyOnHand);
				System.out.printf("\tWholesale Cost: $ %6.2f\n", wholesale);
				System.out.printf("\tRetail Cost: $ %6.2f\n", retail);
				System.out.println("+------------------------------------------+\n");
				
				count++;
				
			}
			
			System.out.println(count + " books retrieved");
			
			System.out.println("+-----------------------+");
			System.out.println(" Search completed!");
			System.out.println("+-----------------------+");
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		finally {
			
			try { 
				
				if (rs != null){ 
					
					rs.close(); 
				
				}
				
			} 
			
			catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
			try { 
				
				if (conn != null){ 
					
					conn.close(); 
					
				}
				
			} catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
		}
		
		return count;
	
	}
	
	public static int searchPublisher() {
		
		try {
			
			System.out.println("+-------------------------------+");
			System.out.println("|  Search by the Book Publisher |");
			System.out.println("+-------------------------------+\n");			
			
			System.out.print("Enter Book Publisher: ");
			publisher = "%" + mainmenu.validateString(keyboard.nextLine()) + "%";
			System.out.println();

			conn = bookinfo.getConnection();
			
			String test = "SELECT * FROM books WHERE publisher LIKE ?";
			pstmt = conn.prepareStatement(test);
			pstmt.setString(1, publisher);
			rs = pstmt.executeQuery();
			
			System.out.println("+-----------------------+");
			System.out.println(" Search results:");
			System.out.println("+-----------------------+");
			
			while (rs.next()) {
				
				int book_id = rs.getInt("book_id");
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String dateAdded = rs.getString("dateAdded");
				int qtyOnHand = rs.getInt("qtyOnHand");
				double wholesale = rs.getDouble("wholesale");
				double retail = rs.getDouble("retail");
				
				System.out.println("+------------------------------------------+");
				System.out.printf("|  Book # %d                               |\n", book_id);
				System.out.println("+------------------------------------------+");
				System.out.println("\tISBN: " + isbn);
				System.out.println("\tTitle: " + title);
				System.out.println("\tAuthor: " + author);
				System.out.println("\tPublisher: " + publisher);
				System.out.println("\tDate Added: " + dateAdded);
				System.out.println("\tQuantity-On-Hand: " + qtyOnHand);
				System.out.printf("\tWholesale Cost: $ %6.2f\n", wholesale);
				System.out.printf("\tRetail Cost: $ %6.2f\n", retail);
				System.out.println("+------------------------------------------+\n");
				
				count++;
				
			}
			
			System.out.println(count + " books retrieved");
			
			System.out.println("+-----------------------+");
			System.out.println(" Search completed!");
			System.out.println("+-----------------------+");
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		finally {
			
			try { 
				
				if (rs != null){ 
					
					rs.close(); 
				
				}
				
			} 
			
			catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
			try { 
				
				if (conn != null){ 
					
					conn.close(); 
					
				}
				
			} catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
		}
		
		return count;
	
	}
	
	public static int searchId() {
		
		try {			

			conn = bookinfo.getConnection();
			
			do{
				
				do{
					
					System.out.print("Enter the Book ID # to be edited: ");
					id = mainmenu.validateString(keyboard.next());
					
					System.out.println();
				
					b = true;
						
					try {
						
						bookNum = Integer.parseInt(id);
						
						while(!b){
							
					    	System.out.println("--------------------------------");
							System.out.println(" !   Wrong Value. Try again   !");
							System.out.println("--------------------------------\n");
							
							System.out.print("Enter the Book # to be edited: ");
							id = mainmenu.validateString(keyboard.next());
							
							System.out.println();
							
							bookNum = Integer.parseInt(id);
							
						}
						
					}
						
					catch(NumberFormatException nFE) {
						
						b = false;
				    	System.out.println("--------------------------------");
						System.out.println(" !   Wrong Value. Try again   !");
						System.out.println("--------------------------------\n");
						
					}
							
				}while(b == false);
			
				String test = "SELECT * FROM books WHERE book_id = ?";
				pstmt = conn.prepareStatement(test);
				pstmt.setInt(1, bookNum);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					
					int book_id = rs.getInt("book_id");
					String isbn = rs.getString("isbn");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");
					String dateAdded = rs.getString("dateAdded");
					int qtyOnHand = rs.getInt("qtyOnHand");
					double wholesale = rs.getDouble("wholesale");
					double retail = rs.getDouble("retail");
					
					System.out.println("+------------------------------------------+");
					System.out.printf("|  Book # %d                               |\n", book_id);
					System.out.println("+------------------------------------------+");
					System.out.println("\tISBN: " + isbn);
					System.out.println("\tTitle: " + title);
					System.out.println("\tAuthor: " + author);
					System.out.println("\tPublisher: " + publisher);
					System.out.println("\tDate Added: " + dateAdded);
					System.out.println("\tQuantity-On-Hand: " + qtyOnHand);
					System.out.printf("\tWholesale Cost: $ %6.2f\n", wholesale);
					System.out.printf("\tRetail Cost: $ %6.2f\n", retail);
					System.out.println("+------------------------------------------+\n");
					
					count++;
					break;
					
				}
				
				while(count == 0){
					
			    	System.out.println("--------------------------------");
					System.out.println(" !   Wrong Value. Try again   !");
					System.out.println("--------------------------------\n");
					
					searchId();
					break;
				}
					
			   	System.out.println("--------------------------------");
				System.out.println(" !   Wrong Value. Try again   !");
				System.out.println("--------------------------------\n");
					
			}while (!rs.next());
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		finally {
			
			try { 
				
				if (rs != null){ 
					
					rs.close(); 
				
				}
				
			} 
			
			catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
			try { 
				
				if (conn != null){ 
					
					conn.close(); 
					
				}
				
			} catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
			
		}
		
		return bookNum;
	
	}
	
	public static void lookUpBook(){
		
		System.out.println("+-----------------------------+");
		System.out.println("| You Selected Look Up a Book |");
		System.out.println("+-----------------------------+\n");
		
		System.out.println("+---------------------------------------+");
		System.out.println("| Search for a book by:                 |");
		System.out.println("|  1. Book Title                        |");
		System.out.println("|  2. ISBN Number                       |");
		System.out.println("|  3. Author's Name                     |");
		System.out.println("|  4. Publisher's Name                  |");
		System.out.println("|  5. Return to the Inventory Database  |");
		System.out.println("+---------------------------------------+\n");
		
		k = 0;
		
		while(k != 5){
			
			k = mainmenu.validateMenuChoice();
				
			if(k == 1){
				
				count = 0;
				
				count = searchTitle();
				
				while(count == 0){
					
					System.out.println("+-----------------------------+");
					System.out.println("| No Results Found. Try Again!|");
					System.out.println("+-----------------------------+\n");
					
					lookUpBook();
					
					break;
					
				}
	
			}
			
			else if(k == 2){
				
				count = 0;
				
				count = searchIsbn();
				
				while(count == 0){
					
					System.out.println("+-----------------------------+");
					System.out.println("| No Results Found. Try Again!|");
					System.out.println("+-----------------------------+\n");
					
					lookUpBook();
					
					break;
					
				}
				
			}		
				
			else if(k == 3){
				
				count = 0;
				
				count = searchAuthor();
				
				while(count == 0){
					
					System.out.println("+-----------------------------+");
					System.out.println("| No Results Found. Try Again!|");
					System.out.println("+-----------------------------+\n");
					
					lookUpBook();
					
					break;
					
				}
				
			}
				
			else if(k == 4){
				
				count = 0;
	
				count = searchPublisher();
				
				while(count == 0){
					
					System.out.println("+-----------------------------+");
					System.out.println("| No Results Found. Try Again!|");
					System.out.println("+-----------------------------+\n");
					
					lookUpBook();
					
					break;
					
				}
				
			}
			
			else if(k == 5){
				
				System.out.println("+--------------------------------------+");
				System.out.println("| Returning to the Inventory Database  |");
				System.out.println("+--------------------------------------+\n");
				break;
				
			}
			
			System.out.println("+---------------------------------------+");
			System.out.println("| Search for a book by:                 |");
			System.out.println("|  1. Book Title                        |");
			System.out.println("|  2. ISBN Number                       |");
			System.out.println("|  3. Author's Name                     |");
			System.out.println("|  4. Publisher's Name                  |");
			System.out.println("|  5. Return to the Inventory Database  |");
			System.out.println("+---------------------------------------+\n");
				
		}
		
	}
	
}
