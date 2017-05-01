package ua.com.adr.android.math_for_kids;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Level1 extends AppCompatActivity  {
    int genA, genB, genAPrew, genBPrew;

    private Button mNextButton;
    private TextView mQuestionTextView;
    private Controller mController;

    final CounterClass count = new CounterClass(70000, 1000);
    EditText etNum;
    TextView tvResult;
    TextView result, timer;
    private int answer = 0;
    int num = -100;
    private int mCurrentIndex = 0;
    private int rightAnswers = 0;

    private void updateQuestion(int mCurrentIndex) {

        result.setText("Ответов правильно/всего:  "+ rightAnswers + "/" + mCurrentIndex);
        etNum.setText("");

        genA = rnd();
        genB = rnd();
        System.out.println("A1 = " + genA + " B1 = " + genB);
        if (genA == genAPrew && genB == genBPrew) {
            do {
                genA = rnd();
                genB = rnd();

            }
            while ((genA != genAPrew) || (genB != genBPrew));
        }
        int znak = minusPlus();
        System.out.println("znak = " + znak);
        if (znak < 4) {
            System.out.println("A2 = " + genA + " B2 = " + genB);
            tvResult.setText(genA + "+" + genB + "=");
            answer = genA + genB;
        } else if (znak >= 4) {
            System.out.println("A2 = " + genA + " B2 = " + genB);
            if (genA < genB) {
                int tmp = genA;
                genA = genB;
                genB = tmp;
            }

            tvResult.setText(genA + "-" + genB + " = ");
            answer = genA - genB;
        }
        genAPrew = genA;
        genBPrew = genB;
        genA = 0;
        genB = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        etNum = (EditText) findViewById(R.id.answer1);
        tvResult = (TextView) findViewById(R.id.prim1);
        timer = (TextView) findViewById(R.id.timer);
        result = (TextView) findViewById(R.id.result);

        mController = new Controller(etNum);
        genA = rnd();
        genB = rnd();

        tvResult.setText(genA + "+" + genB + "=");
        answer = genA + genB;

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1);
                // читаем EditText и заполняем переменные числами
                if (!etNum.getText().toString().equals("")) {
                    num = Integer.parseInt(etNum.getText().toString());
                }
                if (num == answer) {
                    rightAnswers++;
                }
                updateQuestion(mCurrentIndex);
            }
        });
        count.start();
    }


    public int rnd() {
       return (int)(Math.random() *10)+1;
    }
    public int minusPlus() {
        return (int)(Math.random() *10);
    }

    public class CounterClass extends CountDownTimer {


        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText("" + millisUntilFinished / 1000);
            timer.setTextColor(Color.RED);
        }

        @Override
        public void onFinish() {
            calculate();
        }

    }
    public void calculate() {

        Intent i = new Intent(Level1.this, Records.class);

        i.putExtra("Score", rightAnswers);
        startActivity(i);
    }

    public void buttonClick(View view) {
        mController.buttonClickAll(view);
    }
}
