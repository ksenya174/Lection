package ru.susu.vmi.task1.model;

import java.util.Date;
import java.text.NumberFormat;

/**
 * ����� Quote ��������� ��������� IQuote
*/
//public (��������): ����� ������ ������ ������ ����� ������ ����������.
//�������� implements � ��� ���������� � ����������� ������, ������������ ��������� ���������(�).
public class Quote implements IQuote {
	//private - (��������): �� ���� ������ �� ����������� ����������� ���������� ������� ������ �� ����� ������ ����������, ���� ��������.
	private String symbol;
	private Date date;
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private int volume;
	
	private NumberFormat numberFormatter = NumberFormat.getInstance();

	/**
	 * ����������� ������ Quote, ��� ������������� �������� ����������
	 */ 
	public Quote(String symbol, Date date, double openPrice, double highPrice, double lowPrice,  double closePrice,  int volume) {
		this.symbol = symbol.toUpperCase();//��� ������� � ����������� ���������� �������� ������� ������������ ������ this
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume; 
		
		numberFormatter.setMaximumFractionDigits(2);
	}

	/**
	 * ������ ���������� ������
	 */
	@Override
	public String getSymbol() {
		return symbol;
	}

	/**
	 * ���� ���������
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * ������� ���� �����
	 */
	@Override
	public double getOpenPrice() {
		return openPrice;
	}
	
	/**
	 * ������� ���� �����
	 */
	@Override
	public double getHighPrice() {
		return highPrice;
	}
	
	/**
	 * ������ ���� �����
	 */
	@Override
	public double getLowPrice() {
		return lowPrice;
	}
	
	/**
	 * ������� ���� �����
	 */
	@Override
	public double getClosePrice() {
		return closePrice;
	}
	
	/**
	 * ��������� �����
	 */
	@Override
	public int getVolume() {
		return volume;
	}
	
	/**
	 * ������������ �����
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
	 * ����� ���������� ���������� ������ � IQuote o1, IQuote o2. ���������� 0,
	 *  ���� ���� �������-��. ����� ���� - �������� ������ <, ����� ���� >
	 */
	//To - ��� ������������ ��������
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
