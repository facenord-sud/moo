package dispenser;

/**
 * A test class for the dispenser.
 * 
 * @author Andreas Ruppen
 */
public class DispenserTest {

	/**
	 * Tests the dispenser.
	 */
	public static void main(String[] args) {
		Dispenser<Integer> testDispenser;
		Dispenser<String> testDispenser1, testDispenser2;
		DispenserFactory dispenserFactory = DispenserFactory.getInstance();

		// Test the stack implementation using ArrayStack.

		dispenserFactory.setStackClass("dispenser.stack.ArrayStack");
		testDispenser = dispenserFactory.createStack();
		testArrayStack(testDispenser);
		
		testDispenser1 = dispenserFactory.createStack();
		testDispenser2 = dispenserFactory.createStack();
		ultimateTest(testDispenser1, testDispenser2);

		// Test the stack implementation using LinkedListStack.
		dispenserFactory.setStackClass("dispenser.stack.LinkedListStack");
		testDispenser = dispenserFactory.createStack();
		testLinkedListStack(testDispenser);

		dispenserFactory.setQueueClass("dispenser.queue.ArrayQueue");
		testDispenser = dispenserFactory.createQueue();
		testArrayQueue(testDispenser);

		// Test the queue implementation using LinkedListQueue.
		dispenserFactory.setQueueClass("dispenser.queue.LinkedListQueue");
		testDispenser = dispenserFactory.createQueue();
		testLinkedListQueue(testDispenser);

		// Test the queue implementation using ArrayCircularQueue.
		dispenserFactory.setQueueClass("dispenser.queue.ArrayCircularQueue");
		testDispenser = dispenserFactory.createQueue();
		testArrayCircularQueue(testDispenser);
		
		testDispenser1 = dispenserFactory.createQueue();
		testDispenser2 = dispenserFactory.createQueue();
		ultimateTest(testDispenser1, testDispenser2);
	}

	private static void testArrayQueue(Dispenser<Integer> testDispenser) {
		System.out.println();
		System.out.println("Queue implementation using ArrayQueue:");
		try {
		System.out.println("put (42)");
			testDispenser.put(42);
			System.out.println("put (68)");
			testDispenser.put(68);
			System.out.println("put (111)");
			testDispenser.put(111);
			System.out.println("put (13)");
			testDispenser.put(13);
		} catch (DispenserOverflowException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("item: " + testDispenser.item());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
		} catch (EmptyDispenserException e) {
			e.printStackTrace();
		}
	}

	private static void testLinkedListQueue(Dispenser<Integer> testDispenser) {
		System.out.println();
		System.out.println("Queue implementation using LinkedListQueue:");
		try {
			System.out.println("put (42)");
			testDispenser.put(42);
			System.out.println("put (68)");
			testDispenser.put(68);
			System.out.println("put (111)");
			testDispenser.put(111);
			System.out.println("put (13)");
			testDispenser.put(13);
		} catch (DispenserOverflowException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("item: " + testDispenser.item());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
		} catch (EmptyDispenserException e) {
			e.printStackTrace();
		}
	}

	private static void testArrayCircularQueue(Dispenser<Integer> testDispenser) {
		System.out.println();
		System.out.println("Queue implementation using ArrayCircularQueue:");
		try {
			System.out.println("put (42)");
			testDispenser.put(42);
			System.out.println("put (68)");
			testDispenser.put(68);
			System.out.println("put (111)");
			testDispenser.put(111);
			System.out.println("put (13)");
			testDispenser.put(13);
			System.out.println("put (15)");
			testDispenser.put(15);
		} catch (DispenserOverflowException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("item: " + testDispenser.item());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
		} catch (EmptyDispenserException e) {
			e.printStackTrace();
		}
	}

	private static void testLinkedListStack(Dispenser<Integer> testDispenser) {
		System.out.println();
		System.out.println("Stack implementation using LinkedListStack:");
		try {
			System.out.println("put (42)");
			testDispenser.put(42);
			System.out.println("put (68)");
			testDispenser.put(68);
			System.out.println("put (111)");
			testDispenser.put(111);
		} catch (DispenserOverflowException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("item: " + testDispenser.item());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("item: " + testDispenser.item());
		} catch (EmptyDispenserException e) {
			e.printStackTrace();
		}
	}

	private static void testArrayStack(Dispenser<Integer> testDispenser) {
		System.out.println("Stack implementation using ArrayStack:");
		System.out.println("put (42)");
		try {
			testDispenser.put(42);
			System.out.println("put (68)");
			testDispenser.put(68);
			System.out.println("put (111)");
			testDispenser.put(111);
		} catch (DispenserOverflowException e1) {
			e1.printStackTrace();
		}

		try {
			System.out.println("item: " + testDispenser.item());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("item: " + testDispenser.item());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("remove: " + testDispenser.remove());
			System.out.println("isEmpty: " + testDispenser.isEmpty());
			System.out.println("item: " + testDispenser.item());
		} catch (EmptyDispenserException e) {
			e.printStackTrace();
		}
	}
	
	private static void ultimateTest(Dispenser<String> testDispenser1, Dispenser<String> testDispenser2)
	{
		System.out.println("**************Begin ultimate Test****************");
		try
		{
			testDispenser1.put("x7");
			testDispenser1.put("x6");
			testDispenser1.remove();
			
			testDispenser2.put("x5");
			testDispenser2.put("x4");
			testDispenser2.remove();
			
			
			testDispenser1.put(testDispenser2.item());
			
			testDispenser1.put("x2");
			testDispenser1.remove();
			testDispenser1.put("x1");
			testDispenser1.remove();
			System.out.println(testDispenser1.item());
			System.out.println("**************End ultimate Test****************");
		} catch (DispenserOverflowException e)
		{
			e.printStackTrace();
		} catch (EmptyDispenserException e)
		{
			e.printStackTrace();
		}
	}
}
