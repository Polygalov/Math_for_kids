package ua.com.adr.android.math_for_kids;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Andy on 30.04.2017.
 */

public class Controller {
    EditText entertText;

    public Controller(EditText editText) {
        entertText = editText;
    }

    public void buttonClickAll(View view) {


        switch (view.getId()) {


            case R.id.btnClear: { // кнопка очистить
                entertText.setText("");

                break;
            }


            case R.id.btnDelete: { // кнопка удаления последнего символа
                entertText.setText(entertText.getText().delete(
                        entertText.getText().length() - 1,
                        entertText.getText().length()));

                if (entertText.getText().toString().trim().length() == 0) {
                    entertText.setText("");
                }

                break;
            }

            default: { // все остальные кнопки (цифры)

                if (entertText.getText().toString().equals("0")
//                        ||

//                        (commands.containsKey(Symbol.FIRST_DIGIT) && getDouble(entertText
//                                .getText()) == getDouble(commands
//                                .get(Symbol.FIRST_DIGIT)))// если вводится второе
                    // число - то нужно
                    // сбросить текстовое
                    // поле

                        ) {

                    entertText.setText(view.getContentDescription().toString());
                } else {
                    entertText.setText(entertText.getText()
                            + view.getContentDescription().toString());
                }


            }

        }
    }
}
