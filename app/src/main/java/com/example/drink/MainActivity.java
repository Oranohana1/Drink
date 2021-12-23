package com.example.drink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button smsBtn;
    Button mailBtn;
    Button camera;
    Button choose;
    FragmentManager fragmentManager;
    String phoneNumber;
    String phoneNumberToSms;


    public String getPhoneNumberToSms() {
        return phoneNumberToSms;
    }

    public void setPhoneNumberToSms(String phoneNumberToSms) {
        this.phoneNumberToSms = phoneNumberToSms;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA,
                        Manifest.permission.READ_SMS,
                        Manifest.permission.SEND_SMS}
                , PackageManager.PERMISSION_GRANTED);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.rock);
        MediaPlayer mediaPlayer2 = MediaPlayer.create(this,R.raw.fans);
        MediaPlayer mediaPlayer3 = MediaPlayer.create(this,R.raw.basket);






       // Button mainButton= findViewById(R.id.mainButton);
       // EditText name= findViewById(R.id.name);

        Button call = findViewById(R.id.calBtn);
        smsBtn = findViewById(R.id.smsBtn);
        mailBtn = findViewById(R.id.btnMail);
        camera = findViewById(R.id.camBtn);
        choose = findViewById(R.id.choose);


        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ChoosePlayer.class);
                startActivity(intent);
                mediaPlayer3.start();
                mediaPlayer.stop();
                mediaPlayer2.stop();

            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePic();
                mediaPlayer3.start();
                mediaPlayer.stop();
                mediaPlayer2.stop();
            }
        });

        mailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();
                mediaPlayer.stop();
                mediaPlayer2.stop();
                SendMail();
            }
        });


        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMessage();
                mediaPlayer3.start();
                mediaPlayer.stop();
                mediaPlayer2.stop();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();
                mediaPlayer.stop();
                mediaPlayer2.stop();
            CallPhone();
            }
        });




       /* mainButton.setOnClickListener(new View.OnClickListener() {
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
        });*/



    }



    //====================== FUNCTIONS ==================================


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        View visible = findViewById(R.id.settingsFragment);
        switch(item.getItemId()){
            case R.id.autoCall:
                Toast.makeText(MainActivity.this, "Calling..", Toast.LENGTH_SHORT);
                CallPhone();
                break;

            case R.id.color:
                Toast.makeText(MainActivity.this, "Press !", Toast.LENGTH_SHORT).show();
                break;

            case R.id.changeNum:

                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.settingsFragment, CallFragment.class, null).
                        setReorderingAllowed(true).
                        addToBackStack(null).
                        commit();
                visible.setVisibility(View.VISIBLE);
                break;

            case R.id.smsChange:

                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.settingsFragment, SmsFragment.class, null).
                        setReorderingAllowed(true).
                        addToBackStack(null).
                        commit();
                visible.setVisibility(View.VISIBLE);
                break;

        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.examp_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void makePic(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    private void SendMail(){
        String recipient = "oranohana10@gmail.com";
        String subject = "Canceled game";
        String message = "Hello, the 'maccabi' game today is canceled :( ";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose a client"));
    }


    private void SendMessage() {
        String number = phoneNumberToSms.toString();
        String message = "Test !";

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null,null );
        Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
        smsBtn.setClickable(false);
        smsBtn.setBackgroundColor(Color.RED);
    }

    private void CallPhone() {
        String number = phoneNumber.toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(number));
        startActivity(intent);


    }
}