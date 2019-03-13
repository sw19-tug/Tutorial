package at.tugraz.ist.swe.stopwatch;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

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

	@Test
	public void testClockTextViewVisible() {
		onView(withId(R.id.tv_clock)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_clock)).check(matches(withText("0:00:00")));
	}

	@Test
	public void testClockTextViewElapsesTime() throws InterruptedException {
		onView(withId(R.id.bt_start)).perform(click());

		Thread.sleep(100);
		onView(withId(R.id.tv_clock)).check(matches(not(withText("0:00:00"))));

		TextView textView = activityTestRule.getActivity().findViewById(R.id.tv_clock);
		String currentElapsedTime = textView.getText().toString();

		Thread.sleep(100);
		onView(withId(R.id.tv_clock)).check(matches(not(withText(currentElapsedTime))));
	}
}
