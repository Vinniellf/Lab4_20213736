package com.example.tele_weather;

import com.example.tele_weather.Model.Hora;
import com.example.tele_weather.Model.Pronostico;

import java.util.List;

public class HoraResponse {

    private Forecast forecast;
    public Forecast getForecast() { return forecast; }

    public class Forecast {
        private List<Pronostico> forecastday;
        public List<Pronostico> getForecastday() { return forecastday; }
    }
}
