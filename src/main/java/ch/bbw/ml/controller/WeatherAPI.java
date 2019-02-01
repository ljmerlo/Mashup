package ch.bbw.ml.controller;

import ch.bbw.ml.model.Train;
import ch.bbw.ml.model.Weather;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAPI {

    public ArrayList<Weather> weathers = null;

    public ArrayList<Weather> getWeatherData(String url, String name) {

        HttpURLConnection c = null;

        try {

            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET"); // HTTP Method
            c.connect(); // Connect trainTo URL

            int status = c.getResponseCode(); // Get HTTP Response trainFrom requested Server

            switch (status) {
                case 200: // When Status is OK
                case 201: // When Status is CREATED
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream())); // GET response body
                    StringBuilder sb = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
                    Date date = new Date();
                    System.out.println(dateFormat.format(date));

                    JSONObject result = new JSONObject(sb.toString());
                    JSONArray weather_arr = result.getJSONArray("weather");

                    weathers = new ArrayList<Weather>();

                    for (int i = 0; i < weather_arr.length(); i++) {

                        JSONObject weather_obj = weather_arr.getJSONObject(i);

                        String weather_name = result.getString("name");
                        String weather_main = weather_obj.getString("main");
                        String weather_description = weather_obj.getString("description");

                        Weather weather = new Weather(name, weather_main, weather_description, dateFormat.format(date));

                        weathers.add(weather);
                    }

                    return weathers;
            }

        } catch (MalformedURLException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();

        } catch (JSONException ex) {
            ex.printStackTrace();

        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    public ArrayList<Weather> formatURL(Train train){

        ArrayList<Weather> FromWeathers;
        ArrayList<Weather> ToWeathers;

        Train weatherTrain = train;
        String FromCoordinateX = weatherTrain.trainFrom.getCoordinateX();
        String FromCoordinateY = weatherTrain.trainFrom.getCoordinateY();

        String ToCoordinateX = weatherTrain.trainTo.getCoordinateX();
        String ToCoordinateY = weatherTrain.trainTo.getCoordinateY();

        String FromURL = "http://api.openweathermap.org/data/2.5/weather?lat=" + FromCoordinateX + "&lon=" + FromCoordinateY + "&APPID=533b245128772abd6348b8bdcdabed59";
        String ToURL = "http://api.openweathermap.org/data/2.5/weather?lat=" + ToCoordinateX + "&lon=" + ToCoordinateY + "&APPID=533b245128772abd6348b8bdcdabed59";

        FromWeathers = getWeatherData(FromURL, train.trainFrom.getName());
        ToWeathers = getWeatherData(ToURL, train.trainTo.getName());

        ArrayList<Weather> dbWeathers = new ArrayList<Weather>();
        dbWeathers.add(FromWeathers.get(0));
        dbWeathers.add(ToWeathers.get(0));

        ConnDB.insertWeather(dbWeathers);

        return dbWeathers;
    }
}