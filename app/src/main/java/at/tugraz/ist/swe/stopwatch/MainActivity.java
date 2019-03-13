package at.tugraz.ist.swe.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private Clock clock;
	private Handler handler;
	private TextView clockTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SystemTimeProvider systemTimeProvider = new AndroidSystemTimeProvider();
		clock = new Clock(systemTimeProvider);

		Button startButton = findViewById(R.id.bt_start);
		clockTextView = findViewById(R.id.tv_clock);

		startButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onStartClicked();
			}
		});

		handler = new Handler(getMainLooper());
	}

	private void onStartClicked() {
		clock.start();

		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				clockTextView.setText(clock.getElapsedTimeString());
			}
		}, 50);
	}
}
