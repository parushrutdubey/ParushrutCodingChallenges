package oosequence;

import java.util.Date;

public class Flight {
    private Date dep;
    private Date arr;

    public Flight(Date departure, Date arrival) {
    	 if (departure == null || arrival == null) {
	            dep = departure;
	            arr = arrival;
	        } else if (departure.before(arrival)) {
	            dep = departure;
	            arr = arrival;
	        } // else, do not set departure and arrival (they remain null)
	    }
    

    public Flight(Flight copy) {
    	dep=copy.dep;
    	arr=copy.arr;

    }

    public long length() {
    	long l;
        if (dep != null && arr != null) {
            l=(arr.getTime() - dep.getTime()) / (1000 * 60);
        } else {
            l=0;
        }
        return l;
	}
    

    public Date getDeparture() {
        return dep;
    }

    public void setDeparture(Date departure) {
        if (departure == null || arr == null || departure.before(arr)) {
            dep = departure;
        }
        if(departure==arr)
        	dep=null;
        }


    public Date getArrival() {
        return arr;
    }

    public void setArrival(Date arrival) {
        if (arrival == null || dep == null || dep.before(arrival)) {
            arr = arrival;
        }
    }
}
