/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services.hw2.travelAgency.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Users {
    
    List<Person> users = new ArrayList<>();
    
    public Users() {
        users.add(new Person("Alex","1234567"));
        users.add(new Person("Sam","1234"));
    }
    
    public boolean checkUser(Person p) {
        return users.contains(p);
    }
}
