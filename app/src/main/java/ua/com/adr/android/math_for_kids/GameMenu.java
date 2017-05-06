package ua.com.adr.android.math_for_kids;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GameMenu extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        final TextView title = (TextView)findViewById(R.id.title);
        title.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/ArbatC.otf"));

        final TextView level1 = (TextView)findViewById(R.id.level1);
        level1.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/ArbatC.otf"));

        final TextView level2 = (TextView)findViewById(R.id.level2);
        level2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/ArbatC.otf"));

        final TextView level3 = (TextView)findViewById(R.id.level3);
        level3.setTypeface(Typeface.createFromAsset(
                getAssets(), "fonts/ArbatC.otf"));

        final TextView level4 = (TextView)findViewById(R.id.level4);
        level4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/ArbatC.otf"));

        final TextView exit = (TextView)findViewById(R.id.exit);
        exit.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/ArbatC.otf"));
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.level1:
                Intent intent = new Intent();
                intent.setClass(this, Level1.class);
                startActivity(intent);
                break;
            case R.id.level2:
                Intent intent2 = new Intent();
                intent2.setClass(this, Level2.class);
                startActivity(intent2);
                break;
            case R.id.level3:
                Intent intent3 = new Intent();
                intent3.setClass(this, Level3.class);
                startActivity(intent3);
                break;
            case R.id.level4:
                Intent intent4 = new Intent();
                intent4.setClass(this, Level4.class);
                startActivity(intent4);
                break;
            case R.id.exit:
                finishAll();
                break;
            default:
                break;
        }

    }
public void finishAll() {
    finishAffinity();
}
    @Override
    public void onBackPressed() {
    }

}
