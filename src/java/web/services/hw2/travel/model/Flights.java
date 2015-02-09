/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services.hw2.travel.model;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 *
 * @author syst3m
 */
public class Flights {
   private static List <Flight> flightList = new ArrayList<Flight>(); 
 

   public Flights(){
       Flight flight = new Flight();
       Flight flight2 = new Flight();
       Flight flight3 = new Flight();
       Flight flight4 = new Flight();
       Flight flight5 = new Flight();
       Flight flight6 = new Flight();
       Flight flight7 = new Flight();
       Flight flight8 = new Flight();
       Flight flight9 = new Flight();
       Flight flight10 = new Flight();
       
       flight.setDeparture("stockholm");
       flight.setDestination("göteborg");
       flight.setPrice(400);
       flight.setFlightNr("MN14G");
       flight.setDate("2015-02-02");
       flightList.add(flight);
       
       
       flight2.setDeparture("Skellefteå");
       flight2.setDestination("göteborg");
       flight2.setPrice(200);
       flight2.setFlightNr("MN14G");
       flight2.setDate("2015-02-02");
       flightList.add(flight2);
       
       
       flight10.setDeparture("stockholm");
       flight10.setDestination("Helsingborg");
       flight10.setPrice(200);
       flight10.setFlightNr("MN14G");
       flight10.setDate("2015-02-02");
       flightList.add(flight10);
       
       
       flight6.setDeparture("stockholm");
       flight6.setDestination("skövde");
       flight6.setPrice(400);
       flight6.setFlightNr("MN15G");
       flight6.setDate("2015-02-02");
       flightList.add(flight6);
       
       
       flight7.setDeparture("skövde");
       flight7.setDestination("göteborg");
       flight7.setFlightNr("IX128");
       flight7.setPrice(300);
       flight7.setDate("2015-02-12");
       flightList.add(flight7);
       
        
       flight3.setDeparture("stockholm");
       flight3.setDestination("göteborg");
       flight3.setFlightNr("LK19F");
       flight3.setPrice(300);
       flight3.setDate("2015-02-15");
       flightList.add(flight3);
       
       
       flight4.setDeparture("danmark");
       flight4.setDestination("bremen");
       flight4.setFlightNr("KA193");
       flight4.setPrice(1300);
       flight4.setDate("2015-02-17");
       flightList.add(flight4);
       
       flight8.setDeparture("danmark");
       flight8.setDestination("hamburg");
       flight8.setFlightNr("KA199");
       flight8.setPrice(1300);
       flight8.setDate("2015-02-17");
       flightList.add(flight8);
       
       flight9.setDeparture("hamburg");
       flight9.setDestination("bremen");
       flight9.setFlightNr("KA199");
       flight9.setPrice(1300);
       flight9.setDate("2015-02-17");
       flightList.add(flight9);
       
       flight5.setDeparture("danmark");
       flight5.setDestination("bremen");
       flight5.setFlightNr("PO19F");
       flight5.setPrice(1300);
       flight5.setDate("2015-02-17");
       flightList.add(flight5);
   }
   
   public List<Trip> findFligts(String departure, String destination){
       List<Trip> ticket =  new ArrayList<Trip>();      
       for(int i = 0; i < flightList.size(); ++i){           
           if(flightList.get(i).getDeparture().equals(departure) && flightList.get(i).getDestination().equals(destination)){            
               Trip tr = new Trip();
               tr.addFlight(flightList.get(i));
               ticket.add(tr);
           }
       }
       List flightDeparture =  new ArrayList<Flight>();  
       for(int  i = 0 ; i < flightList.size(); ++i){
           if(flightList.get(i).getDeparture().equals(departure)){
               flightDeparture.add(flightList.get(i));
           }
       }
       
       
       List flightDestination =  new ArrayList<Flight>();  
       for(int i = 0 ; i< flightList.size(); ++i ){
           if(flightList.get(i).getDestination().equals(destination)){
               flightDestination.add(flightList.get(i));
           }
       }
       
       
       for(int  i = 0 ; i < flightDeparture.size(); ++i){
           Flight fldepa = (Flight) flightDeparture.get(i);
           Flight fldest = (Flight) flightDestination.get(i);
           if(fldepa.getDestination().equals(fldest.getDeparture()) && fldest.getDestination().equals(destination)){
               Trip tr = new Trip();
               tr.addFlight(fldepa);
               tr.addFlight(fldest);
               ticket.add(tr);           
           }
       }
           
       return ticket;
   }
   
}
