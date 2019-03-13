package at.tugraz.ist.swe.stopwatch;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
	@Rule
	public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testButtonsVisible() {
		onView(withId(R.id.bt_reset)).check(matches(isDisplayed()));
		onView(withId(R.id.bt_start)).check(matches(isDisplayed()));
		onView(withId(R.id.bt_lap)).check(matches(isDisplayed()));
	}
}
