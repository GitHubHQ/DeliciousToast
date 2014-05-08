package com.example.delicioustoast;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	long[] vibe = {30000};
	int onOff=0;
	MediaPlayer m;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		ImageView yuri = (ImageView) findViewById(R.id.Yuri);
		m = MediaPlayer.create(getApplicationContext(), R.raw.clip);

		yuri.setOnLongClickListener(new OnLongClickListener() {

			public boolean onLongClick(View v) {
				set_notification(v);
				showToast(v);
				return true;
			}
		});




		return true;

	}

	public void showToast(View view){
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.toasty, (ViewGroup) findViewById(R.id.toasty_toast));
		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
	}
	
	public void set_notification(View view){
		Notification.Builder notBuilder = new Notification
				.Builder(getApplicationContext())
		.setTicker("Saranghae <3")
		.setSmallIcon(android.R.drawable.btn_star)
		.setContentTitle("Saranghae <3")
		.setContentText("I Love You <3")
		.setVibrate(vibe);

		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		manager.notify(1, notBuilder.build());
		
		if(onOff==0){
		m.start();
		onOff++;
		}else{
			m.stop();
			onOff--;
		}
		

	}
}
