package com.capg.bankapp.bean;

import java.math.BigInteger;

public class Bank {
	
	private static String name;
	private static int pin;
	private long acctNum;
	private BigInteger num;
	static double balance; 
	
	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		Bank.balance = balance;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Bank.name = name;
	}

	public static int getPin() {
		return pin;
	}

	public static void setPin(int pin) {
		Bank.pin = pin;
	}

	public long getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(long acctNum) {
		this.acctNum = acctNum;
	}

	public BigInteger getNum() {
		return num;
	}

	public void setNum(BigInteger i) {
		this.num = i;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", acctNum=" + acctNum + ", num=" + num
				+ "]";
	}

	
	}


