package oosequence;

import java.util.ArrayList;

public class Itinerary {

	private String name;
	private ArrayList<Flight> flights;

	public Itinerary(String name) {
	    this.name = name;
	    this.flights = new ArrayList<Flight>();
	}

	public String getName() {
	    return name;
	}

	public ArrayList<Flight> getFlights() {
	    return flights;
	}

	public void addFlight(Flight flight) {
	    // Add flight to the end of the list if there are no flights yet
	    if (flights.size() == 0) {
	        flights.add(flight);
	    } else {
	        // Check if the new flight overlaps with any existing flights
	        boolean overlaps = false;
	        for (Flight f : flights) {
	            if (f.getArrival().compareTo(flight.getDeparture()) >= 0
	                    || f.getDeparture().compareTo(flight.getArrival()) >= 0) {
	                overlaps = true;
	                break;
	            }
	        }
	        // If there are no overlaps, find the index where to add the flight
	        if (!overlaps) {
	            int index = 0;
	            for (int i = 0; i < flights.size(); i++) {
	                if (flight.getDeparture().compareTo(flights.get(i).getArrival()) < 0) {
	                    // Flight departs before the i-th flight arrives, add it before the i-th flight
	                    break;
	                }
	                index = i + 1;  // Increment index if the i-th flight arrives before the new flight departs
	            }
	            // Add the flight at the correct index
	            flights.add(index, flight);
	        }
	    }
	}
	


	public long getTotalLayover() {
	    long totalLayover = 0;
	    for (int i = 0; i < flights.size() - 1; i++) {
	        long layover = flights.get(i+1).getDeparture().getTime() - flights.get(i).getArrival().getTime();
	        if (layover > 0) {
	            totalLayover += layover / (1000 * 60);  // Convert milliseconds to minutes
	        }
	    }
	    return totalLayover;
	}}
	