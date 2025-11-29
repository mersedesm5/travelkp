package com.example.travelkp.adapters;  // NOT adapers!

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
        if (tours != null) {
            this.tours = tours;
            notifyDataSetChanged();
        }
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
            if (tour == null) return;

            titleTextView.setText(tour.getTitle() != null ? tour.getTitle() : "");
            durationTextView.setText(tour.getDurationDays() + " дней");

            String currency = tour.getCurrency() != null ? tour.getCurrency() : "KGS";
            priceTextView.setText(String.format("%.0f %s", tour.getPrice(), currency));

            ratingTextView.setText(String.format("★ %.1f", tour.getRating()));
            difficultyTextView.setText(tour.getDifficulty() != null ? tour.getDifficulty() : "");

            if (tour.getImage() != null && !tour.getImage().isEmpty()) {
                Picasso.get()
                        .load(tour.getImage())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(imageView);
            } else {
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        }
    }
}