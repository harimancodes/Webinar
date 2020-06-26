package com.example.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add;
    TextView answer;

    int x, y, sum;

    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        add = findViewById(R.id.button_add);
        answer = findViewById(R.id.Answer_txt_view);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag) {
                    if (String.valueOf(num1.getText()).isEmpty()) {
                        num1.setError("This field cannot be empty!");

                        return;
                    }
                    if (String.valueOf(num2.getText()).isEmpty()) {
                        num2.setError("This field cannot be empty!");
                        return;

                    }
                    if (String.valueOf(num1.getText()).length() > 6) {
                        num1.setError("maximum 6 digit!");
                        return;
                    }
                    if (String.valueOf(num2.getText()).length() > 6) {
                        num2.setError("maximum 6 digit!");
                        return;
                    }


                    x = Integer.parseInt(String.valueOf(num1.getText()));
                    y = Integer.parseInt(String.valueOf(num2.getText()));

                    sum = x + y;

                    add.setText(R.string.Reset);
                    num1.setEnabled(false);
                    num2.setEnabled(false);
                    answer.setText(String.valueOf(sum));
                    flag = false;
                } else {
                    num1.setText(null);
                    num2.setText(null);

                    num1.setEnabled(true);
                    num2.setEnabled(true);

                    add.setText(R.string.Add);
                    answer.setText(null);

                    flag = true;
                }
            }
        });

    }
}
