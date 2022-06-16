package Base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	
	private static boolean running = true;
	
	private static boolean loggedIn = false;
	
	public static void mainLoop()
	{
		while(running)
		{
			while(!loggedIn)
				loggedIn = Login.loginAsUser();
			
			//take in commands and go to sub menus
			displayMenu();
		}
	}
	
	public static void displayMenu()
	{
		System.out.println("Hello " + Login.currentAcc.getName() + ", ");
		System.out.println("");
		System.out.println("1) Deposit");
		System.out.println("2) Withdrawl");
		System.out.println("3) Transfer Funds");
		System.out.println("4) View Transaction History");
		System.out.println("5) Display User Info");
		System.out.println("6) Log In");
		System.out.println("7) Quit Program");
		System.out.println("");
		System.out.print("Enter the number of your selection: ");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int selection = -1;
		try
		{
			selection = Integer.parseInt(reader.readLine());
		}
		catch (NumberFormatException ee)
		{
			System.out.println("Invalid Input!!!");
			return;
		}
		catch (IOException e)
		{
			System.out.println("fjubsdfu");
			return;
		}
		
		switch(selection)
		{
			case 1:    //Deposit
				System.out.println("Current Balance: " + String.format("%.2f", Login.currentAcc.getBalance()));
				System.out.print("\nEnter amount to deposit: ");
				float amount = 0;
				String amountInput = "0.0f";
				try{amountInput = reader.readLine();}
				catch(IOException e) {System.out.println("gggggggggg");return;}
				catch(NumberFormatException ee) {System.out.println("Invalid Input!");return;}
				catch(StringIndexOutOfBoundsException ee) {System.out.println("Invalid Inputt!");return;}
				
				amount = Float.parseFloat(amountInput);
				Login.currentAcc.deposit(amount);
				break;
			case 2:    //Withdrawl
				System.out.println("Current Balance: " + String.format("%.2f", Login.currentAcc.getBalance()));
				System.out.print("\nEnter amount to withdraw: ");
				float wamount = 0;
				String wamountInput = "0.0f";
				try{wamountInput = reader.readLine();}
				catch(IOException e) {System.out.println("gggggggggg");return;}
				catch(NumberFormatException ee) {System.out.println("Invalid Input!");return;}
				
				wamount = Float.parseFloat(wamountInput);
				Login.currentAcc.withdrawl(wamount);
				break;
			case 3:    //Transfer
				System.out.println("Current Balance: " + String.format("%.2f", Login.currentAcc.getBalance()));
				System.out.print("\nEnter amount to transfer: ");
				float tamount = 0;
				String tamountInput = "0.0f";
				try{tamountInput = reader.readLine();}
				catch(IOException e) {System.out.println("gggggggggg");return;}
				catch(NumberFormatException ee) {System.out.println("Invalid Input!");return;}
				
				tamount = Float.parseFloat(tamountInput);
				System.out.print("Enter name of user to transfer to: ");
				String tnameInput = "";
				try{tnameInput = reader.readLine();}
				catch(IOException e) {System.out.println("gggggggggg");return;}
				
				Login.currentAcc.transfer(tamount, tnameInput);
				
				break;
			case 4:    //Trans History
				Login.currentAcc.displayHistory();
				bufferLine();
				break;
			case 5:    //User Info
				Login.currentAcc.displayInfo();
				bufferLine();
				break; 
			case 6:
				loggedIn = false;
				Login.currentAcc = null;
				return;
			case 7:
				running = false;
				System.out.println("Exiting Program...");
				break;
			default:
				break;
		}
	}
	
	public static void bufferLine()
	{
		try{new BufferedReader(new InputStreamReader(System.in)).readLine();} catch(IOException e) {}
	}

}
