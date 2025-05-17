package com.example.tele_weather.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tele_weather.Model.Location;
import com.example.tele_weather.R;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    private List<Location> locationList;

    public LocationAdapter(List<Location> locationList) {
        this.locationList = locationList;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location location = locationList.get(position);
        holder.tvName.setText(location.getName());
        holder.tvRegion.setText("Region: " + location.getRegion());
        holder.tvCountry.setText("País: " +location.getCountry());
        holder.tvId.setText("Id: " + location.getId());
        holder.tvCoordenadas.setText("Lat: " + location.getLat() + " / Lon: " + location.getLon());
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvRegion, tvCountry, tvCoordenadas, tvId;

        public LocationViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNombre);
            tvRegion = itemView.findViewById(R.id.tvCRegion);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvCoordenadas = itemView.findViewById(R.id.tvCoordenadas);
            tvId = itemView.findViewById(R.id.tvId);
        }
    }
}
