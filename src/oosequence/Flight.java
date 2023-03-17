package oosequence;

import java.util.Date;

public class Flight {
	 Date dep;
	 Date arr;

        /**
         * This the constructor which performs validation and assigns the values to dep and arr
         * @param departure is the value of the departure time
         * @param arrival is the value of the arrival time
         */
	    public Flight(Date departure, Date arrival) {
	        if (departure == null || arrival == null) {
	            dep = departure;
	            arr = arrival;
	        } else if (departure.before(arrival)) {
	            dep = departure;
	            arr = arrival;
	        } // else, do not set departure and arrival (they remain null)
	    }


	    /**
	     * This is a copy constructor which assigns values without validation
	     * @param copy is the instance 
	     */
	    public Flight(Flight copy) {
	    	dep=copy.dep;
	    	arr=copy.arr;
			
		}



		/**
		 * It is a method which calculates the time of the flight based off a series of validation.
		 * @return The length of duration of the flight.
		 */
	    public long length() {
	    	long l;
	        if (dep != null && arr != null) {
	            l=(arr.getTime() - dep.getTime()) / (1000 * 60);
	        } else {
	            l=0;
	        }
	        return l;
	    }
	}