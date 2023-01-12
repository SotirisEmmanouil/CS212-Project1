public class Date212 {
	
	private int year;
	private int month;								//private instance variables
	private int day;

	public Date212 (String d) {						  //Date212 constructor 
		year = Integer.parseInt(d.substring(0,4));
		month = Integer.parseInt(d.substring(4,6));
		day = Integer.parseInt(d.substring(6,8));
	
	}
	
	public int getYear() {						//get method of year
		return year;
	}
	
	public int getMonth() {					   //get method for month
		return month;
	}
	
	public int getDay() {					   //get method for day
		return day;
	}
	
	public int setYear(int y) {				    //set method for year
		return year = y;
	}
	
	public int setMonth(int m) {				//set method for month
		return month = m;
	}
	
	public int setDay(int d) {					//set method for day
		return day = d;
	}
	
	public static boolean equals(Date212 date, Date212 date2) {		//equals method that checks to see if two dates are equal 
		if(date.toString().equals(date2.toString()))
				return true;
				  return false;    	
		}
	
	public static int compareTo(Date212 other, Date212 date) {			// compare method that compares the dates
		 return date.toString().compareTo(other.toString());
							
					}
	
	
	public String toString() {					//toString method that prints the final result 
	     String month1 = null;
		
		switch(month) {
		   case 01:
		month1 = "January";	
			break;
		   case 02:
		month1 = "February";					//switch to decide month
			break;
		   case 03:
		month1 = "March";
			break;
		   case 04:
		month1 = "April";
			break;
		   case 05:
		month1 = "May";
			break;
		   case 06:
		month1 = "June";
			break;
		   case 07:
		month1 = "July";
			break;
		   case 8:
		month1 = "August";
			break;
		   case 9:
		month1 = "September";
			break;
		   case 10:
		month1= "October";
			break;
		   case 11:
		month1 = "November";
			break;
		   case 12:
		month1= "December";
			break;
			 
		}
	  String day1 = String.valueOf(day);
	  String year1 = String.valueOf(year);
	  String Date2121 = month1 + " " + day1 + ", " + year1;			// final string result
			 return Date2121;  
	}
}
