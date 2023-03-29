package oosequence;

import java.util.ArrayList;

public class Itinerary {
	private String name;
    private ArrayList<Flight> flights;


	public Itinerary(String name) {
        this.name = name;
        this.flights = new ArrayList<Flight>();

	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void addFlight(Flight m) {
		int index = 0;
		if (flights.contains(m)) {
			index=index-1;
	    }
         for (int i = 0; i < flights.size(); i++) {
             if (m.getDeparture().compareTo(flights.get(i).getArrival()) < 0) 
                 break;
             index = i + 1;  
         }
         flights.add(index, m);
}
	

	public long getTotalLayover() {
		long totalLayover = 0;
        for (int i = 0; i < flights.size() - 1; i++) {
            Flight currentFlight = flights.get(i);
            Flight nextFlight = flights.get(i + 1);
            totalLayover += nextFlight.getDeparture().getTime() - currentFlight.getArrival().getTime();
        }
        return totalLayover / 60000;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
