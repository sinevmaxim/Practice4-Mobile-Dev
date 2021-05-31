package ru.mirea.sinev.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView infoTextView;
    int lessonsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        infoTextView = findViewById(R.id.textView);
        Thread thread = new Thread(() -> {
            try {
                Random random = new Random(41974312);
                for (int i=0; i < 30; i++){
                    lessonsCount += random.nextInt(4);
                }
                String text = "В среднем " + lessonsCount / 30 + " пар";

                infoTextView.setText(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}