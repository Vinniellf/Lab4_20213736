package com.example.tele_weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tele_weather.Model.Hora;
import com.example.tele_weather.Model.Pronostico;
import com.example.tele_weather.R;

import java.util.List;

public class FuturoAdapter extends RecyclerView.Adapter<FuturoAdapter.FuturoViewHolder>{

    private List<Hora> horaList;
    Context context;

    public FuturoAdapter(List<Hora> horaList, Context context) {
        this.horaList = horaList;
        this.context = context;
    }

    @NonNull
    @Override
    public FuturoAdapter.FuturoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_futuro, parent, false);
        return new FuturoAdapter.FuturoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuturoAdapter.FuturoViewHolder holder, int position) {
        Hora hora = horaList.get(position);
        holder.tvHora.setText(hora.getTime());
        holder.tvTemp.setText(hora.getTemp_c());
        holder.tvRain.setText(hora.getChance_of_rain());
        String nombreArchivo = hora.getCondition().getIcon(); // ej. "image1.png"
        Glide.with(context)
                .load("https:" + nombreArchivo)
                .into(holder.tvFoto);
    }


    @Override
    public int getItemCount() {
        return horaList.size();
    }
    public static class FuturoViewHolder extends RecyclerView.ViewHolder {
        TextView tvHora, tvTemp, tvRain;
        ImageView tvFoto;

        public FuturoViewHolder(View itemView) {
            super(itemView);
            tvHora = itemView.findViewById(R.id.tvHora);
            tvTemp = itemView.findViewById(R.id.tvTemp);
            tvRain = itemView.findViewById(R.id.tvRain);
            tvFoto = itemView.findViewById(R.id.tvFoto);
        }
    }
}
