package ua.com.adr.android.math_for_kids;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Records2 extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sPref;
    final String SAVED_SCORE = "saved_score";
    Button btnBack, btnClear;
    int scores;
    int savedScore;
    TextView hiscore, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        total = (TextView) findViewById(R.id.textView33);
        hiscore = (TextView) findViewById(R.id.hiscore);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            scores = bundle.getInt("Score2");
            total.setText("ПОЗДРАВЛЯЕМ!" + "\n" +"Вы набрали" + "\n" + scores*10 + " очков");
            total.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        sPref = getPreferences(MODE_PRIVATE);
        String testText = sPref.getString(SAVED_SCORE, "");
        if (testText.equals("")){
            savedScore = 0;
        }
        else {
            savedScore = Integer.parseInt(loadText());
        }
        if (savedScore < scores*10){
            hiscore.setText("Рекорд на втором уровне:" + "\n" + scores*10 + " очков");
            saveText(scores*10);
        }
        else {
            hiscore.setText("Рекорд на втором уровне:" + "\n" + savedScore + " очков");
        }

        btnBack = (Button) findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBack:
                Intent intent = new Intent();
                intent.setClass(this, GameMenu.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonClear:
                saveText(0);
                hiscore.setText("Рекорд на втором уровне:" + "\n" + 0 + " очков");
                break;
            default:
                break;
        }
    }
    void saveText(int score) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_SCORE, Integer.toString(score));
        ed.commit();

    }
    String loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_SCORE, "");
        return savedText;

    }
    @Override
    public void onBackPressed() {
    }

}


