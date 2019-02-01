package ch.bbw.ml.model;

/*
 * @Author: Lenny Merlo
 * @Version: 1.0
 * @Class: Train
 */

public class Train {

    public int i;
    public TrainFrom trainFrom;
    public TrainTo trainTo;
    public String difference;

    public Train(int i, TrainFrom trainFrom, TrainTo trainTo) {
        this.i = i;
        this.trainFrom = trainFrom;
        this.trainTo = trainTo;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public TrainFrom getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(TrainFrom trainFrom) {
        this.trainFrom = trainFrom;
    }

    public TrainTo getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(TrainTo trainTo) {
        this.trainTo = trainTo;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }
}
