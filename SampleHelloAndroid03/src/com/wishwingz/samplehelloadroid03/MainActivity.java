package com.wishwingz.samplehelloadroid03;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView showTextView;
	Button btn;
	int state = 0; //0이면 계산, 1이면 plus
	boolean restart = true;
	String previous = "0";
	String previousValue = "0";
	String sum = "0";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);

		showTextView = (TextView) findViewById(R.id.sum);

		View.OnClickListener handler = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				switch (v.getId()) {
				case R.id.button0:
					showNumber("0");
					break;
				case R.id.button1:
					showNumber("1");
					break;
				case R.id.button2:
					showNumber("2");
					break;
				case R.id.button3:
					showNumber("3");
					break;
				case R.id.button4:
					showNumber("4");
					break;
				case R.id.button5:
					showNumber("5");
					break;
				case R.id.button6:
					showNumber("6");
					break;
				case R.id.button7:
					showNumber("7");
					break;
				case R.id.button8:
					showNumber("8");
					break;
				case R.id.button9:
					showNumber("9");
					break;
				case R.id.reset:
					reset();
					break;
				case R.id.plus:
					plus();
					break;
				case R.id.result:
					done();
					break;
				}
			}
		};

		findViewById(R.id.button0).setOnClickListener(handler);
		findViewById(R.id.button1).setOnClickListener(handler);
		findViewById(R.id.button2).setOnClickListener(handler);
		findViewById(R.id.button3).setOnClickListener(handler);
		findViewById(R.id.button4).setOnClickListener(handler);
		findViewById(R.id.button5).setOnClickListener(handler);
		findViewById(R.id.button6).setOnClickListener(handler);
		findViewById(R.id.button7).setOnClickListener(handler);
		findViewById(R.id.button8).setOnClickListener(handler);
		findViewById(R.id.button9).setOnClickListener(handler);
		findViewById(R.id.reset).setOnClickListener(handler);
		findViewById(R.id.plus).setOnClickListener(handler);
		findViewById(R.id.result).setOnClickListener(handler);

	}

	protected void showNumber(String num) {
		if (restart) {
			previous = num;
			restart = false;
		} else {
			previous = previous.concat(num);
		}
		showTextView.setText(previous);
	}

	protected void plus() {
		restart = true;
		state = 1;
		String num = showTextView.getText().toString();
		sum = String.valueOf((Integer.parseInt(num) + Integer.parseInt(previousValue)));
		showTextView.setText(sum);
		previousValue = sum;
	}

	protected void done() {
		restart = true;
		if(state == 1){
			sum = String.valueOf(Integer.parseInt(previousValue)	+ Integer.parseInt(showTextView.getText().toString()));
		}else {
			return;
		}
		showTextView.setText(sum);
		previousValue = "0";
		sum = "0";
	}

	protected void reset() {
		restart = true;
		state = 0;
		sum = "0";
		previousValue = "0";
		showTextView.setText("0");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
