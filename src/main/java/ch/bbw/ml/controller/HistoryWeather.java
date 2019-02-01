package ch.bbw.ml.controller;

import ch.bbw.ml.model.Weather;

import java.util.ArrayList;

public class HistoryWeather {

    public static ArrayList<ArrayList<Weather>> weatherHistory(String locationA, String locationB){

        ArrayList<ArrayList<Weather>> weathersAB = new ArrayList<>();

        ArrayList<Weather> weathersA = ConnDB.loadWeatherData(locationA);
        ArrayList<Weather> weathersB = ConnDB.loadWeatherData(locationB);

        weathersAB.add(weathersA);
        weathersAB.add(weathersB);

        return weathersAB;
    }
}
