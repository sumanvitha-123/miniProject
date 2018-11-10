package com.capg.bankapp.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.capg.bankapp.bean.Bank;
import com.capg.bankapp.ui.Main;

public class BankDao implements IBankDao {

	Scanner sc = new Scanner(System.in);
	static ArrayList<Bank> banklist = new ArrayList<Bank>();
	static ArrayList<String> list = new ArrayList<String>();
	Bank b = new Bank();
	Main m= new Main();
	
	private static final SimpleDateFormat time = new SimpleDateFormat("HH.mm.ss");
	private static final SimpleDateFormat date = new SimpleDateFormat("yyyy.mm.dd");
	

	@Override
	public boolean createAccount(Bank b) {
		
		return banklist.add(b);
	}

	@Override
	public Bank showBalance(long accno) {
		
		
		System.out.println("enter the name more than 4 characters");
		String ename1 = sc.next();
		System.out.println("enter the pin atleast 4 characters");
		int pin1 = sc.nextInt();
		if (pin1 == b.getPin())
		{
			
		System.out.println("Welcome "+b.getName());
		System.out.println("the total balance in your account is "+b.getBalance());
		}
		else {
			System.out.println("Invalid");
		}
		return null;
		
	}

	@Override
	public double deposit(double rupees) {
		
		System.out.println("enter the name more than 4 characters");
		String ename1 = sc.next();
		String msg = "deposited";
		boolean result = false;
		System.out.println("enter the pin atleast 4 characters");
		int pin1 = sc.nextInt();
		if (pin1 == b.getPin())
		{
		double amount=b.getBalance()+rupees;
		b.setBalance(amount);
		result = true;
		System.out.println("the total balance deposited is "+b.getBalance());
		if(result)
		{
			addTransaction(rupees, msg);
		}
		}
		else {
			System.out.println("Invalid Credentials");
		}
		return b.getBalance();
	}

	@Override
	public double withdraw(double rupees) {
		
		System.out.println("enter the name more than 4 characters");
		String ename1 = sc.next();
		String msg = "withdrawl";
		boolean result = false;
		System.out.println("enter the pin atleast 4 characters");
		int pin1 = sc.nextInt();
		if (pin1 == b.getPin())
		{
		if(rupees < b.getBalance()) {
		double amount=b.getBalance()-rupees;
		b.setBalance(amount);
		result = true;
		System.out.println("the total balance  is "+b.getBalance());
		if(result)
		{
			addTransaction(rupees, msg);
		}
		}
		else {
			System.out.println("Your account is having insufficient balance");
		}
		}
		else {
			System.out.println("Invalid credentials ");
		}
		return b.getBalance();
	}

	@Override
	public double fundTransfer(long accno) {
		
		System.out.println("The total balance in your account is "+b.getBalance());
		System.out.println("Enter the details of another account to transfer money");
		System.out.println("enter the name");
		String oname = sc.next();
		String msg = "fund transferred";
		boolean result = false;
		System.out.println("enter the aNum");
		long aNum = sc.nextLong();
		System.out.println("enter the phone number");
		BigInteger phoneNum = sc.nextBigInteger();
		System.out.println("enter the amount to transfer");
		double amt = sc.nextDouble();
		if(amt < b.getBalance())
		{
			double amount = b.getBalance() - amt;
			b.setBalance(amount);
			result = true;
			System.out.println("Transaction is successful");
			System.out.println("The total balance in your account is given as "+b.getBalance());
			if(result)
			{
				addTransaction(amt, msg);
			}
		}
		else
		{
			System.out.println("Tansaction failed due to low balance");
		}
		return b.getBalance();
	}
	
	public void printTransaction(){
		printTransaction(list);
	}

	@Override
	public ArrayList<String> display() {
		printTransaction(list);
		return list;
	}

	@Override
	public ArrayList<String> addTransaction(double amount,String msg) {
		// TODO Auto-generated method stub
		
		Date d=new Date();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//System.out.println(timestamp);
		
		
		String p= date.format(d)+"    "+time.format(timestamp)+"    " + amount +"    " + msg ;
		 list.add(p);
		
		return list;
		
	}
	@Override
	public ArrayList<String> printTransaction(ArrayList list) {
		
//		System.out.println(list);
		Iterator<String> iterator = list.iterator();
		System.out.println("Date       "+"   Time        "+" Amount   "+" Operation   ");
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		return list;
	}
	

	
}
