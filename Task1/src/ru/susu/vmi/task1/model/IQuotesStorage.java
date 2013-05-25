package ru.susu.vmi.task1.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ����������� ��������� ��������� �����
 */
public interface IQuotesStorage {
	
	/**
	 * void - ������� ������ �� �����
	 * addQuote - ��������� ��������� � ���������
	 */	
	public void addQuote(IQuote quote);
	
	/**
	 * ������� ��������� �� ���������
	 */
	public void removeQuote(IQuote quote);
	/**
	* @param begin date of the interval
	* @param end date of the interval
	* @return Map where key is quote symbol and value is ordered list
	of the quotes
	*/
	public Map<String, List<IQuote>> getQuotes(Date begin, Date end);
	/**
	* Get quotes for specified symbol
	* @param symbol is required kind of quote
	* @param begin date of the interval
	* @param end date of the interval
	* @return ordered list of the quotes
	*/
	public List<IQuote> getQuotes(String symbol, Date begin, Date end);
	
	/**
	* Clear the storage
	*/
	public void clear();

	/**
	 * Method gets total quotes 
	 */
	public int totalQuotesCount();
	
	

}
