package collections.nvm.cookbook.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import collections.nvm.cookbook.R;

public class StartActivity extends AppCompatActivity {

    private static final int resLogo = R.drawable.app_logo;
    private static final int resPresent = R.drawable.lnp_present;

    private Thread mThread;
    private ImageView ivLogo;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        ivLogo.setImageResource(resPresent);

        animation = new AlphaAnimation(1, 0);
        animation.setDuration(400);
        animation.setInterpolator(new LinearInterpolator());
//        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatCount(5);
        animation.setRepeatMode(Animation.REVERSE);

        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivLogo.startAnimation(animation);
                    }
                });
                ///////////////////////////////////////
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //////////////////////////////////
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivLogo.setImageResource(resLogo);
                    }
                });
                ///////////////////////////////
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(StartActivity.this, FoodListActivity.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                });
            }
        });
        mThread.start();
    }
}
