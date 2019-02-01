package ch.bbw.ml.model;

/*
 * @Author: Lenny Merlo
 * @Version: 1.0
 * @Class: Weather
 */

public class Weather {

    public String name;
    public String main;
    public String description;
    public String date;

    public Weather(String name, String main, String description, String date) {
        this.name = name;
        this.main = main;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
