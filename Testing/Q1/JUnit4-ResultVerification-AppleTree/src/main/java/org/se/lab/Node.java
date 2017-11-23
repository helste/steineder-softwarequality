package org.se.lab;

import java.util.List;

public abstract class Node
{
	/*
	 * Property: id
	 */
	private int id;
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}

	
	/*
	 * Navigation methods
	 */
	public void addNode(Node node)
	{
		throw new UnsupportedOperationException();
	}
	
	public List<Node> getNodes()
	{
		throw new UnsupportedOperationException();
	}
}
