/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services.hw2.travel.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Trip {
    private List<Flight> trip = new ArrayList<Flight>();
    
    public Trip() {
    }
    
    public Trip(Flight newFlight) {
        
        trip.add(newFlight);
    }
    
    public void addFlight(Flight newFlight) {
        trip.add(newFlight);
    }
    
    public void removeFlight(Flight flight){
        
        if(trip.contains(flight)) {
            trip.remove(flight);
        }
        
        
    }

    
    
   @Override
   public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Trip is: "); 
       for(int i = 0; i < trip.size(); ++i){
           sb.append(trip.get(i).getDeparture() + " to " + trip.get(i).getDestination()).append("\n");
       }
       return sb.toString();
   }
}
