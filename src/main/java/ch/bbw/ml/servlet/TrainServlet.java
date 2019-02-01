package ch.bbw.ml.servlet;

import ch.bbw.ml.controller.TrainAPI;
import ch.bbw.ml.model.Train;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * @Author: Lenny Merlo
 * @Version: 1.0
 * @Class: TrainServlet
 */

@WebServlet("/trainServlet")
public class TrainServlet extends HttpServlet {

    private String fromLocation;
    private String toLocation;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TrainAPI trainAPI = new TrainAPI();

        fromLocation = request.getParameter("trainFrom");
        toLocation = request.getParameter("trainTo");

        String url = "http://transport.opendata.ch/v1/connections?from=" + fromLocation + "&to=" + toLocation + "&limit=4";
        trainAPI.getSbbData(url);

        ArrayList<Train> trains = trainAPI.getConnections();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        DateFormat outputFormat = new SimpleDateFormat("HH:mm");

        Date fromDate = null;
        Date toDate = null;

        String fromOutput = null;
        String toOutput = null;

        for (Train connection : trains){
            try {
                fromDate = dateFormat.parse(connection.trainFrom.getDeparture_time());
                toDate = dateFormat.parse(connection.trainTo.getArrival_time());

                fromOutput = outputFormat.format(fromDate);
                toOutput = outputFormat.format(toDate);

                connection.trainFrom.setDeparture_time(fromOutput);
                connection.trainTo.setArrival_time(toOutput);

                connection.difference = getDifferenceOfDepAndArr(fromDate, toDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("locationA", fromLocation);
        request.setAttribute("locationB", toLocation);

        request.setAttribute("TrainConnections", trains);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public String getDifferenceOfDepAndArr(Date fromDate, Date toDate){
        int differenceInMinutes = ((int) Math.ceil(((double) toDate.getTime() - (double) fromDate.getTime()) / (1000*60) ));

        if (differenceInMinutes / 60 == 0) {
            return String.valueOf(differenceInMinutes % 60 + "min");
        }

        else {
            return String.valueOf(differenceInMinutes / 60 +"h "+ differenceInMinutes % 60 + "min");
        }
    }
}
