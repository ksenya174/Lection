package ru.susu.vmi.task1.model;

import java.util.Date;
import java.text.NumberFormat;

/**
 * класс Quote реализует интерфейс IQuote
*/
//public (открытый): Любой объект любого пакета может видеть переменную.
//Оператор implements — это дополнение к определению класса, реализующего некоторый интерфейс(ы).
public class Quote implements IQuote {
	//private - (закрытый): Ни один объект за исключением конкретного экземпляра данного класса не может видеть переменную, даже подкласс.
	private String symbol;
	private Date date;
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private int volume;
	
	private NumberFormat numberFormatter = NumberFormat.getInstance();

	/**
	 * Определение класса Quote, где присваивается значения переменным
	 */ 
	public Quote(String symbol, Date date, double openPrice, double highPrice, double lowPrice,  double closePrice,  int volume) {
		this.symbol = symbol.toUpperCase();//для доступа к одноименным переменным текущего объекта используется ссылка this
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume; 
		
		numberFormatter.setMaximumFractionDigits(2);
	}

	/**
	 * строка возвращает символ
	 */
	@Override
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Дата котировки
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * открыть цену акций
	 */
	@Override
	public double getOpenPrice() {
		return openPrice;
	}
	
	/**
	 * высокая цена акций
	 */
	@Override
	public double getHighPrice() {
		return highPrice;
	}
	
	/**
	 * низкая цена акций
	 */
	@Override
	public double getLowPrice() {
		return lowPrice;
	}
	
	/**
	 * закрыть цену акций
	 */
	@Override
	public double getClosePrice() {
		return closePrice;
	}
	
	/**
	 * изменение акций
	 */
	@Override
	public int getVolume() {
		return volume;
	}
	
	/**
	 * расположение строк
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append(symbol);
		buffer.append(", ");
		buffer.append(date);
		buffer.append(", ");
		buffer.append(numberFormatter.format(openPrice));
		buffer.append(", ");
		buffer.append(numberFormatter.format(highPrice));
		buffer.append(", ");
		buffer.append(numberFormatter.format(lowPrice));
		buffer.append(", ");
		buffer.append(numberFormatter.format(closePrice));
		buffer.append(", ");
		buffer.append(volume);
		buffer.append("]");
		return  buffer.toString(); 
	}

	/**
	 * метод сравнивает вызывающий объект с IQuote o1, IQuote o2. возвращает 0,
	 *  если знач эквивал-ны. отриц знач - вызывающ объект <, полож если >
	 */
	//To - тип сравниваемых объектов
	@Override
	public int compareTo(IQuote o) {
		return getDate().compareTo(o.getDate());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof Quote)
		{
			Quote quote = (Quote)obj;
			if (getClosePrice() == quote.getClosePrice()
					&& getDate().equals(quote.getDate())
					&& getHighPrice() == quote.getHighPrice()
					&& getOpenPrice() == quote.getOpenPrice())
				return true;
		}
		return false;
	}

}
