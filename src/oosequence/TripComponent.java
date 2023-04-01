package oosequence;

import java.util.Date;

public class TripComponent {

	private Date start;
	private Date end;

	public TripComponent(Date dep, Date arr) {
		
		if (dep == null || arr == null) {
			start = dep;
			end = arr;   
		}
		
		if(dep != null && arr != null) {
			
			if(dep.after(arr)||dep.equals(arr)) {
				start = dep;
				end = null;
			}
			else if(dep.before(arr)){
				start = dep;
				end = arr;
			}
		}
	}
	
	public TripComponent() {
		// TODO Auto-generated constructor stub
		Date temp = new Date();
		start = temp;
		end=new Date(temp.getTime() + 3600000);
		
		
	}

	public TripComponent(TripComponent c) {
		// TODO Auto-generated constructor stub
		start=c.start;
		end=c.end;
	}

	public Date getStart() {
		return start;
	}
	public Date getEnd() {
		return end;
	}
	public void setStart(Date date) {	
		if(date == null || end == null)start = date;

		else if (date.before(end))start = date;
	}
	public void setEnd(Date date) { 
		if(date == null || start ==null)end = date;
		
		else if (start.before(date))end = date;
	}

	public long lengthInSeconds() {
		long diff = 0;
		if(start==null||end==null) return diff;
		if(start!=null & end!=null ) {
			long departTime = start.getTime();
			long arriveTime = end.getTime();
			diff = (arriveTime-departTime)/1000;
			return diff;
		}		
		return diff;
	}

}