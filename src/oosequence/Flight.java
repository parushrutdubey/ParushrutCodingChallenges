package oosequence;

import java.util.Date;

public class Flight {
	 Date dep;
	 Date arr;

        /**
         * This the constructor which performs validation and assigns the values to dep and arr after performing 2 validations to check if it is null and whether the dep time is before arr time.
         * @param departure is the value of the departure time
         * @param arrival is the value of the arrival time
         */
	    public Flight(Date departure, Date arrival) {
	        if (departure == null || arrival == null) {
	            dep = departure;
	            arr = arrival;
	        } else if (departure.before(arrival)) { //elseif is used as it is the only other case which must be tested. If the arrival time is before departure then we don't want it to assign any value, so there is no else statement for assigning values other than those which are null or dep before arr.
	            dep = departure;
	            arr = arrival;
	        } 
	    }


	    /**
	     * This is a copy constructor which assigns values to dep and arr without validation
	     * @param copy is the instance 
	     */
	    public Flight(Flight copy) {
	    	dep=copy.dep;
	    	arr=copy.arr;
			
		}



		/**
		 * It is a method which calculates the time of the flight based off a series of validation done to check whether the departure and arrival times are right.
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