package oosequence;

import java.util.Date;

public class Flight {

	private Date departure;
	private Date arrival;

	public Flight(Date givenDeparture, Date givenArrival) {
		if (givenDeparture == null&& givenArrival == null) {
			this.departure=givenDeparture;
			this.arrival=givenArrival;
		}
		
		else if (givenDeparture == null&& givenArrival != null) {
			this.departure = givenDeparture;
			this.arrival = new Date(givenArrival.getTime());   
		}
		else if (givenDeparture != null&& givenArrival == null) {
			this.departure = new Date(givenDeparture.getTime());
			this.arrival = givenArrival;   
		}
		
		else if (givenDeparture.before(givenArrival)) {
			setDeparture(givenDeparture);
			setArrival(givenArrival);
			
			this.departure = getDeparture();
			this.arrival = getArrival();
		}
	}
	
	public Date getDeparture() {
		if(departure!=null) return new Date(departure.getTime());
		return departure;
	}
	public Date getArrival() {
		if(arrival!=null) return new Date(arrival.getTime());
		return arrival;
	}
	public void setDeparture(Date date) {	
		if(date == null || arrival == null)this.departure = date;

		else if (date.before(arrival)) {
			this.departure = date;
		}
	} 
	public void setArrival(Date date) { 
		if(date == null || departure ==null)this.arrival = date;
		
		else if (departure.before(date)) {
			this.arrival = date;
		}
	}
	public Flight(Flight c) {
		this.departure = c.departure;
		this.arrival = c.arrival;
	}
	public long length() {
		if(departure==null) return 0;
		if(departure!=null & arrival!=null ) {
			long departTime = this.departure.getTime();
			long arriveTime = this.arrival.getTime();
			long diff = (arriveTime-departTime)/60000;
			return diff;
		}		
		return 0;
	}
}