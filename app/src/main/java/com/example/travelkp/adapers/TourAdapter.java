package com.example.travelkp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.travelkp.R;
import com.example.travelkp.models.Tour;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {
    private List<Tour> tours = new ArrayList<>();

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tour, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tours.get(position);
        holder.bind(tour);
    }

    @Override
    public int getItemCount() {
        return tours.size();
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
        notifyDataSetChanged();
    }

    static class TourViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView durationTextView;
        private TextView priceTextView;
        private TextView ratingTextView;
        private TextView difficultyTextView;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tourImage);
            titleTextView = itemView.findViewById(R.id.tourTitle);
            durationTextView = itemView.findViewById(R.id.tourDuration);
            priceTextView = itemView.findViewById(R.id.tourPrice);
            ratingTextView = itemView.findViewById(R.id.tourRating);
            difficultyTextView = itemView.findViewById(R.id.tourDifficulty);
        }

        public void bind(Tour tour) {
            titleTextView.setText(tour.getTitle());
            durationTextView.setText(tour.getDurationDays() + " дней");
            priceTextView.setText(tour.getPrice() + " " + tour.getCurrency());
            ratingTextView.setText("★ " + tour.getRating());
            difficultyTextView.setText(tour.getDifficulty());

            Picasso.get()
                    .load(tour.getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }
    }
}