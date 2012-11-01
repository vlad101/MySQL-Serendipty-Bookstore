import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {
	
	static Scanner keyboard = new Scanner(System.in);
	
	static BookInfo bookinfo = new BookInfo();
	static MainMenu mainmenu = new MainMenu();
	static LookUpBook lookupbook = new LookUpBook();
	
	static Connection conn = null;
	static ResultSet rs = null;
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

	public static void deleteBook(){
		
		try {

			conn = bookinfo.getConnection();
			
			System.out.println("+------------------+");
			System.out.println("|  Delete Book     |");
			System.out.println("+------------------+\n");
			
			do{
				
				do{
					
					count = lookupbook.searchTitle();
					
					if(count == 0){
						
						System.out.println("+-----------------------------+");
						System.out.printf("There are %d books found!\n", count);
						System.out.println("+-----------------------------+\n");
						
					}
				
				}while(count == 0);
				
				bookNum = lookupbook.searchId();
				
				System.out.println("You selected the book with ID#: " + bookNum);
				
				
				System.out.println("+-------------------------------+");
				System.out.print("Are you sure you want to detele book's data from the inventory? (Y/N) ");
				
			    boolean choiceIsOK = false;
			    
			    do{
				    
			    	String userInput =  mainmenu.validateString(keyboard.next());
					System.out.println();
					
				    char choice = userInput.toLowerCase().charAt(0);
					   
				    if(choice == 'y'){
				    	
						test = "DELETE FROM books WHERE book_id = ?";
						pstmt = conn.prepareStatement(test);
						pstmt.setInt(1, bookNum);
						val = pstmt.executeUpdate();
				    	
						System.out.println("+------------------------------------------------+");
						System.out.println("| The Book's Data is Deleted From the Inventory  |");
						System.out.println("+------------------------------------------------+\n");
				    	choiceIsOK = false;
				        quit = true;
				        break;
				    	
				    	
					    	
				    }
					    
				    else if(choice == 'n'){
				    	
						System.out.println("+--------------------------------------+");
						System.out.println("| Returning to the Inventory Database  |");
						System.out.println("+--------------------------------------+\n");
				    	choiceIsOK = false;
				        quit = true;
				        break;
					    	
				    }
					    
				    else{
					    	
						System.out.println("--------------------------------");
						System.out.println(" !   Wrong Value. Try again   !");
						System.out.println("--------------------------------\n");
						
				    	System.out.println("+-------------------------------------------+");
				    	System.out.print("Are you sure you want to detele book's data from the inventory? (Y/N) ");
				        System.out.print("\nType Y or N to respectively delete or quit: ");
					    
				    }
					    
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