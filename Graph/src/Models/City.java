/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Arsalan
 */
public class City {
   protected String name;
    protected boolean visited;

    public City(String name) {
        this.name = name;
        this.visited = false;
    }

    public String getName() {
        return this.name;
    }
  
}
