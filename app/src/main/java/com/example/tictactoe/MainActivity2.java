package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    private final Button[][] button = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        button[0][0] = findViewById(R.id.button5);
        button[0][1] = findViewById(R.id.button6);
        button[0][2] = findViewById(R.id.button7);
        button[1][0] = findViewById(R.id.button8);
        button[1][1] = findViewById(R.id.button9);
        button[1][2] = findViewById(R.id.button10);
        button[2][0] = findViewById(R.id.button11);
        button[2][1] = findViewById(R.id.button12);
        button[2][2] = findViewById(R.id.button13);
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                Button button1 = button[k][j];
                button[k][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView = findViewById(R.id.textView12);
                        if (!textView.getText().toString().equals("(Wins...)")){
                            if (!textView.getText().toString().equals("(Draw...)")){
                                textView = findViewById(R.id.textView10);
                                String name = textView.getText().toString();
                                button1.setText(name);
                                boolean val = false;
                                for (int i = 0; i < 3; i++) {
                                    Log.v("MyActivity2", "..." + button[i][2].getText().toString() + "...");
                                    if ((button[i][0].getText().toString().equals(button[i][1].getText().toString())) && (button[i][1].getText().toString().equals(button[i][2].getText().toString())) && (!button[i][2].getText().toString().equals("_"))) {
                                        val = true;
                                        break;
                                    }
                                }
                                for (int i = 0; i < 3; i++) {
                                    if ((button[0][i].getText().toString().equals(button[1][i].getText().toString())) && (button[1][i].getText().toString().equals(button[2][i].getText().toString())) && (!button[2][i].getText().toString().equals("_"))) {
                                        val = true;
                                        break;
                                    }
                                }
                                if ((button[0][2].getText().toString().equals(button[1][1].getText().toString())) && (button[1][1].getText().toString().equals(button[2][0].getText().toString())) && (!button[2][0].getText().toString().equals("_"))) {
                                    val = true;
                                }
                                if ((button[0][0].getText().toString().equals(button[1][1].getText().toString())) && (button[1][1].getText().toString().equals(button[2][2].getText().toString())) && (!button[2][2].getText().toString().equals("_"))) {
                                    val = true;
                                }
                                if (val) {
                                    textView = findViewById(R.id.textView12);
                                    textView.setText("(Wins...)");
                                    return;
                                }
                                boolean val1 = true;
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        if (button[i][j].getText().toString().equals("_")) {
                                            val1 = false;
                                            break;
                                        }
                                    }
                                }
                                if (val1) {
                                    textView = findViewById(R.id.textView12);
                                    textView.setText("(Draw...)");
                                    return;
                                }
                                if (textView.getText().toString().equals("X")) {
                                    textView.setText("O");
                                } else {
                                    textView.setText("X");
                                }
                            }
                        }
                    }
                });
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
        });
    }
}

