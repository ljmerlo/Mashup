package ch.bbw.ml.model;

/*
 * @Author: Lenny Merlo
 * @Version: 1.0
 * @Class: TrainFrom
 */

public class TrainFrom {

    String departure_time;
    String name;
    String coordinateX;
    String coordinateY;
    Weather weather;

    public TrainFrom(String departure_time, String name, String coordinateX, String coordinateY) {
        this.departure_time = departure_time;
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
