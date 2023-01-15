import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.*;

public class DateGUI extends JFrame {
	  					   //variables and instances of needed objects
	public static int tokens;
	public static String[] dateListUnsorted;
	public static TextFileInput DateFile, DateFile2;
	public static StringTokenizer DateTokens,DateTokens2;
	public static String FileName = "/Users/sotirisemmanouil/eclipse-workspace/CS212 Project 1/src/DateFile.txt";
	public static TextArea unsortedDates;
	public static TextArea sortedDates;  
	public static Date212[] DateArray;
	   
    public static void openGUI() {					//GUI setup
	     DateGUI DateFrame = new DateGUI();
	     unsortedDates = new TextArea("Unsorted\n\n");
	     sortedDates = new TextArea("Sorted\n\n");
	     DateFrame.add(unsortedDates,BorderLayout.WEST);
	     DateFrame.add(sortedDates, BorderLayout.EAST);
	       DateFrame.setSize(500,400);
	       DateFrame.setLocation(100, 100);
	       DateFrame.setTitle("Dates");
	       DateFrame.setLayout(new GridLayout(1,2));
	       DateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       DateFrame.setVisible(true);
	       unsortedDates.setEditable(false);
	       sortedDates.setEditable(false);
	       readFromFile(FileName);
	       printUnsortedList(dateListUnsorted);
	       convert(dateListUnsorted);
	       printSortedList(DateArray);
	
	}
	
     public static void readFromFile(String filename)  {				//reads the file provided
	    int k = 0;
	    String line, line2;
	 		DateFile = new TextFileInput(filename);
	 			line = DateFile.readLine();
	 				
	 			while (line!=null) {							// count the amount of tokens
	 				DateTokens = new StringTokenizer(line,",");
	 					tokens += DateTokens.countTokens();
	 						line = DateFile.readLine();
	 				}
	 		dateListUnsorted = new String[tokens];				// declare an array with the size of the tokens
	 	DateFile2 = new TextFileInput(filename);
		 line2 = DateFile2.readLine();
		 			
	    while (line2!= null) {				           	//while there are more lines, create tokens
	 DateTokens2 = new StringTokenizer(line2,",");	
	 	while (DateTokens2.hasMoreTokens()) {		     		//while there are more tokens, 
			 dateListUnsorted[k++] = DateTokens2.nextToken();	// append the tokens to the array	
	 			}
	 			line2= DateFile2.readLine();			//read the next line	
	 		}
	 				

   }
	
     public static void print(String [] list1) {			//print the unsorted and unsorted dates onto the GUI	
	     for(int i = 0; i <dateListUnsorted.length; i++) {
	 	   unsortedDates.append(list1[i]);
			unsortedDates.append("\n");
		}
			Arrays.sort(dateListUnsorted);				        //sort the array
		         DateArray = new Date212[dateListUnsorted.length];		//declare the size of a Date212 array to store the dates
			  	for(int i = 0; i < dateListUnsorted.length; i++) {
			  	    DateArray[i] = new Date212(dateListUnsorted[i]);	//append the sorted dates and turn them into Date212's
			  		sortedDates.append(String.valueOf(DateArray[i]));	//append the Date212's onto the GUI
			  	           sortedDates.append("\n");
			  	  }
	 	}	
}
