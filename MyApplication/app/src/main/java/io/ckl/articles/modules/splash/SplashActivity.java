package io.ckl.articles.modules.splash;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import io.ckl.articles.R;
import io.ckl.articles.modules.base.BaseActivity;
import io.ckl.articles.modules.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashInterfaces.View {

    SplashInterfaces.Presenter splashPresenter = new SplashPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashPresenter.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d("onConfChanged", "Splash Changed!");
    }

    //region MainInterfaces.View

    @Override
    public void startMainActivity()
    {
        startActivity(new Intent(this, MainActivity.class));

        overridePendingTransition(R.anim.main_in, R.anim.splash_out);
        finish();
    }

    //end region
}