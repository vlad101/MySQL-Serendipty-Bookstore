import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookInfo {
	
	static String connectionUser = "root";
	static String connectionPassword = "password";
	static String connectionUrl = "jdbc:mysql://localhost:3306/serendipity";
	static Statement stmt = null;
	static Connection conn = null;
	static ResultSet rs = null;
	
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
	
	public static void bookInfo() {
		
		try {

			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS books " + "(book_id INT(3) AUTO_INCREMENT NOT NULL, isbn VARCHAR(15) NOT NULL, title VARCHAR(50) NOT NULL, author VARCHAR(50) NOT NULL, publisher VARCHAR(50) NOT NULL, dateAdded VARCHAR(10) NOT NULL, qtyOnHand INT(3) NOT NULL, wholesale DOUBLE NOT NULL, retail DOUBLE NOT NULL, PRIMARY KEY(book_id))");
			
			/*                                      !!! INSERTING DATE IN THE TABLE !!! [Run this commands only one time]
			 * 
			 * 	stmt.executeUpdate("INSERT INTO books(book_id, isbn, title, author, publisher, dateAdded, qtyOnHand, wholesale, retail)" + "VALUES (null, '978-0060014018', 'The Greatest Stories', 'Rick Beyer', 'HerperResource', '05/18/2003', 7, 12.99, 18.99)");
			 * 	stmt.executeUpdate("INSERT INTO books(book_id, isbn, title, author, publisher, dateAdded, qtyOnHand, wholesale, retail)" + "VALUES (null, '978-0449221431', 'The Novel', 'James A. Michener', 'Fawcett', '07/07/1992', 5, 3.84, 7.99)");
			 * 	stmt.executeUpdate("INSERT INTO books(book_id, isbn, title, author, publisher, dateAdded, qtyOnHand, wholesale, retail)" + "VALUES (null, '978-0545132060', 'Smile', 'Raina Telgemeier', 'Graphix', '02/01/2010', 10, 4.90, 6.09)");
			 * 	stmt.executeUpdate("INSERT INTO books(book_id, isbn, title, author, publisher, dateAdded, qtyOnHand, wholesale, retail)" + "VALUES (null, '978-0312474881', 'The Bedford Introduction to Drama', 'Lee A. Jacobus', 'Bedford St. Martins', '09/05/2008', 2, 14.99, 18.99)");
			 * 	stmt.executeUpdate("INSERT INTO books(book_id, isbn, title, author, publisher, dateAdded, qtyOnHand, wholesale, retail)" + "VALUES (null, '978-0547745527', 'AWOL on the Appalachian Trail', 'David Miller', 'Mariner Books', '11/01/2011', 8, 10.19, 16.99)");
			 * 
			 */
			
			System.out.println("\t\t\t\t\t****************************");
			System.out.println("\t\t\t\t\t*  Serendipity Booksellers *");
			System.out.println("\t\t\t\t\t*     Book Information     *");		
			System.out.println("\t\t\t\t\t****************************\n");
			
			rs = stmt.executeQuery("SELECT * FROM books");
			int count = 0;
			
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
			
			System.out.println(count + " books were retrieved");
			
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
				
				if (stmt != null){
					
					stmt.close(); 
					
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
	
	}
	
}