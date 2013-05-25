package ru.susu.vmi.task1.model;

/**
 *  импорт класса Дата
 */

import java.util.Date;
 
/**
 * интерфейс, описывающий абстрактную биржевую котировку
 */
public interface IQuote 
	extends Comparable<IQuote>//extends - расширяет интерфейс IQuote (наследование )
//классы реализ-ие comparable содержат объекты котор можно сравнивать
	{
	
	/**
	 *  Строка, которая представляет символ котировки
	 */
	public String getSymbol();
	
	/**
	 *  Дата, которая представляет время котировки
	 */
	public Date getDate();

	/**
	 * низкая цена акций
	 */
	double getLowPrice();//double - представления чисел, имеющих дробную часть

	/**
	 * открыть цену акции
	 */
	double getOpenPrice();

	/**
	 * высокая цена акций
	 */
	double getHighPrice();

	/**
	 * закрыть цену акций
	 */
	double getClosePrice();
	
	/**
	 * объём акций
	 */
	int getVolume();


}
