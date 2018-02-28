package com.fastdev.djibril.quizz.activity;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.fastdev.djibril.quizz.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class PageFirst extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

      /*  if(sp.contains("username") && sp.contains("password")){
            startActivity(new Intent(MainActivity.this,HomePage.class));
            finish();   //finish current activity
        }*/

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorAccent);
        configSplash.setAnimCircularRevealDuration(3000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);


        //Customize Logo
        configSplash.setLogoSplash(R.drawable.quizzc);
        configSplash.setAnimLogoSplashDuration(5000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);


        //Customize Title
        configSplash.setTitleSplash("Tamsir & Djibril");
        configSplash.setTitleTextColor(R.color.colorBlg);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.Landing);

    }

    @Override
    public void animationsFinished() {


        Intent intent =new Intent(this,Create_cmpt.class);
        startActivity(intent);
        finish();


    }

}
