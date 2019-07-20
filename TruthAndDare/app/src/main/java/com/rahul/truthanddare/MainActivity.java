package com.rahul.truthanddare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random;
    float lastDirection  = 0;
    ImageView image;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         image = findViewById(R.id.spinBottle);
        Button btn = findViewById(R.id.buttonSpin);


    }
    public void spin(View view){

        random = new Random();

        int newDirection = random.nextInt(3600);

        float pivoitX = image.getWidth()/2;

        float pivotY = image.getHeight()/2;

        //create object of animation class

        Animation rotate = new RotateAnimation(lastDirection,newDirection,pivoitX,pivotY);

        //amount of time to for the animation to run
        rotate.setDuration(2000);

        //When set to true, the animation transformation is applied after the animation is over
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
              //  button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
              //  button.setEnabled(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lastDirection = newDirection;
        //set animation on image
        image.startAnimation(rotate);
    }
}
