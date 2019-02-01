package ch.bbw.ml.controller;

import ch.bbw.ml.model.Train;
import ch.bbw.ml.model.TrainFrom;
import ch.bbw.ml.model.TrainTo;
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
import java.util.ArrayList;

public class TrainAPI {

    public ArrayList<Train> connections = null;
    public ArrayList<Train> earlyConnections = null;

    public void getSbbData(String url) {

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

                    JSONObject result = new JSONObject(sb.toString());
                    JSONArray connections_arr = result.getJSONArray("connections");

                    connections = new ArrayList();
                    earlyConnections = new ArrayList();

                    WeatherAPI weatherAPI = new WeatherAPI();

                    for (int i = 0; i < connections_arr.length(); i++) {

                        JSONObject connection_obj = connections_arr.getJSONObject(i);

                        JSONObject from_obj = connection_obj.getJSONObject("from");
                        JSONObject from_station_obj = from_obj.getJSONObject("station");
                        JSONObject from_station_coordinate_obj = from_station_obj.getJSONObject("coordinate");

                        JSONObject to_obj = connection_obj.getJSONObject("to");
                        JSONObject to_station_obj = to_obj.getJSONObject("station");
                        JSONObject to_station_coordinate_obj = to_station_obj.getJSONObject("coordinate");

                        String departure_time = from_obj.getString("departure");
                        String departure_name = from_station_obj.getString("name");
                        double departure_CoordinateX = from_station_coordinate_obj.getDouble("x");
                        double departure_CoordinateY = from_station_coordinate_obj.getDouble("y");

                        String arrival_time = to_obj.getString("arrival");
                        String arrival_name = to_station_obj.getString("name");
                        double arrival_CoordinateX = to_station_coordinate_obj.getDouble("x");
                        double arrival_CoordinateY = to_station_coordinate_obj.getDouble("y");

                        String sDeparture_CoordinateX = departure_CoordinateX + "";
                        String sDeparture_CoordinateY = departure_CoordinateY + "";

                        String sArrival_CoordinateX = arrival_CoordinateX + "";
                        String sArrival_CoordinateY = arrival_CoordinateY + "";

                        TrainFrom trainFrom = new TrainFrom(departure_time, departure_name, sDeparture_CoordinateX, sDeparture_CoordinateY);
                        TrainTo trainTo = new TrainTo(arrival_time, arrival_name, sArrival_CoordinateX, sArrival_CoordinateY);

                        Train connection = new Train(i, trainFrom, trainTo);

                        earlyConnections.add(connection);

                    }
                    connections.add(earlyConnections.get(1));
                    connections.add(earlyConnections.get(2));
                    connections.add(earlyConnections.get(3));

                    ConnDB.insertTrain(connections);
                    ArrayList<Weather> weathers = weatherAPI.formatURL(connections.get(0));

                    for (Train connection : connections){
                        connection.trainFrom.setWeather(weathers.get(0));
                        connection.trainTo.setWeather(weathers.get(1));
                    }
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
    }

    public ArrayList<Train> getConnections() {
        return connections;
    }
}
