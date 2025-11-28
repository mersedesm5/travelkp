package com.example.travelkp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.travelkp.activities.HotelsActivity;
import com.example.travelkp.activities.ToursActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHotels = findViewById(R.id.btnHotels);
        Button btnTours = findViewById(R.id.btnTours);

        btnHotels.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HotelsActivity.class);
            startActivity(intent);
        });

        btnTours.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ToursActivity.class);
            startActivity(intent);
        });
    }
}