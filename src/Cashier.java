import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Cashier {
	
		static MainMenu mainmenu = new MainMenu();
		static String numBooks;
		
		static Connection conn = null;
		static ResultSet rs = null;
		static PreparedStatement pstmt = null;		
		
		static boolean b;
		static boolean quit = false;
		static int count = 0;
		static int isbn;
		static int title;
		static String st;
		static double sumSubTotal = 0;
		static double sumTax = 0;
		static double sumTotal = 0;
		
		static int [] qtyNum = new int[10];
		static String [] isbnNum = new String[10];
		static String [] titleNum = new String[10];
		static double [] priceNum = new double[10];
		static double [] subTotalNum = new double[10];
		static double [] totalNum = new double[10];
		static double [] taxNum = new double[10];
	
	public static void printCashier() {
		
		try{
			
				System.out.println("                          ********************************");
				System.out.println("                          *    Serendipity Booksellers   *");
				System.out.println("                          *        Cashier Module        *");		
				System.out.println("                          ********************************\n");			
			
			do{
	
				Scanner keyboard = new Scanner(System.in);
				

				
				DateFormat formatterDate = new SimpleDateFormat("EEE, dd MMMM yyyy");
				Date date = Calendar.getInstance().getTime();
				String today = formatterDate.format(date);
				
				
				DateFormat formatterTime = new SimpleDateFormat("hh:mm:ss a");
				Date time = Calendar.getInstance().getTime();
				String now = formatterTime.format(date);
				
				do{
					
					b = true;
					System.out.print("Quantity of Book: ");
					numBooks = mainmenu.validateString(keyboard.next());
					
					try {
						
						qtyNum[count] = Integer.parseInt(numBooks);
						
					}
					
					catch(NumberFormatException nFE) {
						
						b = false;
						System.out.println("--------------------------------"
+" !   Wrong Value. Try again   !");
						System.out.println("--------------------------------\n");
						
					}
						
				}while(b == false);
				
				System.out.print("ISBN: ");
				isbnNum[count] = mainmenu.validateString(keyboard.next());
				
				System.out.print("Title: ");
				titleNum[count] = mainmenu.validateString(keyboard.next());
				
				do{
					
					System.out.print("Price: ");
					String price = mainmenu.validateString(keyboard.next());
					
					b = true;
					try {
						
						priceNum[count] = Double.parseDouble(price);
						
					}
					
					catch(NumberFormatException nFE) {
						
						b = false;
						System.out.println("--------------------------------");
						System.out.println(" !   Wrong Value. Try again.   !");
						System.out.println("--------------------------------\n");
	
					}
						
				}while(b == false);
				
				subTotalNum[count] = priceNum[count] * qtyNum[count];
				taxNum[count] = subTotalNum[count] * 0.06;
				totalNum[count] = subTotalNum[count] + taxNum[count];
				
				sumSubTotal += subTotalNum[count];
				sumTax += taxNum[count];
				sumTotal += totalNum[count];
				
				System.out.println("Serendipity Booksellers\n");
				System.out.println("Date: "  + today);
				System.out.println("Time: "  + now);
				System.out.println();
				
			count++;
			System.out.println("+--------------------------------+");
			System.out.print("Do You Want to Enter Another Books? (Y/N) ");
			
			boolean choiceIsOK = false;
			    
			do{
			    
				String userInput = mainmenu.validateString(keyboard.next());
				System.out.println();
				    
			    char choice = userInput.toLowerCase().charAt(0);
				   
			    if(choice == 'y'){
				    	
			    	choiceIsOK = true;
				    	
			    }
				    
			    else if(choice == 'n'){
			    	
					System.out.println("Time: " + now);
					System.out.println("Date: " + today);
					System.out.println();
					
					System.out.printf("%-5s %-30s %-30s %-10s %-8s\n", "Qty", "ISBN", "Title", "Price", "Total");
					for(int i = 0; i <= 85; i++){
						
						System.out.print("_");
						
					}
					System.out.println();
						
					for(int j = 0; j < count; j++){
					
						System.out.printf(" %d   %-30s %-30s $%6.2f   $%6.2f\n", qtyNum[count], isbnNum[count], titleNum[count], priceNum[count], subTotalNum[count]);
						
					}
						
					System.out.printf("\n                 Subtotal:                             $%6.2f\n", sumSubTotal);
					System.out.printf("                 Tax:                                  $%6.2f\n", sumTax);
					System.out.printf("                 Total:                                $%6.2f\n\n", sumTotal);
					System.out.println(" *~*~*  Thank You for Shopping at Serendipity! *~*~*\n");
				
					System.out.println("***************************************");
					System.out.println(" You exit the cashier module. Bye-bye!");
					System.out.println("***************************************\n");
				    
			    	choiceIsOK = false;
			        quit = true;
			        break;
				    	
			    }
				    
			    else{
				    	
			    	System.out.println("--------------------------------");
					System.out.println(" !   Wrong Value. Try again   !");
					System.out.println("--------------------------------\n");
					
					System.out.println("+----------------------------------+");
				    System.out.print("Do You Want to Enter Another Books? (Y/N) ");
				        
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