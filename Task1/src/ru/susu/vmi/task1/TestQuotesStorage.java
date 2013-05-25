package ru.susu.vmi.task1;

//import java.text.NumberFormat;
import java.util.Calendar;//����� ����� �������� ����� �������, 
//��������� ������ ����� � ������������ �� ��-�� ������� ���������
import java.util.Date;//������� ����� ��� �������� ���� 
import java.util.Random;//��������� ��������� �����

import ru.susu.vmi.task1.model.IQuote;
import ru.susu.vmi.task1.model.IQuotesStorage;
import ru.susu.vmi.task1.model.Quote;
import ru.susu.vmi.task1.model.QuoteStorage;

public class TestQuotesStorage {

	/**
	 * ����������� ��������� ����������
	 */
	public static final String[] SYMBOLS = {"YHOO", "CSCO"};
	
	public static final int N = 100;
	/**
	 * ����� main, � ������� ���������� ���������� IQuotesStorage
������� � ������� ���������� ��������� ����� Random � ������������ ����
������� �����������.
	 */
	public static void main(String[] args) {
		//NumberFormat nf = NumberFormat.getInstance();
		//nf.setMaximumFractionDigits(2);
		
		System.out.println("Quotes Storage testing started..");	
		
		//getInstance - ���������� ������ Calendar  ��� ������ �������� ����� �� ���������
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.roll(Calendar.DATE, -N);//���� ������

		IQuotesStorage storage = new QuoteStorage();//������� ���������
		Random generator = new Random();
		for (int i = 0; i < N; i++) {
			String symbol = SYMBOLS [generator.nextInt(2)];
			calendar.roll(Calendar.DAY_OF_YEAR, 1);//���� ����
			Date date = calendar.getTime();
			double openPrice = generator.nextDouble();
			double highPrice = generator.nextDouble();
			double lowPrice = generator.nextDouble();
			double closePrice = generator.nextDouble();
			int volume = (int) (1000000 * generator.nextDouble());
			IQuote quote = new Quote(symbol, date, openPrice, highPrice, lowPrice, closePrice, volume);
			storage.addQuote(quote);
			System.out.println(quote);//����� ���������		
		}
		System.out.println(storage);
		System.out.println("Program finished.");
	}

}
