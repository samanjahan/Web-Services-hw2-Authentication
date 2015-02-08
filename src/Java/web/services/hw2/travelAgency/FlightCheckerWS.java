/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services.hw2.travelAgency;

import java.util.ArrayList;
import java.util.List;
import web.services.hw2.travelAgency.model.Person;
import web.services.hw2.travelAgency.model.Users;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Alex
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
@Stateless()
public class FlightCheckerWS {

    private boolean loggedIn = false;

    @WebMethod(operationName = "authenticate")
    public boolean authenticate(String username, String password) {
        Person person = new Person(username, password);
        Users users = new Users();
        if (users.checkUser(person)) {
            loggedIn = true;
        }
        return loggedIn;
    }

    /**
     * Web service operation
     *
     * @param destination
     * @param departure
     * @return
     */
    @WebMethod(operationName = "checkFlight")
    public List<Trip> checkFlight(@WebParam(name = "destination") String destination, @WebParam(name = "departure") String departure) {
        List<Trip> trips = new ArrayList<>();

        return trips;
    }
}
