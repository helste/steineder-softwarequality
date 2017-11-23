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
	
	
	@Test
	public void testTree2()
	{
		Node expected = createExpectedTree();
		
		assertEquals(expected, tree);
	}

	
	
	private void assertEquals(Node expected , Node actual)
	{
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);

		Assert.assertEquals(expected.getClass(), actual.getClass());

		if(expected instanceof Branch)
		{
			assertEquals((Branch) expected , (Branch) actual);
		}
		else if(expected instanceof GreenApple)
		{
			assertEquals((GreenApple) expected , (GreenApple) actual);
		}
		else if(expected instanceof RedApple)
		{
			assertEquals((RedApple) expected , (RedApple) actual);
		}
	}
	
	private void assertEquals(Branch expected , Branch actual)
	{
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getNodes().size(), actual.getNodes().size());
		int size = expected.getNodes().size();
		for(int i=0; i< size; i++)
		{
			assertEquals(expected.getNodes().get(i), actual.getNodes().get(i));
		}
	}

	private void assertEquals(GreenApple expected , GreenApple actual)
	{
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		
		Assert.assertEquals(expected.getId(), actual.getId());
	}

	private void assertEquals(RedApple expected , RedApple actual)
	{
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		
		Assert.assertEquals(expected.getId(), actual.getId());
	}

	private Node createExpectedTree()
	{
		Node tree = null;

		Node n3 = new Branch(1);
		n3.addNode(new GreenApple(2));
//		n3.addNode(new GreenApple(3));
		n3.addNode(new RedApple(3));
		
		Node n1 = new Branch(4);
		n1.addNode(new RedApple(5));
		n1.addNode(n3);
		
		Node n4 = new Branch(6);
		n4.addNode(new GreenApple(7));
		n4.addNode(new RedApple(8));
//		n4.addNode(new RedApple(9));
		
		Node n2 = new Branch(9);
		n2.addNode(n4);
		n2.addNode(new RedApple(10));
//		n2.addNode(new GreenApple(10));
		
		tree = new Branch(11);
		tree.addNode(n1);
		tree.addNode(n2);

		return tree;
	}
}
