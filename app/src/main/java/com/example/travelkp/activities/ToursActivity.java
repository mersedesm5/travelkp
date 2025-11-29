package com.example.travelkp.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.travelkp.R;
import com.example.travelkp.adapters.TourAdapter;
import com.example.travelkp.models.Tour;
import com.example.travelkp.network.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToursActivity extends AppCompatActivity {
    private static final String TAG = "ToursActivity";
    private RecyclerView recyclerView;
    private TourAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);

        // Initialize views
        recyclerView = findViewById(R.id.toursRecyclerView);
        progressBar = findViewById(R.id.progressBar);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Create adapter
        adapter = new TourAdapter();
        recyclerView.setAdapter(adapter);

        // Load data
        loadTours();
    }

    private void loadTours() {
        Log.d(TAG, "Starting to load tours...");

        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        RetrofitClient.getInstance()
                .getApiService()
                .getTours()
                .enqueue(new Callback<List<Tour>>() {
                    @Override
                    public void onResponse(Call<List<Tour>> call, Response<List<Tour>> response) {
                        // Hide progress bar
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        if (response.isSuccessful() && response.body() != null) {
                            List<Tour> tours = response.body();
                            adapter.setTours(tours);
                            Log.d(TAG, "Tours loaded successfully: " + tours.size() + " items");

                            if (tours.isEmpty()) {
                                Toast.makeText(ToursActivity.this,
                                        "Нет доступных туров",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e(TAG, "Response not successful. Code: " + response.code());
                            Toast.makeText(ToursActivity.this,
                                    "Ошибка загрузки туров: " + response.code(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Tour>> call, Throwable t) {
                        // Hide progress bar
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                        Log.e(TAG, "Error loading tours", t);
                        Toast.makeText(ToursActivity.this,
                                "Ошибка сети: " + t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }}