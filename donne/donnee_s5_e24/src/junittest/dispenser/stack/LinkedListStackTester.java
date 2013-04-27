package dispenser.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Test;

import dispenser.stack.EmptyStackException;
import dispenser.stack.LinkedListStack;

/**
 * @author <a href="mailto:andreas.ruppen@gmail.com"> Andreas Ruppen </a>
 * @date 24 avr. 07
 * 
 */
public class LinkedListStackTester
{
	private LinkedListStack<String>	as;

	@Before
	public void setUp()
	{
		as = new LinkedListStack<String>();
	}

	@Test
	public void putOnEmptyTest()
	{
		as.put("element");
		assertTrue(!as.isEmpty());
	}

	@Test(timeout = 10)
	public void slowPutTest()
	{
		as.slowPut("element");
		assertTrue(!as.isEmpty());
	}

	@Test
	public void removeTest()
	{
		String element = null;
		try
		{
			as.put("element");
			element = as.remove();
		} catch (EmptyStackException e)
		{
			e.printStackTrace();
		}
		assertEquals(element, "element");
		assertTrue(as.isEmpty());
	}

	@Test
	public void itemTest()
	{
		String element = null;
		try
		{
			as.put("element");
			element = as.item();
		} catch (EmptyStackException e)
		{
			e.printStackTrace();
		}
		assertEquals(element, "element");
		assertTrue(!as.isEmpty());
	}

	@Test
	public void emptyTest()
	{
		assertTrue(as.isEmpty());
	}

	@Test(expected = EmptyStackException.class)
	public void underFlowTest() throws EmptyStackException
	{
		as.remove();
		as.remove();
		fail("removed element from empty stack");
	}

}
