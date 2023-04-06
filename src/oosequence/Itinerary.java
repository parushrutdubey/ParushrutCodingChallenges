package oosequence;

import java.util.ArrayList;
import java.util.Date;


public class Itinerary {
	private String name;
	private ArrayList<Flight> flights;
	public Itinerary(String Name) {
	   name=Name;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Flight> getFlightList() {
		return flights;
	}
	public void addFlight(Flight m) {
		ArrayList<Flight> temp= new ArrayList<Flight>();
		if(flights==null)	{	
			temp.add(m);
			this.flights=temp;
		}
		if(flights.size()<6&&flights.get(0)!=m) {
			this.flights.add(m);
			for (int i = 0; i < flights.size(); i++) {
				Date firstDate=flights.get(i).getDeparture();
				for (int j = flights.size() - 1; j > i; j--) {
		        	  Date lastDate=flights.get(j).getDeparture();
		              if (firstDate.after(lastDate)) {
		                  Flight tmp = flights.get(i);
		                  this.flights.set(i,flights.get(j));
		                  this.flights.set(j,tmp);
		              }
		        }
		   }	
		}
	}
	public long getTotalLayover() {
		long layover=0;
		if(flights==null) return 0;

		if(flights.size()>1) {
			long firstArrival=0;
			long  nextDeparture=0;
			for (int i=0; i<flights.size();i++) {
				firstArrival=flights.get(i).getArrival().getTime();  		
				//for (int j =i+1;j<flightlist.size();j++) {
				if(i+1<flights.size()) {	
					nextDeparture=flights.get(i+1).getDeparture().getTime();		
				
					layover = layover+ ((nextDeparture-firstArrival)/60000);
				}
			}
			return layover;	
				
		}
			
			
		return 0;
	}

}
