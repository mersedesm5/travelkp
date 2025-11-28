package com.example.travelkp.activities;

import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        recyclerView = findViewById(R.id.hotelsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HotelAdapter();
        recyclerView.setAdapter(adapter);

        loadHotels();
    }

    private void loadHotels() {
        RetrofitClient.getInstance()
                .getApiService()
                .getHotels()
                .enqueue(new Callback<List<Hotel>>() {
                    @Override
                    public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            adapter.setHotels(response.body());
                            Log.d(TAG, "Hotels loaded: " + response.body().size());
                        } else {
                            Toast.makeText(HotelsActivity.this,
                                    "Ошибка загрузки отелей",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Hotel>> call, Throwable t) {
                        Log.e(TAG, "Error loading hotels", t);
                        Toast.makeText(HotelsActivity.this,
                                "Ошибка: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}