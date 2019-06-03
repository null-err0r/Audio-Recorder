package com.sam.audiorecorder;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn , btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn = ((Button)findViewById(R.id.btn));
        this.btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {

                Intent serviceIntent = new Intent(MainActivity.this, AudioRecorder.class);
                startService(serviceIntent);

                Toast.makeText(getBaseContext(), " start ", Toast.LENGTH_SHORT).show();
            }

        });

        this.btn1 = ((Button)findViewById(R.id.btn1));
        this.btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {

                Intent serviceIntent = new Intent(MainActivity.this, AudioRecorder.class);
                stopService(serviceIntent);

                Toast.makeText(getBaseContext(), " stop ", Toast.LENGTH_SHORT).show();

            }

       });

    }
}
