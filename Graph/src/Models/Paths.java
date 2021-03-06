/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Helper.NoSuchRoute;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Arsalan
 */
public class Paths {
  public Hashtable<City, Point> routingTable;

    public Paths() {
        this.routingTable = new Hashtable<>();
    }

    public Hashtable<City, Point> getRoutingTable() {
        return routingTable;
    }

    public int findDistanceBetweenCitys(ArrayList<City> citys) throws NoSuchRoute {

        if (citys.size() < 2) {
            return 0;
        }

        int distance, depth, index;
        distance = depth = index = 0;

        while (index < citys.size() - 1) {
            if (this.routingTable.containsKey(citys.get(index))) {
                Point route = this.routingTable.get(citys.get(index));
                while (route != null) {
                    if (route.destination.equals(citys.get(index + 1))) {
                        distance += route.weight;
                        depth++;
                        break;
                    }
                    route = route.next;
                }
            } else {
                throw new NoSuchRoute();
            }
            index++;
        }

        if (depth != citys.size() - 1) {
            throw new NoSuchRoute();
        }
        return distance;
    }

    public int numberOfStopsBetweenCitys(City origin, City destination, int limit) throws NoSuchRoute {
        return findPaths(origin, destination, 0, limit);
    }

    private int findPaths(City origin, City dest, int depth, int limit) throws NoSuchRoute {
        int routes = 0;
        if (this.routingTable.containsKey(origin) && this.routingTable.containsKey(dest)) {
            if (depth == limit) {
                return 0;
            }
            depth++;
            origin.visited = true;

            Point point = this.routingTable.get(origin);
            while (point != null) {
                if (point.destination.equals(dest)) {
                    routes++;
                    point = point.next;
                    continue;
                } else if (!point.destination.visited) {
                    depth--;
                    routes += findPaths(point.destination, dest, depth, limit);

                }
                point = point.next;
            }
        } else {
            noRouteException();
        }

        origin.visited = false;
        return routes;
    }

    public int shortestRouteBetweenCitys(City origin, City destination) throws NoSuchRoute {
        return findShortestRoute(origin, destination, 0, 0);
    }

    public int findShortestRoute(City origin, City dest, int distance, int shortestPath) throws NoSuchRoute {
        if (this.routingTable.containsKey(origin) && this.routingTable.containsKey(dest)) {
            origin.visited = true;
            Point point = this.routingTable.get(origin);
            while (point != null) {
                if (point.destination == dest || !point.destination.visited) {
                    distance += point.weight;
                }

                if (point.destination.equals(dest)) {
                    if (shortestPath == 0 || distance < shortestPath) {
                        shortestPath = distance;
                    }
                    origin.visited = false;
                    return shortestPath;
                } /*Some backtracking and recursion */ else if (!point.destination.visited) {
                    shortestPath = findShortestRoute(point.destination, dest, distance, shortestPath);
                    distance -= point.weight;
                }
                point = point.next;
            }
        } else {
            noRouteException();
        }

        origin.visited = false;
        return shortestPath;
    }

    /*
     * Find number of routes between citys;
     */
    public int numPathsWithin(City origin, City dest, int maxDistance) throws NoSuchRoute {
        return findAllPathsBetweenCitys(origin, dest, 0, maxDistance);
    }

    private int findAllPathsBetweenCitys(City origin, City destination, int weight, int maxDistance) throws NoSuchRoute {
        int routes = 0;
        if (this.routingTable.containsKey(origin) && this.routingTable.containsKey(destination)) {

            Point point = this.routingTable.get(origin);
            while (point != null) {
                weight += point.weight;
                if (weight <= maxDistance) {
                    if (point.destination.equals(destination)) {
                        routes++;
                        routes += findAllPathsBetweenCitys(point.destination, destination, weight, maxDistance);
                        point = point.next;
                        continue;
                    } else {
                        routes += findAllPathsBetweenCitys(point.destination, destination, weight, maxDistance);
                        weight -= point.weight;
                    }
                } else {
                    weight -= point.weight;
                }

                point = point.next;
            }
        } else {
            noRouteException();

        }
        return routes;

    }

    public void noRouteException() throws NoSuchRoute {
        throw new NoSuchRoute();

    }

    /*
 * Implementing the extentions
     */
    public String calculateTotalTimeForRoute(ArrayList<City> citys) {

        int totalTime = 0;
        int distance = 0;

        try {

            distance = findDistanceBetweenCitys(citys);
            totalTime = distance + 2 * (citys.size() - 2);

        } catch (Exception e) {
            return e.getMessage();
//            System.out.println(e.getMessage());
//            return null;

        }

        return String.valueOf(totalTime);
    }  
}
