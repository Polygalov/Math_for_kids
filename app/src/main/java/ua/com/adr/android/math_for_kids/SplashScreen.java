package ua.com.adr.android.math_for_kids;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by Andy on 18.03.2017.
 */

public class SplashScreen extends Activity {

    /**
     * Поток для обработки сообщений заставки
     */
    private Thread mSplashThread;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Лэйаут заставки
        setContentView(R.layout.splash);

        final SplashScreen sPlashScreen = this;
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        // Поток для ожидания событий заставки
        mSplashThread =  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        // Ждем некоторое время, или выход по прикосновению
                        wait(5000);
                    }
                }
                catch(InterruptedException ex){
                }

                finish();

                // Запускаем основную форму
                Intent intent = new Intent();
                intent.setClass(sPlashScreen, GameMenu.class);
                startActivity(intent);

            }
        };

        mSplashThread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized(mSplashThread){
                mSplashThread.notifyAll();
            }
        }
        return true;
    }
}
