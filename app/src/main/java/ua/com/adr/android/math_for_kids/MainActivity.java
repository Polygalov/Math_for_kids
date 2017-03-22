package ua.com.adr.android.math_for_kids;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int genA, genB, genC, genD, res1, res2;
    ArrayList<Integer> results = new ArrayList<Integer>();
    List<TextView> spisok;
    List<Integer> otvet;
    EditText etNum1, etNum2, etNum3, etNum4, etNum5, etNum6, etNum7, etNum8, etNum9, etNum10;

    Button btnCheck;

    final CounterClass count = new CounterClass(60000, 1000);

    TextView tvResult, tvResult2, tvResult3, tvResult4, tvResult5, tvResult6, tvResult7, tvResult8, tvResult9, tvResult10;
    TextView total, timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим элементы
        etNum1 = (EditText) findViewById(R.id.answer1);
        etNum2 = (EditText) findViewById(R.id.answer2);
        etNum3 = (EditText) findViewById(R.id.answer3);
        etNum4 = (EditText) findViewById(R.id.answer4);
        etNum5 = (EditText) findViewById(R.id.answer5);
        etNum6 = (EditText) findViewById(R.id.answer6);
        etNum7 = (EditText) findViewById(R.id.answer7);
        etNum8 = (EditText) findViewById(R.id.answer8);
        etNum9 = (EditText) findViewById(R.id.answer9);
        etNum10 = (EditText) findViewById(R.id.answer10);

        btnCheck = (Button) findViewById(R.id.button);

        tvResult = (TextView) findViewById(R.id.prim1);
        tvResult2 = (TextView) findViewById(R.id.prim2);
        tvResult3 = (TextView) findViewById(R.id.prim3);
        tvResult4 = (TextView) findViewById(R.id.prim4);
        tvResult5 = (TextView) findViewById(R.id.prim5);
        tvResult6 = (TextView) findViewById(R.id.prim6);
        tvResult7 = (TextView) findViewById(R.id.prim7);
        tvResult8 = (TextView) findViewById(R.id.prim8);
        tvResult9 = (TextView) findViewById(R.id.prim9);
        tvResult10 = (TextView) findViewById(R.id.prim10);

        spisok = asList(tvResult, tvResult2, tvResult3, tvResult4, tvResult5, tvResult6, tvResult7, tvResult8, tvResult9, tvResult10);
        total = (TextView) findViewById(R.id.total);
        timer = (TextView) findViewById(R.id.timer);


        count.start();

        // прописываем обработчик
        btnCheck.setOnClickListener(this);

        for (int i = 0; i < 5; i++) {
            genA = rnd();
            genB = rnd();

            spisok.get(i).setText(genA + " +  " + genB + " = ");
            results.add(genA + genB);

        }
        for (int i = 5; i < 10; i++) {
            genA = rnd();
            genB = rnd();
            if (genA < genB) {
                int tmp = genA;
                genA = genB;
                genB = tmp;
            }

            spisok.get(i).setText(genA + " -  " + genB + " = ");
            results.add(genA - genB);


        }
    }
    public int rnd() {
       return (int)(Math.random() *10)+1;
    }

    public void onClick(View v) {
        calculate();

    }
    public void calculate(){
        int num1 = -1, num2 = -1, num3 = -1, num4 = -1, num5 = -1, num6 = -1, num7 = -1, num8 = -1, num9 = -1, num10 = -1;

        int result = 0;

        // читаем EditText и заполняем переменные числами
        if (!etNum1.getText().toString().equals("")) {
            num1 = Integer.parseInt(etNum1.getText().toString());
        }
        if (!etNum2.getText().toString().equals("")) {
        num2 = Integer.parseInt(etNum2.getText().toString()); }
        if (!etNum3.getText().toString().equals("")) {
        num3 = Integer.parseInt(etNum3.getText().toString()); }
        if (!etNum4.getText().toString().equals("")) {
        num4 = Integer.parseInt(etNum4.getText().toString()); }
        if (!etNum5.getText().toString().equals("")) {
        num5 = Integer.parseInt(etNum5.getText().toString()); }
        if (!etNum6.getText().toString().equals("")) {
        num6 = Integer.parseInt(etNum6.getText().toString()); }
        if (!etNum7.getText().toString().equals("")) {
        num7 = Integer.parseInt(etNum7.getText().toString()); }
        if (!etNum8.getText().toString().equals("")) {
        num8 = Integer.parseInt(etNum8.getText().toString()); }
        if (!etNum9.getText().toString().equals("")) {
        num9 = Integer.parseInt(etNum9.getText().toString()); }
        if (!etNum10.getText().toString().equals("")) {
        num10 = Integer.parseInt(etNum10.getText().toString()); }

        otvet = asList(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10);

        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе
        for (int i = 0; i<10; i++) {
            if (results.get(i) == otvet.get(i)) {
                result++;
            }
        }


        // формируем строку вывода
        total.setText("Правильных ответов: " + result);
        count.cancel();
    }

    public class CounterClass extends CountDownTimer {


        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText("" + millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
            calculate();
        }

    }

}
