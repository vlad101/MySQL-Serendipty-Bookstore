import java.util.ArrayList;
import java.util.Scanner;

public class Reports {
	
	static MainMenu mainmenu = new MainMenu();
	
	public static void repListing(){
		
		System.out.println("+--------------------+");
		System.out.println("| Inventory Listing  |");
		System.out.println("+--------------------+\n");
		
	}
	
	public static void repWholesale(){
		
		System.out.println("+---------------------------+");
		System.out.println("| Inventory Wholesale Value |");
		System.out.println("+---------------------------+\n");
		
	}
	
	public static void repRetail(){
		
		System.out.println("+---------------------------+");
		System.out.println("| Inventory Retail Value    |");
		System.out.println("+---------------------------+\n");
		
	}
	
	public static void repQty(){
		
		System.out.println("+---------------------------+");
		System.out.println("| Listing By Quantity       |");
		System.out.println("+---------------------------+\n");
		
	}

	public static void repCost(){
		
		System.out.println("+---------------------------+");
		System.out.println("| Listing By Cost           |");
		System.out.println("+---------------------------+\n");
		
	}
	
	public static void repAge(){
		
		System.out.println("+---------------------+");
		System.out.println("| Listing By Age      |");
		System.out.println("+---------------------+\n");
		
	}
	
	public static void printReportsMenu(){
		
		String choice;
		int x = 0;
		boolean b;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("                          ********************************");
		System.out.println("                          *    Serendipity Booksellers   *");
		System.out.println("                          *            Reports           *");		
		System.out.println("                          ********************************");
		System.out.println("                          *                              *");
		System.out.println("                          * 1. Inventory Listing         *");
		System.out.println("                          * 2. Inventory Wolesale Value  *");
		System.out.println("                          * 3. Inventory Retail Value    *");
		System.out.println("                          * 4. Listing By Quantity       *");
		System.out.println("                          * 5. Listing By Age            *");
		System.out.println("                          * 6. Listing By Cost           *");
		System.out.println("                          * 7. Return to the Main Menu   *");
		System.out.println("                          *                              *");
		System.out.println("                          ********************************\n");
		
		x = mainmenu.validateMenuChoice();
		
		do{
			
			if(x == 1){

				repListing();
			
			}
			
			else if(x == 2){
			
				repWholesale();
			
			}
			
			else if(x == 3){
				
				repRetail();
			
			}
			
			else if(x == 4){
				
				repQty();
				
			}
			
			else if(x == 5){
				
				repCost();
				
			}
			
			else if(x == 6){
				
				repAge();
				
			}
			
			else if(x == 7){
				
				System.out.println("+-----------------------------+");
				System.out.println("| Returning to the Main Menu  |");
				System.out.println("+-----------------------------+\n");
				break;
				
			}
			
			else{
				
				System.out.println("--------------------------------");
				System.out.println(" !   Wrong Value. Try again   !");
				System.out.println("--------------------------------\n");
			
			}
			
			printReportsMenu();
			
		}while(x == 7);
		
	}
	
}	