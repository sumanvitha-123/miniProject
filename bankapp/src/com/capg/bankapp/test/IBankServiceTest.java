package com.capg.bankapp.test;

import static org.junit.Assert.*;

import java.security.Provider.Service;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.bankapp.bean.Bank;
import com.capg.bankapp.service.BankService;
import com.capg.bankapp.service.IBankService;

public class IBankServiceTest {
	
	@BeforeClass
	public void createInstance()
	{
		BankService service = new BankService();
	}
	

	@Test
	public void testNameForAlphabets() {
		Bank bank=new Bank();
		bank.setName("78sandg");
		bank.setAcctNum(234454563);
//		bank.setNum(783483858676);
		boolean result=BankService.validateData(bank);
		assertFalse(result);
	}

}
