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
    int scores, totalAnswer;
    int savedScore, num;
    TextView hiscore, total;
    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records2);
        total = (TextView) findViewById(R.id.textView33);
        hiscore = (TextView) findViewById(R.id.hiscore);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            scores = bundle.getInt("Score2");
            totalAnswer = bundle.getInt("total");
            if (totalAnswer == 0) {
                totalAnswer = 1;
            }
            int balls = scores * 100 / totalAnswer;
            if (totalAnswer < 5) {
                balls = balls / 2;
            }
            if (totalAnswer >= 5 && totalAnswer < 8) {
                balls = balls * 2 / 3;
            }
            if (totalAnswer >= 8 && totalAnswer < 10) {
                balls = balls * 3 / 4;
            }
            if (balls < 50) {
                num = 2;
                word = "Неудовлетворительно";
            } else if (balls >= 50 && balls <= 70) {
                num = 3;
                word = "Удовлетворительно";
            } else if (balls > 70 && balls <= 90) {
                num = 4;
                word = "Хорошо";
            } else if (balls > 90) {
                num = 5;
                word = "Отлично";
            }
            total.setText("ПОЗДРАВЛЯЕМ!" + "\n" + "Вы набрали" + "\n" + scores * 10 + " очков" + "\n" + "Ваша оценка - " + num + " (" + word + ")");
            total.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
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


