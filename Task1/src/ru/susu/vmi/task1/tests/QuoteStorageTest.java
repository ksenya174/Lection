package ru.susu.vmi.task1.tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.susu.vmi.task1.model.IQuote;
import ru.susu.vmi.task1.model.IQuotesStorage;
import ru.susu.vmi.task1.model.Quote;
import ru.susu.vmi.task1.model.QuoteStorage;

public class QuoteStorageTest {

	public static IQuotesStorage emptyStorage;
	
	
	static
	{
		Calendar calc = Calendar.getInstance();
		calc.setTimeInMillis(0);
		date = calc.getTime();
	}
	static Date date;
	String symbol = "YHoo";
	String symbol_modified = "YHOO";
	double openPrice = 10.0;
	double highPrice = 20.0;
	double lowPrice = 5.0;
	double closePrice = 15.0;
	int volume = 100000;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emptyStorage = new QuoteStorage();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private IQuotesStorage testStorage;
	@Before
	public void setUp() throws Exception {
		testStorage = new QuoteStorage();
		IQuote quote1 = new Quote(symbol, date, openPrice, highPrice, lowPrice, closePrice, volume);
		testStorage.addQuote(quote1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNullParameters()
	{
		emptyStorage.addQuote(null);
		emptyStorage.removeQuote(null);
	}
	@Test
	public void testEmptyStorage() {
		emptyStorage.addQuote(null);
		emptyStorage.removeQuote(null);
		assertEquals(emptyStorage.totalQuotesCount(), 0);
	}
	@Test
	public void totalCountTest()
	{
		assertEquals(testStorage.totalQuotesCount(), 1);
		
	}

}
