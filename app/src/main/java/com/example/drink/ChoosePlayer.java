package com.example.drink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ChoosePlayer extends AppCompatActivity {


     Button parker;
     Button sofo;
     Button saras;
     Button blu;
     Button rice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_player);
        parker = findViewById(R.id.anthony);
        sofo = findViewById(R.id.sofo);
        saras = findViewById(R.id.sharas);
        blu = findViewById(R.id.blu);
        rice = findViewById(R.id.rice);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.rock);
        MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.fans);
        MediaPlayer mediaPlayer3 = MediaPlayer.create(this,R.raw.basket);

        blu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Blu.class);
                startActivity(intent1);
                mediaPlayer2.start();
                mediaPlayer.stop();
                mediaPlayer3.stop();

            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Rice.class);
                startActivity(intent1);
                mediaPlayer2.start();
                mediaPlayer.stop();
                mediaPlayer3.stop();
            }
        });

        saras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Saras.class);
                startActivity(intent1);
                mediaPlayer2.start();
                mediaPlayer.stop();
                mediaPlayer3.stop();
            }
        });

    parker.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1 = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(intent1);
            mediaPlayer2.start();
            mediaPlayer.stop();
            mediaPlayer3.stop();
        }
    });

    sofo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1 = new Intent(getApplicationContext(),Sofo.class);
            startActivity(intent1);
            mediaPlayer2.start();
            mediaPlayer.stop();
            mediaPlayer3.stop();
        }
    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}