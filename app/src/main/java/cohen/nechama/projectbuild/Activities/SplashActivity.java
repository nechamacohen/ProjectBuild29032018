package cohen.nechama.projectbuild.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cohen.nechama.projectbuild.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        animate();
    }

    private void animate() {
        ivLogo = findViewById(R.id.ivLogo);
        ivLogo.animate().setDuration(3000).rotation(360);
    }

    @Override
    protected void onResume() {
        super.onResume();
        animate();
        //gets the current user:
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if (user == null) {
            //We need to Register
            goActivity(RegisterActivity.class);

        } else {
            //Building
            goActivity(MenuActivity.class);
        }
//        Boolean checkRegister = false;
//        if (checkRegister==false){
//            Handler h = new Handler();
//            h.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent gotologin = new Intent(SplashActivity.this,RegisterActivity.class);
//                    startActivity(gotologin);
//                }
//            }, 3000);
//            checkRegister=true;
//        } else {
//            Handler h = new Handler();
//            h.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent gotologin = new Intent(SplashActivity.this,LoginActivity.class);
//                    startActivity(gotologin);
//                }
//            }, 3000);
//        }


    }

    private void goActivity(final Class activityClass) {
        animate();
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent go = new Intent(SplashActivity.this, activityClass);
                startActivity(go);
            }
        }, 3000);
    }
}
