package ru.susu.vmi.task1;

//import java.text.NumberFormat;
import java.util.Calendar;//абстр класс представ набор методов, 
//позволяющ преобр время в милисекундах во мн-во удобных компонент
import java.util.Date;//Базовый класс для хранения даты 
import java.util.Random;//генератор случайных чисел

import ru.susu.vmi.task1.model.IQuote;
import ru.susu.vmi.task1.model.IQuotesStorage;
import ru.susu.vmi.task1.model.Quote;
import ru.susu.vmi.task1.model.QuoteStorage;

public class TestQuotesStorage {

	/**
	 * статические финальные переменные
	 */
	public static final String[] SYMBOLS = {"YHOO", "CSCO"};
	
	public static final int N = 100;
	/**
	 * метод main, в котором происходит наполнение IQuotesStorage
данными с помощью генератора случайных чисел Random и тестирование всех
методов интерфейсов.
	 */
	public static void main(String[] args) {
		//NumberFormat nf = NumberFormat.getInstance();
		//nf.setMaximumFractionDigits(2);
		
		System.out.println("Quotes Storage testing started..");	
		
		//getInstance - возвращает объект Calendar  для локали часового пояса по умолчанию
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.roll(Calendar.DATE, -N);//день месяца

		IQuotesStorage storage = new QuoteStorage();//создали хранилище
		Random generator = new Random();
		for (int i = 0; i < N; i++) {
			String symbol = SYMBOLS [generator.nextInt(2)];
			calendar.roll(Calendar.DAY_OF_YEAR, 1);//день года
			Date date = calendar.getTime();
			double openPrice = generator.nextDouble();
			double highPrice = generator.nextDouble();
			double lowPrice = generator.nextDouble();
			double closePrice = generator.nextDouble();
			int volume = (int) (1000000 * generator.nextDouble());
			IQuote quote = new Quote(symbol, date, openPrice, highPrice, lowPrice, closePrice, volume);
			storage.addQuote(quote);
			System.out.println(quote);//вывод катировок		
		}
		System.out.println(storage);
		System.out.println("Program finished.");
	}

}
