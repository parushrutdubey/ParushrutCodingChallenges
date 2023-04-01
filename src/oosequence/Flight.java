package oosequence;


public class Flight extends TripComponent {

	private String departureAirport;
	private String arrivalAirport;

	public void setArrivalAirport(String givenAirport) {
	 	if (givenAirport==null)arrivalAirport="";	
	 	if (givenAirport!=null) {
	 		if (givenAirport.length()<3||givenAirport.length()>3) arrivalAirport="";
	 		else arrivalAirport=givenAirport;
	 	}
	}
	public void setDepartureAirport(String givenAirport) {
		 if (givenAirport==null)departureAirport="";
		 if (givenAirport!=null) {
			 if (givenAirport.length()<3||givenAirport.length()>3)departureAirport="";	
			 else departureAirport=givenAirport;
		 }
	}
	public String getArrivalAirport() {return arrivalAirport;}
	public String getDepartureAirport() {return departureAirport;}
	public  String getDuration() {
		if(getStart()==null||getEnd()==null) return "0 minutes";
		if(getStart()!=null && getEnd()!=null ) {
			long start = getStart().getTime();
			long end = getEnd().getTime();
			long diff = (end-start)/60000;
			return diff+" minutes";
		}		
		return "0 minutes";
	}
}
