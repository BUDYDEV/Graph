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
 public class Point {
    
	public City origin;
	public City destination;
	public int weight;
	public Point next;

  public Point (City origin, City destination){
    this(origin, destination, Integer.MAX_VALUE);
  }

	public Point(City origin, City destination, int weight) {
		this.origin 		= origin;
		this.destination	= destination;
		this.weight 		= weight;
		this.next 		= null;
	}

	public Point next(Point edge) {
		this.next = edge;
		return this;
	}

  
}
