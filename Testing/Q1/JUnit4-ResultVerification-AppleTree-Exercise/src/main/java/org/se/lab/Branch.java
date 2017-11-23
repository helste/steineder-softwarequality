package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Node
{
	public Branch(int id)
	{
		setId(id);
	}
	
	
	/*
	 * Navigation
	 */
	private List<Node> nodes = new ArrayList<Node>();
	@Override
	public void addNode(Node node)
	{
		if(node == null)
			throw new IllegalArgumentException();
		nodes.add(node);
	}	
	@Override
	public List<Node> getNodes()
	{
		return nodes;
	}
}
