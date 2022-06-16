package Base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Login {

	public static List<Account> users = new ArrayList<Account>();
	public static Account currentAcc;
	
	public static void initUsers()
	{
		users.add(new Account("dolan", "xxxx", 500.0f));
		users.add(new Account("henry", "hhhh", 100.0f));
		users.add(new Account("peter", "hxfa487", 350.0f));
	}
	
	public static void createUser(String username, String password)
	{
		Account temp = new Account(username, password);
		if (users.indexOf(temp) == -1)
		{
			users.add(new Account(username, password));
		}
	}
	
	public static boolean loginAsUser()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//// log in 
		String userInput;
		System.out.print("Enter username: ");
		try 
		{	
			userInput = reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Invalid input!");
			return false;
		}
		
		currentAcc = null;
		for (Account toCheck : Login.users)
		{
			if (toCheck.getName().equals(userInput))
			{
				currentAcc = toCheck;
			}
		}
		
		if (currentAcc == null)
		{
			System.out.println("Name not found!");
			return false;
		}
		
		System.out.print("Enter Password: ");
		String passInput;
		try 
		{	
			passInput = reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Invalid input!");
			return false;
		}
		
		if (!currentAcc.getPass().equals(passInput))
		{
			System.out.println("Incorrect Password!");
			return false;
		}
		
		System.out.println("Logged in as " + currentAcc.getName() + "!");
		return true;
	}
}
