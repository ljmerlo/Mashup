package ch.bbw.ml.controller;

import ch.bbw.ml.model.Train;
import ch.bbw.ml.model.Weather;

import java.sql.*;
import java.util.ArrayList;

public class ConnDB {

    public static void insertTrain(ArrayList<Train> connections){
        try {
            String connectionUrl = "jdbc:mysql://localhost/mashup?useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&useSSL=FALSE";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

            for(Train conn : connections){
                String query = " insert into train (FromLocation, ToLocation, DepartureTime, ArrivalTime)"
                        + " values (?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, conn.trainFrom.getName());
                preparedStmt.setString (2, conn.trainTo.getName());
                preparedStmt.setString   (3, conn.trainFrom.getDeparture_time());
                preparedStmt.setString(4, conn.trainTo.getArrival_time());

                // execute the preparedstatement
                preparedStmt.execute();
            }

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertWeather(ArrayList<Weather> weathers){
        try {
            String connectionUrl = "jdbc:mysql://localhost/mashup?useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&useSSL=FALSE";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

            for(Weather weather : weathers){
                String query = " insert into weather (Location, Weather, Description, Date)"
                        + " values (?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString (1, weather.name);
                preparedStmt.setString (2, weather.main);
                preparedStmt.setString   (3, weather.description);
                preparedStmt.setString   (4, weather.date);

                // execute the preparedstatement
                preparedStmt.execute();
            }

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Weather> loadWeatherData(String location) {
        try{
            String connectionUrl = "jdbc:mysql://localhost/mashup?useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&useSSL=FALSE";
            Connection connection = DriverManager.getConnection(connectionUrl, "root", "");

            ArrayList<Weather> weathers = new ArrayList<Weather>();
            PreparedStatement ps = connection.prepareStatement("Select * from weather WHERE Location LIKE '%"+ location +"%'");

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while(rs.next()) {
                    Weather weather = new Weather(rs.getString("Location"), rs.getString("Weather"), rs.getString("Description"), rs.getString("Date"));
                    weathers.add(weather);
                }
                return weathers;
            }
            connection.close();
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
