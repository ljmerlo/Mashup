package ch.bbw.ml.model;

/*
 * @Author: Lenny Merlo
 * @Version: 1.0
 * @Class: TrainTo
 */

public class TrainTo {

    String arrival_time;
    String name;
    String coordinateX;
    String coordinateY;
    Weather weather;

    public TrainTo(String arrival_time, String name, String coordinateX, String coordinateY) {
        this.arrival_time = arrival_time;
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
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
