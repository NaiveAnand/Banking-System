

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

//import oracle.jdbc.proxy.annotation.Methods;




public class BankingMainProgram {

	public static void main(String[] args) {
		

	
		
		Scanner sc=new Scanner(System.in);
		String name="A",city="S";
		int accno,amt=0;
		
		ArrayList<Accounts> list =new ArrayList<>();
		
		System.out.println("select task ");
        System.out.println("1. Open Accounts");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Balance Enquiry");
		System.out.println("5. List All");
		System.out.println("6. Exit");

		int choice;
		boolean found;
		do
		{
		System.out.print("Enter Choice here");
		 choice =sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("*** Click Here for Account Opening ***");
			System.out.print("Enter Your Name");
			name =sc.next();
			System.out.print("Enter Your City");
			city=sc.next();
			System.out.println("Enter Amount");
			amt=sc.nextInt();
			Accounts acc=new Accounts(name,city,amt);
			list.add(acc);
			System.out.println("Account Opened Succesfully");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String username="SYS as SYSDBA";
				String Password="Pandey@12345";
						
				Connection con=DriverManager.getConnection(url,username,Password);
				
				Statement stmt=con.createStatement();
				
				String sql = "INSERT INTO BankingSystem4 VALUES("+acc.getAccno()+",'"+acc.getName()+"','"+acc.getCity()+"',"+acc.getBal()+")";
				stmt.executeUpdate(sql);
	     
				
				
			}
			 catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("*** Click Here to Deposit ***");
			found =false;
			System.out.println("Enter Account Number");
			accno=sc.nextInt();
			for(Accounts ac:list)
			{
				if(accno==ac.getAccno())
				{
					found =true;
					System.out.println("Customer name "+ac.getName());
					System.out.println("Customer City "+ac.getCity());
					System.out.println("Customers' Account Balance "+ac.getBal());
					
					System.out.println("\nEnter amount to deposit");
					amt=sc.nextInt();
					ac.setBal(ac.getBal()+amt);
					System.out.println("Deposit Successfully");
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						String url="jdbc:oracle:thin:@localhost:1521:xe";
						String username="SYS as SYSDBA";
						String Password="Pandey@12345";
								
						Connection con=DriverManager.getConnection(url,username,Password);
						
						Statement stmt=con.createStatement();
						
						String sql = "UPDATE bank SET amt = '"+ac.getBal()+"'";
						stmt.executeUpdate(sql);
			     
						
						
					}
					 catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					System.out.println("Customer Accounts Balance "+ac.getBal());
					break;
					
				}
			}
			if(!found)
			{
				System.out.println("Invalid Account Number");
			}
			
			break;
		case 3:
			System.out.println("*** Click Here to Withdraw ***");
			found =false;
			System.out.println("Enter Account number");
			accno=sc.nextInt();
			for(Accounts ac:list)
			{
				if(accno==ac.getAccno())
				{
					found =true;
					System.out.println("Customer name "+ac.getName());
					System.out.println("Customer City "+ac.getCity());
					System.out.println("Customers' Account Balance "+ac.getBal());
					
					System.out.println("\nEnter amount to withdraw");
					amt =sc.nextInt();
					if(amt<=ac.getBal())
					{
						ac.setBal(ac.getBal()-amt);
						System.out.println("Withdrawn Successfully");
					}
					else {
						System.out.println("Insufficient Balance!");
					}
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						String url="jdbc:oracle:thin:@localhost:1521:xe";
						String username="SYS as SYSDBA";
						String Password="Pandey@12345";
								
						Connection con=DriverManager.getConnection(url,username,Password);
						
						Statement stmt=con.createStatement();
						
						String sql = "UPDATE bank SET amt = '"+ac.getBal()+"'";
						stmt.executeUpdate(sql);
			     
						
						
					}
					 catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				
					System.out.println("Customers' Account Balance "+ac.getBal());
					break;
				}
			}
			if(!found)
			{
				System.out.println("Invalid Account Number");
			}
			
			break;
		case 4:
			System.out.println("*** Balance Enquiry ***");
			found =false;
			System.out.println("Enter Account Number");
			accno=sc.nextInt();
			for(Accounts ac:list)
			{
				if(accno==ac.getAccno())
				{
					found =true;
					System.out.println("Customer name "+ac.getName());
					System.out.println("Customer City "+ac.getCity());
					System.out.println("Customers' Account Balance "+ac.getBal());
					
				}
			}
			if(!found)
			{
				System.out.println("Invalid Account Number");
			}
			break;
		case 5:
			System.out.println("*** List of All Accounts Openend ***");
			for(Accounts ac:list)
				System.out.println(ac);
			break;
		case 6:
			System.out.println("*** Thanks for Banking with Us ***");
			break;
			
		default:	
			System.out.println("*** Invalid Choice ***");
			break;
		}
		
		}while(choice!=6);
		
	}
	
}
