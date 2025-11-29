package com.example.travelkp.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.travelkp.R;
import com.example.travelkp.adapters.HotelAdapter;
import com.example.travelkp.models.Hotel;
import com.example.travelkp.network.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelsActivity extends AppCompatActivity {
    private static final String TAG = "HotelsActivity";
    private RecyclerView recyclerView;
    private HotelAdapter adapter;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        // Initialize views
        recyclerView = findViewById(R.id.hotelsRecyclerView);
        progressBar = findViewById(R.id.progressBar);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Create adapter
        adapter = new HotelAdapter();
        recyclerView.setAdapter(adapter);

        // Load data
        loadHotels();
    }

    private void loadHotels() {
        Log.d(TAG, "Starting to load hotels...");

        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        RetrofitClient.getInstance()
                .getApiService()
                .getHotels()
                .enqueue(new Callback<List<Hotel>>() {
                    @Override
                    public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                        // Hide progress bar
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        if (response.isSuccessful() && response.body() != null) {
                            List<Hotel> hotels = response.body();
                            adapter.setHotels(hotels);
                            Log.d(TAG, "Hotels loaded successfully: " + hotels.size() + " items");

                            if (hotels.isEmpty()) {
                                Toast.makeText(HotelsActivity.this,
                                        "Нет доступных отелей",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e(TAG, "Response not successful. Code: " + response.code());
                            Toast.makeText(HotelsActivity.this,
                                    "Ошибка загрузки отелей: " + response.code(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Hotel>> call, Throwable t) {
                        // Hide progress bar
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        Log.e(TAG, "Error loading hotels", t);
                        Toast.makeText(HotelsActivity.this,
                                "Ошибка: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}