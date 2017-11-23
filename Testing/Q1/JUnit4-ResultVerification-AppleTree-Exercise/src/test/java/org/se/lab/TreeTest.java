package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTest
{
	protected Node tree;
	
	@Before
	public void setup()
	{
		Node n3 = new Branch(1);
		n3.addNode(new GreenApple(2));
		n3.addNode(new RedApple(3));
		
		Node n1 = new Branch(4);
		n1.addNode(new RedApple(5));
		n1.addNode(n3);
		
		Node n4 = new Branch(6);
		n4.addNode(new GreenApple(7));
		n4.addNode(new RedApple(8));
		
		Node n2 = new Branch(9);
		n2.addNode(n4);
		n2.addNode(new RedApple(10));
		
		tree = new Branch(11);
		tree.addNode(n1);
		tree.addNode(n2);
	}

	
	@Test
	public void testTree()
	{
		Assert.assertEquals(11, tree.getId());
		Assert.assertEquals(2, tree.getNodes().size());
		
		Assert.assertEquals(4, tree.getNodes().get(0).getId());
		Assert.assertEquals(2, tree.getNodes().get(0).getNodes().size());
		Assert.assertEquals(5, tree.getNodes().get(0).getNodes().get(0).getId());
		Assert.assertEquals(1, tree.getNodes().get(0).getNodes().get(1).getId());
		Assert.assertEquals(2, tree.getNodes().get(0).getNodes().get(1).getNodes().size());
		Assert.assertEquals(2, tree.getNodes().get(0).getNodes().get(1).getNodes().get(0).getId());
		Assert.assertEquals(3, tree.getNodes().get(0).getNodes().get(1).getNodes().get(1).getId());
	
		Assert.assertEquals(9, tree.getNodes().get(1).getId());
		Assert.assertEquals(2, tree.getNodes().get(1).getNodes().size());
		Assert.assertEquals(6, tree.getNodes().get(1).getNodes().get(0).getId());
		Assert.assertEquals(2, tree.getNodes().get(1).getNodes().get(0).getNodes().size());
		Assert.assertEquals(7, tree.getNodes().get(1).getNodes().get(0).getNodes().get(0).getId());
		Assert.assertEquals(8, tree.getNodes().get(1).getNodes().get(0).getNodes().get(1).getId());
		Assert.assertEquals(10, tree.getNodes().get(1).getNodes().get(1).getId());
	}
}
