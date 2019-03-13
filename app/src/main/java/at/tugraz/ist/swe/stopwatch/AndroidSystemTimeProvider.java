package at.tugraz.ist.swe.stopwatch;

import android.os.SystemClock;
import android.provider.Settings;

class AndroidSystemTimeProvider implements SystemTimeProvider {
	@Override
	public long getElapsedRealtime() {
		return SystemClock.elapsedRealtime();
	}
}
