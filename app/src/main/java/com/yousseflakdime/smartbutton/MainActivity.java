package com.yousseflakdime.smartbutton;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Build;
import java.util.concurrent.TimeUnit;
import android.view.Menu;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;



@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {


    TextView counter;

      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        counter = (TextView)findViewById(R.id.counter);
        counter.setText("00:10:00");
          final CounterClass timer = new CounterClass(15000,1000);
          timer.start();

    }



     @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")


    public class CounterClass extends CountDownTimer {


        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            counter.setText("Resterende tijd: " + hms +  " sec.");
        }

        @Override
        public void onFinish() {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Tijd is om!",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
    }
}

