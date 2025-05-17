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
import com.example.tele_weather.Model.Pronostico;
import com.example.tele_weather.R;

import java.util.List;

public class PronosticoAdapter extends RecyclerView.Adapter<PronosticoAdapter.PronosticoViewHolder> {
    private List<Pronostico> pronosticoList;
    Context context;

    public PronosticoAdapter(List<Pronostico> pronosticoList, Context context) {
        this.pronosticoList = pronosticoList;
        this.context = context;
    }

    @NonNull
    @Override
    public PronosticoAdapter.PronosticoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pronostico, parent, false);
        return new PronosticoAdapter.PronosticoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PronosticoAdapter.PronosticoViewHolder holder, int position) {
        Pronostico pronostico = pronosticoList.get(position);
        holder.tvFecha.setText(pronostico.getDate());
        holder.tvMin.setText(pronostico.getDay().getMintemp_c());
        holder.tvMax.setText(pronostico.getDay().getMaxtemp_c());
        String nombreArchivo = pronostico.getDay().getCondition().getIcon(); // ej. "image1.png"
        Glide.with(context)
                .load("https:" + nombreArchivo)
                .into(holder.tvFoto);
    }

    @Override
    public int getItemCount() {
        return pronosticoList.size();
    }
    public static class PronosticoViewHolder extends RecyclerView.ViewHolder {
        TextView tvFecha, tvMin, tvMax;
        ImageView tvFoto;

        public PronosticoViewHolder(View itemView) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvMin = itemView.findViewById(R.id.tvMinTemp);
            tvMax = itemView.findViewById(R.id.tvMaxTemp);
            tvFoto = itemView.findViewById(R.id.tvFoto);
        }
    }
}
