package ru.susu.vmi.task1.model;
//java - ����� �������� ������; util - �����, ��������� � 1 �����; ��� ������ 
import java.util.ArrayList;//��������� ������������ ������
import java.util.Calendar;
import java.util.Collection;//��������� �������� � �������� ��������
import java.util.Collections;
import java.util.Comparator;//���������� ������� ����������
import java.util.Date;
import java.util.HashMap;//���������� ���-������� ��� �������� �����
import java.util.Iterator;//��������� ������������ ���� ��� ������� �� ��������� ������� ���� ������ ��-��
import java.util.List;//��������� collection ��� ���������� ��������
import java.util.Map;//������ ��������� ���������� ��� ������� � ����������
import java.util.SortedSet;//��������� set(���������� �����������) ��� ������������ ���������������� �����������
import java.util.TreeSet;//��������� ��������� �������� � ������

/**
 * ����� QuoteStorage ��������� ��������� IQuotesStorage
*/
public class QuoteStorage implements IQuotesStorage {
	
	//private List<IQuote> localStorage = new ArrayList<IQuote>();
	
	//localStorage - ������� ���������
	private Map<String, SortedSet<IQuote>> localStorage = new HashMap<String, SortedSet<IQuote>>();
	
	@Override
	//��������� ��������� � ��������� 
	public void addQuote(IQuote quote) {
		if (quote != null)
		{
		String symbol = quote.getSymbol();
		SortedSet<IQuote> set = localStorage.get(symbol);
		if (set == null)
		{
			set = new TreeSet<IQuote>();
			localStorage.put(symbol, set);
		}
		set.add(quote);
		}
	}

	@Override
	//������� ���������
	public void removeQuote(IQuote quote) {
		if (quote != null)
		{
		
		SortedSet<IQuote> set = localStorage.get(quote.getSymbol());
		if (set == null)
		{
			throw new IllegalStateException("No quotes with such symbol");
		}
		set.remove(quote);
		}
	}
	
	@Override
	/**
	 * ������������� �����
	 */
	// �������� ������ � ��� �� ������, �� � ������ ������� ���������� ���������� �����������. 
	public String toString() {
		//StringBuffer - ��������� ��������� ������� � ��������� � �������� ���� ��������� �� � �����
		StringBuffer buffer = new StringBuffer();
		//keySet - ������������� ������������� ������
		// hasNext - ���������� �������� �� ��������� ��� �����
		for (Iterator<String> it = localStorage.keySet().iterator(); it.hasNext();) {
			String symbol = it.next();
			SortedSet<IQuote> set = localStorage.get(symbol);
			double maxPrice = 0.0;
			double minPrice = Double.MAX_VALUE;
			Date beginDate = null;
			Date endDate = null;
			for (IQuote quote : set) {
				if (quote.getHighPrice() > maxPrice)
					maxPrice = quote.getHighPrice();
				if (quote.getLowPrice() < minPrice)
					minPrice = quote.getLowPrice();
				Date quoteDate = quote.getDate();
				if (beginDate == null || quoteDate.before(beginDate))
					beginDate = quoteDate;
				if (endDate == null || quoteDate.after(endDate))
					endDate = quoteDate;
			}
			
			buffer.append("[");
			buffer.append(symbol);
			buffer.append(",");
			buffer.append(set.size());
			buffer.append(" Quotes");
			buffer.append(", Max Quote=");
			buffer.append(maxPrice);
			buffer.append(", Min Quote=");
			buffer.append(minPrice);
			buffer.append(", Begin Quote=");
			buffer.append(beginDate);
			buffer.append(", End Quote=");
			buffer.append(endDate);
			buffer.append("]");
			buffer.append("\n");
		}
		return buffer.toString();//���������� � ����������
	}

	@Override
	public Map<String, List<IQuote>> getQuotes(Date begin, Date end) {
		Map<String, List<IQuote>> result = new HashMap<>();
		
		for (String symbol : localStorage.keySet()) {
			result.put(symbol, getQuotes(symbol, begin, end));
		}
		
		return result;
	}

	@Override
	public List<IQuote> getQuotes(String symbol, Date begin, Date end) {
		SortedSet<IQuote> set = localStorage.get(symbol);
		List<IQuote> result = new ArrayList<>();
		
		for (IQuote quote : set) {
			Date date = quote.getDate();
			if (date.after(begin) && date.before(end))
			{
				result.add(quote);
			}
		}
		return result;
	}

	@Override
	public void clear() {
		for (SortedSet<IQuote> set : localStorage.values()) 
		{
			set.clear();
		}
		localStorage.clear();
	}

	@Override
	public int totalQuotesCount() {
		
		
		
		return 0;
	}

}
