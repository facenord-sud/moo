package dispenser;

import java.util.logging.*;

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
		Dispenser<Integer> testStack = DispenserFactory.createStack();
		Logger loggingService = Logger.getLogger("DispenserTest");
		
		loggingService.info("put (42)");
		testStack.put(42);
		loggingService.info("put (68)");
		testStack.put(68);
		loggingService.info("put (111)");
		testStack.put(111);
		
		loggingService.info("item: " + testStack.item());
		loggingService.info("item: " + testStack.item());
		loggingService.info("remove: " + testStack.remove());
		loggingService.info("item: " + testStack.item());
		loggingService.info("remove: " + testStack.remove());
		loggingService.info("isEmpty: " + testStack.isEmpty());
		loggingService.info("remove: " + testStack.remove());
		loggingService.info("isEmpty: " + testStack.isEmpty());
	}
}
