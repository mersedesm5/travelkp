package com.example.travelkp.adapters;  // NOT adapers!

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.travelkp.R;
import com.example.travelkp.models.Hotel;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private List<Hotel> hotels = new ArrayList<>();

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hotel, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        Hotel hotel = hotels.get(position);
        holder.bind(hotel);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public void setHotels(List<Hotel> hotels) {
        if (hotels != null) {
            this.hotels = hotels;
            notifyDataSetChanged();
        }
    }

    static class HotelViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView nameTextView;
        private TextView addressTextView;
        private TextView priceTextView;
        private TextView ratingTextView;
        private TextView starsTextView;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hotelImage);
            nameTextView = itemView.findViewById(R.id.hotelName);
            addressTextView = itemView.findViewById(R.id.hotelAddress);
            priceTextView = itemView.findViewById(R.id.hotelPrice);
            ratingTextView = itemView.findViewById(R.id.hotelRating);
            starsTextView = itemView.findViewById(R.id.hotelStars);
        }

        public void bind(Hotel hotel) {
            if (hotel == null) return;

            nameTextView.setText(hotel.getName() != null ? hotel.getName() : "");
            addressTextView.setText(hotel.getAddress() != null ? hotel.getAddress() : "");

            String currency = hotel.getCurrency() != null ? hotel.getCurrency() : "KGS";
            priceTextView.setText(String.format("%.0f %s", hotel.getPricePerNight(), currency));

            ratingTextView.setText(String.format("★ %.1f", hotel.getRating()));
            starsTextView.setText(hotel.getStars() + " звезд");

            if (hotel.getImage() != null && !hotel.getImage().isEmpty()) {
                Picasso.get()
                        .load(hotel.getImage())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(imageView);
            } else {
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        }
    }
}