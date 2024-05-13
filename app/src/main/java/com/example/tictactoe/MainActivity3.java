package com.example.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView = findViewById(R.id.textView4);
            editText = findViewById(R.id.editTextText);
            Log.v("MyActivity3", "___"+editText.getText().toString()+"___");
            if(!editText.getText().toString().isEmpty()){
                Toast.makeText(MainActivity3.this, "Your new Username is: "+editText.getText().toString(), Toast.LENGTH_SHORT).show();
                textView.setText("Your username is: "+editText.getText().toString().trim());
            }
            else{
                Toast.makeText(MainActivity3.this, "Invalid Username...", Toast.LENGTH_SHORT).show();
            }
        }
        });
        button = findViewById(R.id.button4);
        button.setText("OFF");
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(button.getText().toString() == "OFF"){
                button.setText("ON");
            }
            else{
                button.setText("OFF");
            }
        }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}