package com.example.tele_weather;

import com.example.tele_weather.Model.Pronostico;

import java.util.List;

public class PronosticoResponse {
    private Forecast forecast;
    public Forecast getForecast() { return forecast; }

    public class Forecast {
        private List<Pronostico> forecastday;
        public List<Pronostico> getForecastday() { return forecastday; }
    }
}
