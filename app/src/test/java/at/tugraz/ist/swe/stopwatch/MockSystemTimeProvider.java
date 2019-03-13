package at.tugraz.ist.swe.stopwatch;

import java.util.Arrays;
import java.util.List;

public class MockSystemTimeProvider implements SystemTimeProvider {
	private List<Long> times = Arrays.asList(0L, 1000L, 2000L, 3000L, 4000L, 5000L);
	private int currentTimeIndex;
	@Override
	public long getElapsedRealtime() {
		return times.get(currentTimeIndex++ % times.size());
	}
}
