package com.example.drink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Select extends AppCompatActivity {

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        send = findViewById(R.id.send);
        EditText name= findViewById(R.id.name1);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.rock);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String putName;
                putName= name.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("Name", putName);
                startActivity(intent);
                mediaPlayer.start();
                finish();
            }
        });



    }
    }
