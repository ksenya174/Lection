package ru.susu.vmi.task1.model;
//java - Пакет верхнего уровня; util - пакет, вложенный в 1 пакет; имя класса 
import java.util.ArrayList;//реализует динамический массив
import java.util.Calendar;
import java.util.Collection;//позволяет работать с группами объектов
import java.util.Collections;
import java.util.Comparator;//определяет порядок сортировки
import java.util.Date;
import java.util.HashMap;//используем хеш-таблицу для хранения карты
import java.util.Iterator;//позволяет организовать цикл для прохода по коллекции получая либо удаляя эл-ты
import java.util.List;//расширяет collection для управления списками
import java.util.Map;//объект сохраняет ассоциации мду ключами и значениями
import java.util.SortedSet;//расширяет set(управление множествами) для управлениями отсортированными множествами
import java.util.TreeSet;//реализует множество хранимое в дереве

/**
 * класс QuoteStorage реализует интерфейс IQuotesStorage
*/
public class QuoteStorage implements IQuotesStorage {
	
	//private List<IQuote> localStorage = new ArrayList<IQuote>();
	
	//localStorage - создали хранилище
	private Map<String, SortedSet<IQuote>> localStorage = new HashMap<String, SortedSet<IQuote>>();
	
	@Override
	//добавляет котировку и сортирует 
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
	//удаляет котировку
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
	 * перегруженный метод
	 */
	// Создание метода с тем же именем, но с другим набором параметров называется перегрузкой. 
	public String toString() {
		//StringBuffer - позволяет вставлять символы и подстроки в середину либо добавлять их в конец
		StringBuffer buffer = new StringBuffer();
		//keySet - коллекционное представление ключей
		// hasNext - определяет доступен ли указанный тип ввода
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
		return buffer.toString();//обращается в суперкласс
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
