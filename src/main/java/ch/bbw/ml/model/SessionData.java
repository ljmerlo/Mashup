package ch.bbw.ml.model;

import java.util.ArrayList;

public class SessionData {

    ArrayList<Train> trains;
    ArrayList<Weather> weathers;

    public SessionData(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public ArrayList<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(ArrayList<Weather> weathers) {
        this.weathers = weathers;
    }
}
