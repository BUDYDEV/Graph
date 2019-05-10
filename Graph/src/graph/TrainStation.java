/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import Helper.NoSuchRoute;
import Models.Point;
import Models.Paths;
import Models.City;
import java.util.ArrayList;

/**
 *
 * @author Arsalan
 */
public class TrainStation {

    public static void main(String[] args) {       
        Paths graph = new Paths();

        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");

        graph.routingTable.put(a, new Point(a, b, 5).next(new Point(a, d, 5).next(new Point(a, e, 7))));
        graph.routingTable.put(b, new Point(b, c, 4));
        graph.routingTable.put(c, new Point(c, d, 8).next(new Point(c, e, 2)));
        graph.routingTable.put(d, new Point(d, c, 8).next(new Point(d, e, 6)));
        graph.routingTable.put(e, new Point(e, b, 3));

        
        ArrayList<City> routes1 = new ArrayList<>();
        routes1.add(a);
        routes1.add(b);
        routes1.add(c);
       
        ArrayList<City> routes2 = new ArrayList<>();
        routes2.add(a);
        routes2.add(d);
     
        ArrayList<City> routes3 = new ArrayList<>();
        routes3.add(a);
        routes3.add(d);
        routes3.add(c);
        
        ArrayList<City> routes4 = new ArrayList<>();
        routes4.add(a);
        routes4.add(e);
        routes4.add(b);
        routes4.add(c);
        routes4.add(d);
       
        ArrayList<City> routes5 = new ArrayList<>();
        routes5.add(a);
        routes5.add(e);
        routes5.add(d);
        try {
            System.out.println("Question 1 : " + graph.findDistanceBetweenCitys(routes1));
            System.out.println("Question 2 : " + graph.findDistanceBetweenCitys(routes2));
            System.out.println("Question 3 : " + graph.findDistanceBetweenCitys(routes3));
            System.out.println("Question 4 : " + graph.findDistanceBetweenCitys(routes4));
            System.out.println("Question 5 : " + graph.findDistanceBetweenCitys(routes5));
        } catch (NoSuchRoute ex) {
            System.out.println (ex);
        }
        
        try{
        
        System.out.println("Question 6 : " + graph.numberOfStopsBetweenCitys(c, c, 3));
        }catch(NoSuchRoute ex)
        {
            System.out.println(ex);
        }
        try{
        
        System.out.println("Question 7 : " + graph.numberOfStopsBetweenCitys(a, c, 4));
        }catch(NoSuchRoute ex)
        {
            System.out.println(ex);
        }
        try{
        
        System.out.println("Question 8 : " + graph.shortestRouteBetweenCitys(a, c));
        }catch(NoSuchRoute ex)
        {
            System.out.println(ex);
        }
        try{
        
        System.out.println("Question 9 : " + graph.shortestRouteBetweenCitys(b, b));
        }catch(NoSuchRoute ex)
        {
            System.out.println(ex);
        }
        try{
        
        System.out.println("Question 10 : " + graph.numPathsWithin(c, c, 30));
        }catch(NoSuchRoute ex)
        {
            System.out.println(ex);
        }
        
        
    }
    
}
