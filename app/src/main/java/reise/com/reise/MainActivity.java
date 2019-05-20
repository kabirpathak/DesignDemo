package reise.com.reise;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    long animationDuration = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
       animationHandle();

    }

    public void openLogin(View v){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void animationHandle(){

        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(imageView, View.ALPHA, 0.0f, 1.0f);
        alphaAnimator.setDuration(animationDuration);

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView, "y", 500f);
        animatorY.setDuration(animationDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaAnimator);
        animatorSet.start();
        animatorSet.play(animatorY);
        animatorSet.start();



    }
}
