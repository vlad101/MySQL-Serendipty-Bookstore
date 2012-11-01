import java.util.Scanner;

public class MainMenu {
	
	static Scanner keyboard = new Scanner(System.in);
	static String choice;
	static int x = 0;
	static boolean b;
	
	public static int validateMenuChoice(){
		
		do{
			
			System.out.println("+------------------+");
			System.out.print("Enter your choice: ");
			choice = validateString(keyboard.next());
			System.out.println();
			
			b = true;
				
			try {
				
				x = Integer.parseInt(choice);
				
			}
				
			catch(NumberFormatException nFE) {
				
				b = false;
				System.out.println("--------------------------------");
				System.out.println(" !   Wrong Value. Try again!   !");
				System.out.println("--------------------------------\n");
				
			}
					
		}while(b == false);
		
		return x;
		
	}
	
	public static String validateString(String st){
		
		while(st.equals("")){
			
			//System.out.print("");
			st = keyboard.next();
			
		}
		
		return st;
		
	}
		
	public static void main(String[] args) {
		
		
		Reports reports = new Reports();
		InvMenu invmenu = new InvMenu();
		Cashier cashier = new Cashier();
		BookInfo bookinfo = new BookInfo();
			
		while(x != 4){
			
			/*
			 * Modify BookInfo.bookInfo() to create tables and add books to the inventory manually
			 * */
			
			bookinfo.bookInfo();
			
			System.out.println();
			System.out.println("                          ********************************");
			System.out.println("                          *    Serendipity Booksellers   *");
			System.out.println("                          *           Main Menu          *");		
			System.out.println("                          ********************************");
			System.out.println("                          *                              *");
			System.out.println("                          * 1. Cashier Module            *");
			System.out.println("                          * 2. Inventory Database Module *");
			System.out.println("                          * 3. Report Module             *");
			System.out.println("                          * 4. Exit                      *");
			System.out.println("                          *                              *");
			System.out.println("                          ********************************\n");
				
			x = validateMenuChoice();
				
			if(x == 1){
				
				System.out.println("+----------------+");
				System.out.println("| Cashier Module |");
				System.out.println("+----------------+\n");
					
				cashier.printCashier();
				
			}
			
			else if(x == 2){
				
				System.out.println("+-----------------------------+");
				System.out.println("|  Inventory Database Module  |");
				System.out.println("+-----------------------------+\n");
			
				invmenu.printInvMenu();
				
			}			
				
			else if(x == 3){
				
				System.out.println("+---------------+");
				System.out.println("| Report Module |");
				System.out.println("+---------------+\n");
				
				reports.printReportsMenu();
				
			}
				
			else if(x == 4){
	
				break;
				
			}
				
			else{
				
				System.out.println("--------------------------------");
				System.out.println(" !   Wrong Value. Try again!   !");
				System.out.println("--------------------------------\n");
				
			}
				
		}
		
		System.out.println("********************************");
		System.out.println(" You exit the Program. Bye-bye!");
		System.out.println("********************************\n");
		System.exit(0);
			
	}
	
}