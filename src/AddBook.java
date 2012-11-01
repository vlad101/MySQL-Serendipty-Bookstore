import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class AddBook {
	
	static Scanner keyboard = new Scanner(System.in);
	static InvMenu invmenu = new InvMenu();
	static MainMenu mainmenu = new MainMenu();
	static BookInfo bookinfo = new BookInfo();
	
	static boolean b = true;
	static int x;
	static double y;
	static double z;
	static String choice;
	static char letter;
	static String isbn;
	static String title;
	static String publisher;
	static String todaytest;
	static String author;
	static String qtyOnHand;
	static String wholesale;
	static String retail;
	
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	
	public static void addBook(){
		
		System.out.println("+----------------+");
		System.out.println("| Add a Book     |");
		System.out.println("+----------------+\n");
		
		try {

			conn = bookinfo.getConnection();
			stmt = conn.createStatement();
			
			System.out.print("Enter ISBN number: "); 
			isbn =  mainmenu.validateString(keyboard.next());
			
			System.out.print("Enter Book Title: "); 
			title =  mainmenu.validateString(keyboard.next());
			
			System.out.print("Enter Author's name: "); 
			author =  mainmenu.validateString(keyboard.next());
			
			System.out.print("Enter Publisher's name: "); 
			publisher =  mainmenu.validateString(keyboard.next());
			
			
			DateFormat formattertest = new SimpleDateFormat("MM/dd/yyyy");
			Date datetest = Calendar.getInstance().getTime();
			todaytest = formattertest.format(datetest);
			
			do{
				
				b = true;
				System.out.print("Enter The Quantity of Book Being Added: ");
				qtyOnHand = mainmenu.validateString(keyboard.next());
				
				try {
					
					x = Integer.parseInt(qtyOnHand);
					
				}
				
				catch(NumberFormatException nFE) {
					
					b = false;
					System.out.println("--------------------------------");
					System.out.println(" !   Wrong Value. Try again   !");
					System.out.println("--------------------------------\n");
					
				}
					
			}while(b == false);

			do{
				
				b = true;
				System.out.print("Enter The Wholesale Cost of the Book: ");
				wholesale = mainmenu.validateString(keyboard.next());
				
				try {
					
					y = Double.parseDouble(wholesale);
					
				}
				
				catch(NumberFormatException nFE) {
					
					b = false;
					System.out.println("--------------------------------");
					System.out.println(" !   Wrong Value. Try again   !");
					System.out.println("--------------------------------\n");
					
				}
					
			}while(b == false);
			
			do{
				
				b = true;
				System.out.print("Enter The Retail Price of the Book: ");
				retail = mainmenu.validateString(keyboard.next());
				
				try {
					
					z = Double.parseDouble(retail);
					
				}
				
				catch(NumberFormatException nFE) {
					
					b = false;
					System.out.println("--------------------------------");
					System.out.println(" !   Wrong Value. Try again   !");
					System.out.println("--------------------------------\n");
					
				}
					
			}while(b == false);
			
		}
		
		catch (Exception e) {
					
			e.printStackTrace();
					
		} 
				
		finally {
					
			try { 
						
				if (pstmt != null) {
				
					pstmt.close(); 
				
				}
			} 
					
			catch (SQLException e) { 
						
				e.printStackTrace(); 
						
			}
					
			try { 
						
				if (stmt != null){
					
					stmt.close(); 
				
				}		
			} 
					
			catch (SQLException e) { 
						
				e.printStackTrace(); 
						
			}
					
		}
		
		printAddedBookInfo();
		
	}
			
	public static void printAddedBookInfo(){
	
		try{
			
			String query = "INSERT INTO books(book_id, isbn, title, author, publisher, dateAdded, qtyOnHand, wholesale, retail) VALUES (?,?,?,?,?,?,?,?,?)";
			Connection conn = bookinfo.getConnection();
			pstmt = conn.prepareStatement(query);
			
		    // create PrepareStatement object
		    pstmt = conn.prepareStatement(query);
		    pstmt.setNull(1, java.sql.Types.INTEGER);
		    pstmt.setString(2, isbn);
		    pstmt.setString(3, title);
		    pstmt.setString(4, author);
		    pstmt.setString(5, publisher);
		    pstmt.setString(6, todaytest);
		    pstmt.setInt(7, x);
		    pstmt.setDouble(8, y);
		    pstmt.setDouble(9, z);

		    // execute query, and return number of rows created
		    int rowCount = pstmt.executeUpdate();
		    System.out.println("rowCount=" + rowCount);
			
			System.out.println("-------------------------------------------");
			System.out.println("ISBN number: " + isbn);
			System.out.println("Book Title: " + title);
			System.out.println("Author's name: " + author);
			System.out.println("Publisher's name: " + publisher);
			System.out.println("The Date the Book is Added to the Inventory (MM/DD/YYYY): " + todaytest);
			System.out.println("The Quantity of Book Being Added: " + x);
			System.out.printf("The Wholesale Cost of the Book: $ %6.2f\n", y);
			System.out.printf("The Retail Price of the Book: $ %6.2f\n", z);
			System.out.println("-------------------------------------------\n");
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		finally {
			
			try { 
				
				if(pstmt != null){
					
					pstmt.close(); 
					
				}
					
			} 
			
			catch (SQLException e) { 
				
				e.printStackTrace(); 
				
			}
				
			try { 
					
				if (conn != null){
					
					conn.close();
					
				}
					
			} 
				
			catch (SQLException e) { 
					
				e.printStackTrace(); 
					
			}
			
		}
		
		System.out.println("+------------------------------------+");
		System.out.println("| The Book is Added to the Inventory |");
		System.out.println("+------------------------------------+\n");	
		
	}
			
}