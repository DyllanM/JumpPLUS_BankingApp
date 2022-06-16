package Base;
import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String username;
	private String password;
	
	private float checking;
	//private float savings;
	
	private List<String> transHistory = new ArrayList<String>();
	
	public Account()
	{
		username = "";
		password = "";
		checking = 0.0f;
	}
	
	public Account(String name, String pass)
	{
		username = name;
		password = pass;
		checking = 0.0f;
	}

	public Account(String name, String pass, float check)
	{
		username = name;
		password = pass;
		checking = check;
	}
	
	public boolean deposit(float amount)
	{
		///////////////////////////////////////add to transhistory
		checking += amount;
		transHistory.add("+" + amount + " > " + String.format("%.2f", checking));
		
		return true;
	}
	public boolean withdrawl(float amount)
	{
		if (checking >= amount)
		{
			///////////////////////////////////////add to transhistory
			checking -= amount;
			transHistory.add("-" + amount + " > " + String.format("%.2f", checking));
			
			return true;	
		}

		System.out.println("Not enough in account for that transaction!");
		return false;
	}
	
	public boolean transfer(float amount, String username)
	{
		Account temp = new Account(username, "");
		int toTrans = Login.users.indexOf(temp);
		
		if (toTrans != -1)
		{
			if (checking >= amount)
			{
				Login.users.get(toTrans).deposit(amount);
				checking -= amount;
	
				transHistory.add("transfer " + amount + " to " + username + " > " + String.format("%.2f", checking));
				
				System.out.println("\n" + amount + " successfully transfered to " + username + "!\n");
				return true;
			}
			
			System.out.println("Not enough in account for that transaction!");
			return false;
		}
		
		System.out.println("Username does not exist!");
		return false;
	}
	
	public void displayInfo()
	{
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Amount in checking: " + String.format("%.2f", checking));
		System.out.println();
	}
	
	public void displayHistory()
	{
		System.out.println("\nRecent Transaction History: ");
		for (String trans : transHistory)
		{
			System.out.println(trans);
		}
		System.out.println();
	}
	
	public String getName()
	{
		return username;
	}
	
	public String getPass()
	{
		return password;
	}
	
	public float getBalance()
	{
		return checking;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		
		if (obj.getClass() != this.getClass())
			return false;
		
		final Account otherAcc = (Account)obj;
		if (!this.username.equals(otherAcc.username))
			return false;
		
		return true;
	}

}
