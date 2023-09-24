package optionalOops;

import java.util.Scanner;

/*
 * Using a class we need to handle the bank account of the customer. The customer can perform following task-
1. Deposit - to deposit amount into the account.
2. Withdraw - to withdraw an amount from the account.
3. Add Interest- to add interest balance to the account (integer part only).
(After adding interest balance is increased by interest times).
Complete the given functions to perform the desired task.
Input Format:
Line 1: Initial balance and interest. 

Line 2: Integer x. (1 for deposit, 2 for withdrawal, 3 to add interest, -1 to exit)

Line 3 : The amount to be deposited if x = 1. The amount to withdraw if x = 2. Empty if x = 3.

Line 4, 5 : Same as lines 2 and 3.
.
.
.
Perform the operations till -1 is encountered.
Output format:
Print the balance of account when -1 is encountered.
Sample Input 1 :
1000 0.10
1
400
2
250
3
-1
Sample Output 1 :
1265
Sample Input 2 :
1000 0.10
1
400
3
-1
Sample Output 2 :
1540
 */

class SavingsAccount
{
	private int balance;
	private double interest;

	public SavingsAccount(int initialBalance, double initialInterest)
	{
		this.balance = initialBalance;
		this.interest = initialInterest;
	}

	public void deposit(int amount)
	{
		balance += amount;
	}

	public void withdraw(int amount)
	{
		balance -= amount;
	}

	public void addInterest()
	{
		double interestAmount = balance*interest;
		balance += (int)(interestAmount);
	}

	public int getBalance()
	{
		return balance;
	}

}

public class BankAccountSolution {
	
	public static void main (String[] args) {
	    Scanner s=new Scanner(System.in);
	    int balance=s.nextInt();
	    double interest=s.nextDouble();
		SavingsAccount sa=new SavingsAccount(balance,interest);
		
		int x=s.nextInt();
		while(x!=-1){
		if(x==1)
		{
		    int add=s.nextInt();
		    sa.deposit(add);
		}
		else if(x==2)
		{
		    int with=s.nextInt();
		    sa.withdraw(with);
		}
		else if(x==3)
		    sa.addInterest();
		x=s.nextInt();
		}
		System.out.println(sa.getBalance());
		
	}

}
