package com.example.tele_weather.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tele_weather.Adapter.FuturoAdapter;
import com.example.tele_weather.Adapter.PronosticoAdapter;
import com.example.tele_weather.ApiClient;
import com.example.tele_weather.ApiService;
import com.example.tele_weather.HoraResponse;
import com.example.tele_weather.Model.Hora;
import com.example.tele_weather.Model.Pronostico;
import com.example.tele_weather.PronosticoResponse;
import com.example.tele_weather.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FuturoFragment extends Fragment {

    private RecyclerView recyclerView;
    private FuturoAdapter futuroAdapter;
    private EditText etSearch1, etSearch2;
    private MaterialButton btnSearch;
    private List<Hora> horaList = new ArrayList<>();

    private String API_KEY = "a8c1b74e3b4646f196c55206251705";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_futuro, container, false);

        // Initialize UI components
        recyclerView = view.findViewById(R.id.recyclerFuturo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //cargarEjemplos();
        futuroAdapter = new FuturoAdapter(horaList, getContext());
        recyclerView.setAdapter(futuroAdapter);

        btnSearch = view.findViewById(R.id.btnSearch);
        etSearch1 = view.findViewById(R.id.etSearch1);
        etSearch2 = view.findViewById(R.id.etSearch2);
        btnSearch.setOnClickListener(v -> searchFuturo(etSearch1.getText().toString(), etSearch2.getText().toString()));

        return view;
    }

    public void searchFuturo(String id, String day) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<HoraResponse> call = apiService.getFuturo(API_KEY, "id:" + id, day);

        call.enqueue(new Callback<HoraResponse>() {
            @Override
            public void onResponse(Call<HoraResponse> call, Response<HoraResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    horaList.clear();
                    horaList.addAll(response.body().getForecast().getForecastday().get(0).getHour());
                    futuroAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Respuesta inválida", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HoraResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }

        });
    }
}