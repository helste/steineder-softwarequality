package org.se.lab;

public class IntegerSequence
{
	protected IntegerSequence() {}
	
	private static int sequence = 1;
	
	public static synchronized int nextValue()
	{
		return sequence++;
	}
	
	public static synchronized void setValue(int value)
	{
		sequence = value;
	}
}
