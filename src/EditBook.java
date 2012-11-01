import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EditBook {
	
	static Scanner keyboard = new Scanner(System.in);
	
	static BookInfo bookinfo = new BookInfo();
	static MainMenu mainmenu = new MainMenu();
	static LookUpBook lookupbook = new LookUpBook();
	
	static String connectionUser = "root";
	static String connectionPassword = "password";
	static String connectionUrl = "jdbc:mysql://localhost:3306/serendipity";
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	
	static int k = 0;
	static String test;
	static String title;
	static String isbn;
	static String author;
	static String publisher;
	static String dateAdded;
	static String qtyOnHand;
	static String wholesale;
	static String retail;
	static int count = 0;
	static int val;
	static boolean quit = false;
	static boolean choiceIsOK = false;
	static boolean found;
	static boolean b;
	static int x = 0;
	static double y = 0;
	static double z = 0;
	static int bookNum = 0;
	static String choice;
	
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

	
	public static void editBook(){
		
		try {

			conn = bookinfo.getConnection();
			
			System.out.println("+----------------+");
			System.out.println("|  Edit Book     |");
			System.out.println("+----------------+\n");
			
			do{
				
				do{
					
					count = lookupbook.searchTitle();
					
					if(count == 0){
						
						System.out.println("+-----------------------------+");
						System.out.printf("There are %d exact items found!\n", count);
						System.out.println("+-----------------------------+\n");
						
					}
				
				}while(count == 0);
				
				bookNum = lookupbook.searchId();
				
				System.out.println("You selected the book with ID#: " + bookNum);
				
				System.out.println("+---------------------------------------------------+");
				System.out.println("| Select the field that you wish to change:         |");
				System.out.println("|                                                   |");
				System.out.println("|  1. ISBN Number                                   |");
				System.out.println("|  2. Book Title                                    |");
				System.out.println("|  3. Author's Name                                 |");
				System.out.println("|  4. Publisher's Name                              |");
				System.out.println("|  5. The Date the book is Added to the inventory   |");
				System.out.println("|  6. The Quantity of The Book Being Added          |");
				System.out.println("|  7. The wholesale cost of the Book                |");
				System.out.println("|  8. The Retail Price of The Book                  |");
				System.out.println("|                                                   |");
				System.out.println("+---------------------------------------------------+\n");
				
				x = mainmenu.validateMenuChoice();
				
				b = true;
				
				while(b){
					
					if(x == 1){
						
						System.out.println("+---------------------+");
						System.out.println("| Edit ISBN Number    |");
						System.out.println("+---------------------+\n");
						
						System.out.print("\nEnter ISBN Number: "); 
						isbn  =  mainmenu.validateString(keyboard.next());
						
						test = "UPDATE books SET isbn=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setString(1, isbn);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();
						
						b = false;
						
					}
					
					else if(x == 2){
					
						System.out.println("+---------------------------+");
						System.out.println("|  Edit Book Title          |");
						System.out.println("+---------------------------+\n");
						
						System.out.print("\nEnter Book Title: "); 
						title  =  mainmenu.validateString(keyboard.next());
						
						test = "UPDATE books SET title=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setString(1, title);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();
						
						b = false;
					
					}
					
					else if(x == 3){			
	
						System.out.println("+-----------------------+");
						System.out.println("| Edit Author's Name    |");
						System.out.println("+-----------------------+\n");
						
						System.out.print("\nEnter Author's Name: "); 
						author  =  mainmenu.validateString(keyboard.next());
						
						test = "UPDATE books SET author=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setString(1, author);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();
						
						b = false;
					
					}
					
					else if(x == 4){
						
						System.out.println();
						System.out.println("+---------------------------+");
						System.out.println("|  Edit Publisher's Name    |");
						System.out.println("+---------------------------+\n");
						System.out.println();
						
						System.out.print("\nEnter Publisher's Name: "); 
						publisher  =  mainmenu.validateString(keyboard.next());
						
						test = "UPDATE books SET publisher=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setString(1, publisher);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();
						
						b = false;
						
					}
					
					else if(x == 5){
						
						System.out.println("+--------------------------------------------------------------------+");
						System.out.println("|  Edit The Date The Book is Added to the Inventory Database Module  |");
						System.out.println("+--------------------------------------------------------------------+\n");
							
						System.out.print("\nEnter The Date The Book is Added to the Inventory Database Module: "); 
						dateAdded  =  mainmenu.validateString(keyboard.next());
						
						test = "UPDATE books SET dateAdded=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setString(1, dateAdded);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();;
						
						b = false;
						
					}
					
					else if(x == 6){
						
						System.out.println("+---------------------------------------------+");
						System.out.println("| Edit the Quantity of the Book Being Added   |");
						System.out.println("+---------------------------------------------+\n");
						
						do{
							
							b = true;
							System.out.print("\nEnter The Quantity of Book Being Added: ");
							qtyOnHand  =  mainmenu.validateString(keyboard.next());
								
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
						
						test = "UPDATE books SET qtyOnHand=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setInt(1, x);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();
						
						b = false;
						
					}
					
					else if(x == 7){
						
						System.out.println("+-----------------------------------------+");
						System.out.println("|  Edit The wholesale Cost of the Book    |");
						System.out.println("+-----------------------------------------+\n");
						
						do{
							
							b = true;
							System.out.print("\nEnter The Wholesale Cost of the Book: ");
							wholesale  =  mainmenu.validateString(keyboard.next());
								
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
						
						test = "UPDATE books SET wholesale=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setDouble(1, y);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();
						
						b = false;
						
					}
					
					else if(x == 8){
						
						System.out.println("+------------------------------------+");
						System.out.println("|  Edit The Retail Price of the Book |");
						System.out.println("+------------------------------------+\n");
						
						do{
							
							b = true;
							System.out.print("\nEnter The Retail Price of the Book: ");
							retail  =  mainmenu.validateString(keyboard.next());
								
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
						
						test = "UPDATE books SET retail=? WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setDouble(1, z);
						pstmt.setInt(2, bookNum);
						val = pstmt.executeUpdate();
						
						b = false;
						
					}
					
					else{
						
				    	System.out.println("--------------------------------");
						System.out.println(" !   Wrong Value. Try again   !");
						System.out.println("--------------------------------\n");
						b = true;
					
					}
					
				}
				
				System.out.println("You Made the Following Changes!\n");
				test = "SELECT * FROM books WHERE book_id = ?";
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
					
				}
				
				System.out.println("+-------------------------------+");
				System.out.print("Do You Want to Continue? (Y/N) ");
				
			    boolean choiceIsOK = false;
			    
			    do{
				    
			    	String userInput =  mainmenu.validateString(keyboard.next());
					System.out.println();
					
				    char choice = userInput.toLowerCase().charAt(0);
					   
				    if(choice == 'y'){
	
						System.out.println("+----------------------------------------+");
						System.out.println("|  Your Changes have Been Saved!         |");
						System.out.println("+----------------------------------------+\n");
				    	choiceIsOK = true;
				    	
					    	
				    }
					    
				    else if(choice == 'n'){
				    	
						System.out.println("+----------------------------------------+");
						System.out.println("|  Your Changes have Been Saved!         |");
						System.out.println("+----------------------------------------+\n");
				    	choiceIsOK = false;
				        quit = true;
				        break;
					    	
				    }
					    
				    else{
					    	
						System.out.println("--------------------------------");
						System.out.println(" !   Wrong Value. Try again   !");
						System.out.println("--------------------------------\n");
						
				    	System.out.println("+-------------------------------------------+");
				        System.out.println("Type Y or N to respectively continue or quit");
				        System.out.print("Do You Want to Continue? (Y/N) ");
					    
				    }
				    System.out.println();
					    
			   	}while(!choiceIsOK);
				    
			}while (!quit);
			
		}
			
		catch (Exception e) {
				
			e.printStackTrace();
				
		} 
			
		finally {
			
			try { 
				
				if(rs != null){
						
					rs.close(); 
						
				}
						
			} 
				
			catch (SQLException e) { 
					
				e.printStackTrace(); 
					
			}
				
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
		
	}
	
}