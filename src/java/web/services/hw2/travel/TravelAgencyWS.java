/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services.hw2.travel;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import web.services.hw2.travel.model.Flights;
import web.services.hw2.travel.model.Trip;

/**
 *
 * @author Alex
 */
@WebService(serviceName = "TravelAgencyWS")
@Stateless()
public class TravelAgencyWS {


    /**
     * Web service operation
     *
     * @param destination
     * @param departure
     * @return
     */
    @WebMethod(operationName = "checkFlight")
    public List<Trip> checkFlight(@WebParam(name = "departure") String departure,@WebParam(name = "destination") String destination)  {
        System.out.println("hahahahahahahahahahahahahahah");
        List<Trip> trips = new ArrayList<Trip>();
        Flights fl = new Flights();
        trips = fl.findFligts(departure, destination);
        System.err.println("test " + trips.size());
        return trips;
    }

    /**
     *
     * @param trip
     * @return
     */
    @WebMethod(operationName = "reserve")
    public boolean reserve(@WebParam(name = "trip") Trip trip) {
        return true;
    }
}
