package ru.susu.vmi.task1.model;

/**
 *  ������ ������ ����
 */

import java.util.Date;
 
/**
 * ���������, ����������� ����������� �������� ���������
 */
public interface IQuote 
	extends Comparable<IQuote>//extends - ��������� ��������� IQuote (������������ )
//������ ������-�� comparable �������� ������� ����� ����� ����������
	{
	
	/**
	 *  ������, ������� ������������ ������ ���������
	 */
	public String getSymbol();
	
	/**
	 *  ����, ������� ������������ ����� ���������
	 */
	public Date getDate();

	/**
	 * ������ ���� �����
	 */
	double getLowPrice();//double - ������������� �����, ������� ������� �����

	/**
	 * ������� ���� �����
	 */
	double getOpenPrice();

	/**
	 * ������� ���� �����
	 */
	double getHighPrice();

	/**
	 * ������� ���� �����
	 */
	double getClosePrice();
	
	/**
	 * ����� �����
	 */
	int getVolume();


}
