import java.util.ArrayList;
import java.util.Scanner;

public class InvMenu {
	
	static Scanner keyboard = new Scanner(System.in);
	
	static MainMenu mainmenu = new MainMenu();
	static LookUpBook lookupbook = new LookUpBook();
	static EditBook editbook = new EditBook();
	static AddBook addbook = new AddBook();
	static DeleteBook deletebook = new DeleteBook();
	
	static int x = 0;
					
	public static void editBook(){
		
		System.out.println("+-----------------------+");
		System.out.println("|  Edit a Book's Record |");
		System.out.println("+-----------------------+\n");
		
	}
	
	public static void deleteBook(){
		
		System.out.println("+----------------+");
		System.out.println("| Delete a Book  |");
		System.out.println("+----------------+\n");
		
	}
	
	public static void printInvMenu(){
		
		String choice;
		boolean b;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("                          ********************************");
		System.out.println("                          *    Serendipity Booksellers   *");
		System.out.println("                          *       Inventory Database     *");		
		System.out.println("                          ********************************");
		System.out.println("                          *                              *");
		System.out.println("                          * 1. Look Up Book              *");
		System.out.println("                          * 2. Add a Book                *");
		System.out.println("                          * 3. Edit a Book's Record      *");
		System.out.println("                          * 4. Delete a Book             *");
		System.out.println("                          * 5. Return to the Main Menu   *");
		System.out.println("                          *                              *");
		System.out.println("                          ********************************\n");
		
		x = 0;
		
		x = mainmenu.validateMenuChoice();
		
		do{
			
			if(x == 1){
			
				lookupbook.lookUpBook();
			
			}
			
			else if(x == 2){
			
				addbook.addBook();
			
			}
			
			else if(x == 3){
			
				editbook.editBook();
			
			}
			
			else if(x == 4){
			
				deletebook.deleteBook();
			
			}
			
			else if(x == 5){
			
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
			
			printInvMenu();
			
		}while(x == 5);
		
	}
	
}
