package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import model.excepitions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double amount = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			sc.nextLine();
			
			Account account = new Account(number, holder, withdrawLimit);
			account.deposit(amount);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			amount = sc.nextDouble();
			account.withdraw(amount);
			
			System.out.println("New balance: "+ String.format("$ %.2f",account.	getBalance()));
			
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpered error " + e.getMessage());
		}
		finally {
			sc.close();	
		}
	}

}
