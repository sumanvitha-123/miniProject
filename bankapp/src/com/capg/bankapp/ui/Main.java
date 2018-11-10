package com.capg.bankapp.ui;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.capg.bankapp.bean.Bank;
import com.capg.bankapp.service.BankService;
import com.capg.bankapp.service.IBankService;

public class Main {
	public static long acctNum;
	
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BankService service = new BankService();
		Bank b = new Bank();

		System.out.println("Welcome to bank app");
		System.out.println("1. Create Account");
		System.out.println("2. Show Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Fund Transfer");
		System.out.println("6. Print Transactions");
		System.out.println("7. Display");
		System.out.println("enter the choice");
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			System.out.println("Create Account...");
			System.out.println("enter the name more than 4 characters");
			String ename = sc.next();
			System.out.println("enter the pin atleast 4 characters");
			int pin = sc.nextInt();
			System.out.println("enter the phone number");
			BigInteger num = sc.nextBigInteger();
			System.out.println("enter the minimum balance");
			double bal = sc.nextDouble();

			Random rand = new Random();
			acctNum = rand.nextLong();
			if (acctNum < 0) {
				acctNum = acctNum * -1;
				System.out.println(acctNum);

			}
			b.setName(ename);
			b.setPin(pin);
			b.setNum(num);
			b.setBalance(bal);
			b.setAcctNum(acctNum);
			

			// service.createAccount(b);
			boolean isValid = BankService.validateData(b);
			if (isValid) {
				boolean isAdded = service.createAccount(b);
				if (isAdded) {
					
					System.out.println("Thank You");
					System.out.println("Dear "+b.getName()+" your account is created successfully");
					System.out.println("your account details are");
					System.out.println(b);
				}
			} 
			else {
				System.out.println("the name and pin should be more than 4-5 characters");
			}

			break;
		case 2:
			boolean isValidd = BankService.validateAccountNum(b);
			if (isValidd) {
				service.showBalance(acctNum);
			} 
			else {
				System.out.println("InValid");
			}

			break;
		case 3:
			System.out.println("Deposit.....");
			boolean isValid1 = BankService.validateAccountNum(b);
			System.out.println("enter the amount to deposit");
			double rupees = sc.nextDouble();
			if (isValid1) {
				service.deposit(rupees);
			} 
			else {
				System.out.println("InValid");
			}
			break;
		case 4:
			System.out.println("Withdraw....");
			boolean isValid2 = BankService.validateAccountNum(b);
			System.out.println("enter the amount to withdraw");
			double rupees1 = sc.nextDouble();
			if (isValid2) {
				service.withdraw(rupees1);
			} 
			else {
				System.out.println("InValid");
			}

			break;
		case 5:
			System.out.println("Fund Transfer");
			boolean isValid3 = BankService.validateAccountNum(b);
			if (isValid3) {
				service.fundTransfer(acctNum);
			}

			break;
		case 6:
			System.out.println("Print Transactions.....");
			boolean isValid4 = BankService.validateAccountNum(b);
			if (isValid4) {
				service.display();
			
			}
		
		default:
			
		System.out.println("Do you want to continue");
		System.out.println("1.Yes");
		System.out.println("2.No");
		int ch1 = sc.nextInt();
		switch (ch1) {
		case 1:
			main(args);
			break;
		case 2:
			System.exit(0);
			break;
		}

	}
	}
}


