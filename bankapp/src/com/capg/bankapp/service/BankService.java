package com.capg.bankapp.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import com.capg.bankapp.bean.Bank;
import com.capg.bankapp.dao.BankDao;
import com.capg.bankapp.ui.Main;

public class BankService implements IBankService {

	BankDao dao = new BankDao();
	Main m = new Main();
	static Scanner sc = new Scanner(System.in);
	@Override
	public boolean createAccount(Bank b) {
		return dao.createAccount(b);
	}

	@Override
	public Bank showBalance(long accno) {
				return dao.showBalance(accno);
	}

	@Override
	public double deposit(double rupees) {
		return dao.deposit(rupees);
	}

	@Override
	public double withdraw(double rupees) {
		return dao.withdraw(rupees);
	}

	@Override
	public double fundTransfer(long accno) {
		return dao.fundTransfer(accno);
	}
	
	
	
	
	
	@Override
	public ArrayList<String> display() {
		// TODO Auto-generated method stub
		return dao.display();
	}

	

	@Override
	public ArrayList<String> addTransaction(double amount,String msg) {
		// TODO Auto-generated method stub
		return dao.addTransaction(amount,	msg);
	}

	@Override
	public ArrayList<String> printTransaction(ArrayList list) {
		// TODO Auto-generated method stub
		return dao.printTransaction(list);
	}

	public static boolean validateData(Bank b) {

		boolean isValid = false;
		if (b.getName().length() > 4 && b.getName().matches("[A-Za-z]*")) {
			isValid = true;
		}
		
		return isValid;
	}
	public static boolean validateAccountNum(Bank b)
	{
		System.out.println("Enter account number..");
		long accno = sc.nextLong();
		boolean isValid = false;
		if(Main.acctNum==accno)
		{
			isValid = true;
		}
		return isValid;
		
	

}
}
