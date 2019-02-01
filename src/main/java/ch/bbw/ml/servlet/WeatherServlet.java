package ch.bbw.ml.servlet;

import ch.bbw.ml.controller.HistoryWeather;
import ch.bbw.ml.model.Weather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/weatherServlet")
public class WeatherServlet extends HttpServlet {

    private String weatherA;
    private String weatherB;

    private boolean showHistory = false;
    private boolean showWeatherA;
    private boolean showWeatherB;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        weatherA = request.getParameter("locationA");
        weatherB = request.getParameter("locationB");

        ArrayList<ArrayList<Weather>> weathersAB = HistoryWeather.weatherHistory(weatherA, weatherB);

        ArrayList<Weather> locationAweather = weathersAB.get(0);
        ArrayList<Weather> locationBweather = weathersAB.get(1);

        if(locationAweather.isEmpty()){
            showWeatherA = false;
        }
        else{
            showWeatherA = true;
        }

        if(locationAweather.isEmpty()){
            showWeatherB = false;
        }
        else{
            showWeatherB = true;
        }

        showHistory = true;

        //request.setAttribute("TrainConnections");

        request.setAttribute("showWeatherA", showWeatherA);
        request.setAttribute("showWeatherB", showWeatherB);

        request.setAttribute("weatherA", locationAweather);
        request.setAttribute("weatherB", locationBweather);
        request.setAttribute("showHistory", showHistory);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

