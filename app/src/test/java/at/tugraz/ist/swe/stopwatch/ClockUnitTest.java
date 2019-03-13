package at.tugraz.ist.swe.stopwatch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ClockUnitTest {

	@Test
	public void testInitialState() {
		Clock clock = new Clock();

		assertNotNull(clock);
		assertFalse(clock.isRunning());
		assertEquals(0L, clock.getElapsedTime());
		assertEquals("0:00:00", clock.getElapsedTimeString());
	}
}
