package com.example.alanwhitten.moodscanner;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView thumbprint;
    private TextView result;
    private Runnable mRunnable;
    private AnimationDrawable thumbAnimation;
    private String[] moodResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodResults = new String[]{
                "Someone is cranky",
                "You are my sunshine",
                "No comment.....",
                "You're stressed out",
                "Happy camper :)",
                "Not your day :(",
                "Smile it's good for you",
                "In the clouds",
                "Pensive",
                "Sad",
                "Excited"
        };

        thumbprint = (ImageView)findViewById(R.id.tumbPrint);
        thumbprint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable) thumbprint.getBackground();

        result = (TextView)findViewById(R.id.Result);

        thumbprint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                thumbAnimation.start();

                showResult();

                return false;
            }
        });
    }

    public void showResult(){

        mRunnable = new Runnable() {
            @Override
            public void run() {

                int rand  = (int) (Math.random() * moodResults.length);
                result.setText(moodResults[rand]);

                thumbAnimation.stop();
            }
        };

        //method that delays runnable to allow animation to take place
        Handler mHadler = new Handler();
        mHadler.postDelayed(mRunnable, 5000);//5 sec delay
    }
}
