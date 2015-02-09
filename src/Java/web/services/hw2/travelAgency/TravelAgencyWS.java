/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services.hw2.travelAgency;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import web.services.hw2.travelAgency.model.Person;
import web.services.hw2.travelAgency.model.Users;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceRef;
import web.services.hw2.travelAgency.webService.FlightCheckerWS_Service;
import web.services.hw2.travelAgency.webService.Trip;
import web.services.hw2.travelAgency.webService.bank.BankServices_Service;

/**
 *
 * @author Alex
 */
@WebService(serviceName = "TravelAgencyWS")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@Stateless()
public class TravelAgencyWS {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/BankServices/BankServices.wsdl")
    private BankServices_Service service_bank;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/FlightCheckerWS/FlightCheckerWS.wsdl")
    private FlightCheckerWS_Service service_flightChecker;

    private boolean loggedIn = false;
    private boolean reserved = false;

    /**
     *
     * @param username
     * @param password
     * @return
     */
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
    public Object[] checkFlight(@WebParam(name = "destination") String destination, @WebParam(name = "departure") String departure) {
        if (loggedIn) {
            List<Trip> trips = new ArrayList<>();
            web.services.hw2.travelAgency.webService.FlightCheckerWS port = service_flightChecker.getFlightCheckerWSPort();
            trips = (ArrayList)port.checkFlight(destination, departure);
            return trips.size() > 0 ? trips.toArray((Object[]) Array.newInstance(
            trips.get(0).getClass(), 0)) : new Object[0];
        } else {
            throw new IllegalStateException("Not logged in");
        }
    }

    /**
     *
     * @param trip
     * @return
     */
    @WebMethod(operationName = "reserveTrip")
    public boolean reserveTrip(Trip trip) {
        if (loggedIn) {
            return service_flightChecker.getFlightCheckerWSPort().reserve(trip);
        }else throw new IllegalStateException("Not logged in");
    }
    
    /**
     * Calls the Web service BankWS and tries to make a payment
     * 
     * @param name
     * @param creditCard
     * @return 
     */
    public boolean getTicket(String name, String creditCard){
        if (reserved) {
            double tempAmount = 200;
            return service_bank.getBankServicesPort().pay(name, creditCard,tempAmount);
        }else throw new IllegalStateException("Not reserved yet");
    }

}
