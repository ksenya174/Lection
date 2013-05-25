package ru.susu.vmi.task1.tests;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.susu.vmi.task1.model.IQuote;
import ru.susu.vmi.task1.model.Quote;

public class QuoteTest {
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
	IQuote quote;
	IQuote quote1;
	IQuote quote2;
	IQuote quote3;
	
	@Before
	public void beforeTest() {
		 quote1 = new Quote(symbol, date, openPrice, highPrice, lowPrice, closePrice, volume);
		 quote2 = new Quote(symbol, date, openPrice + 1, highPrice, lowPrice, closePrice, volume);
		 quote3 = new Quote(symbol, date, openPrice, highPrice, lowPrice, closePrice, volume);
		 quote = quote1;
	}
	
	@Test
	public void testGetters() {
		Assert.assertEquals(symbol_modified, quote.getSymbol());
		Assert.assertEquals(openPrice, quote.getOpenPrice());
		Assert.assertEquals(highPrice, quote.getHighPrice());
		Assert.assertEquals(lowPrice, quote.getLowPrice());
		Assert.assertEquals(closePrice, quote.getClosePrice());
		Assert.assertEquals(volume, quote.getVolume());
		Assert.assertEquals(date, quote.getDate());
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals("[YHOO, Thu Jan 01 05:00:00 YEKT 1970, 10, 20, 5, 15, 100000]", quote.toString());

	}
	
	@Test
	public void testEquals() {
		Assert.assertTrue(quote1.equals(quote));
		Assert.assertTrue(quote1.equals(quote3));
		Assert.assertFalse(quote1.equals(quote2));
	}
	
	@Test
	public void testCompareTo() {
		Assert.assertEquals(0, quote1.compareTo(quote2));

	}
}
