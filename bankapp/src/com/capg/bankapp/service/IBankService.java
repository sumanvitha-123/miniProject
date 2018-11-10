package com.capg.bankapp.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.capg.bankapp.bean.Bank;

public interface IBankService {

	public boolean createAccount(Bank b);

	public Bank showBalance(long accno);

	public double deposit(double rupees);
	
	public double withdraw(double rupees);
	
	public double fundTransfer(long accno);
	
	public ArrayList<String> display();
	
	public ArrayList<String> addTransaction( double amount, String msg);
	
	public ArrayList<String> printTransaction(ArrayList list);
	
	//public static boolean validateData(Bank b);
}
