package com.example.digiitplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    int right = 0, wrong = 0;

    public CountDownTimer yourCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle i = getIntent().getExtras();
        int mode = i.getInt("mode");

        TextView timer = findViewById(R.id.timer);
        TextView textView1 = findViewById(R.id.textView12);

        yourCountDownTimer = new CountDownTimer(46000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                textView1.setText(R.string.timeUp);
                Intent i2 = new Intent(getApplicationContext(), ScoreActivity.class);

                i2.putExtra("correct", String.valueOf(right));
                i2.putExtra("incorrect", String.valueOf(wrong));
                i2.putExtra("mode", String.valueOf(mode));

                startActivity(i2);
                finish();
            }

        }.start();

        show(mode);
    }

    public void number(String n, int mode) {
        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView num2 = (TextView) findViewById(R.id.num2);
        TextView num3 = (TextView) findViewById(R.id.num3);

        String n1, n2, n3;

        n1 = num1.getText().toString();
        n2 = num2.getText().toString();
        n3 = num3.getText().toString();

        if (mode == 1 && n3.isEmpty())
            num3.setText(n);
        else if (mode == 2 && n2.isEmpty())
            num2.setText(n);
        else if (mode == 3) {
            if (n1.isEmpty())
                num1.setText(n);
            else if (n2.isEmpty())
                num2.setText(n);
        } else {
            if (n1.isEmpty())
                num1.setText(n);
            else if (n2.isEmpty())
                num2.setText(n);
            else if (n3.isEmpty())
                num3.setText(n);
        }
    }

    public void show(int mode) {
        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView num2 = (TextView) findViewById(R.id.num2);
        TextView num3 = (TextView) findViewById(R.id.num3);

        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);

        Button clear = findViewById(R.id.clear);

        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        five.setVisibility(View.VISIBLE);
        six.setVisibility(View.VISIBLE);
        seven.setVisibility(View.VISIBLE);
        eight.setVisibility(View.VISIBLE);
        nine.setVisibility(View.VISIBLE);

        num1.setText("");
        num2.setText("");
        num3.setText("");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("1", mode);
                one.setVisibility(View.INVISIBLE);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("2", mode);
                two.setVisibility(View.INVISIBLE);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("3", mode);
                three.setVisibility(View.INVISIBLE);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("4", mode);
                four.setVisibility(View.INVISIBLE);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("5", mode);
                five.setVisibility(View.INVISIBLE);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("6", mode);
                six.setVisibility(View.INVISIBLE);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("7", mode);
                seven.setVisibility(View.INVISIBLE);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("8", mode);
                eight.setVisibility(View.INVISIBLE);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number("9", mode);
                nine.setVisibility(View.INVISIBLE);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mode == 1)
                    num3.setText(null);
                else if (mode == 2)
                    num2.setText(null);
                else if (mode == 3) {
                    num1.setText(null);
                    num2.setText(null);
                } else {
                    num1.setText(null);
                    num2.setText(null);
                    num3.setText(null);
                }

                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.VISIBLE);
                three.setVisibility(View.VISIBLE);
                four.setVisibility(View.VISIBLE);
                five.setVisibility(View.VISIBLE);
                six.setVisibility(View.VISIBLE);
                seven.setVisibility(View.VISIBLE);
                eight.setVisibility(View.VISIBLE);
                nine.setVisibility(View.VISIBLE);
            }
        });

        TextView ans = (TextView) findViewById(R.id.answer);

        Button check = (Button) findViewById(R.id.check);

        Random random = new Random();

        int n1, n2, n3, max1 = 9, min1 = 2, max2 = 9, min2 = 1;

        int answer;

        n1 = random.nextInt((max1 - min1) + 1) + min1;

        do {
            n2 = random.nextInt((max1 - min1) + 1) + min1;
        } while (n1 == n2);

        do {
            n3 = random.nextInt((max2 - min2) + 1) + min2;
        } while (n3 == n1 || n3 == n2);

        answer = n1 * n2 + n3;

        ans.setText(Integer.toString(answer));

        if (mode == 1) {
            num1.setText(Integer.toString(n1));
            num2.setText(Integer.toString(n2));
        } else if (mode == 2) {
            num1.setText(Integer.toString(n1));
            num3.setText(Integer.toString(n3));
        } else if (mode == 3) {
            num3.setText(Integer.toString(n3));
        }

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int number1 = Integer.parseInt(num1.getText().toString());
                    int number2 = Integer.parseInt(num2.getText().toString());
                    int number3 = Integer.parseInt(num3.getText().toString());

                    if (number1 * number2 + number3 != answer) {
                        Toast.makeText(getApplicationContext(), "Wrong Answer!!!", Toast.LENGTH_SHORT).show();
                        wrong++;
                        show(mode);
                    } else if (number1 * number2 + number3 == answer) {
                        Toast.makeText(getApplicationContext(), "Correct Answer!!!", Toast.LENGTH_SHORT).show();
                        right++;
                        show(mode);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(GameActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    show(mode);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        yourCountDownTimer.cancel();
        finish();
    }
}