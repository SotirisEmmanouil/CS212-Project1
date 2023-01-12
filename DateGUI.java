import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.*;

public class DateGUI extends JFrame {
	  					   //variables and instances of needed objects
	public static int tokens;
	public static String[] dateListUnsorted, dateListSorted2;
	public static int [] dateListSorted;
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
	
	public static void convert(String [] list1) {				             //method which converts the string array
	 		dateListSorted = new int[dateListUnsorted.length];		     // to an int so it can be sorted, then back to a 
	 			for(int i = 0; i <dateListUnsorted.length; i++) {           //string array so it can be appended to the Date212 array
				dateListSorted[i] = Integer.parseInt(dateListUnsorted[i]);
		}
			  Arrays.sort(dateListSorted);
			    dateListSorted2 = new String[dateListSorted.length];
			  	 for(int i = 0; i < dateListSorted.length; i++) {
			  		 dateListSorted2[i] = String.valueOf(dateListSorted[i]);
		}
			  DateArray = new Date212[dateListSorted2.length];
			for(int i = 0; i < dateListSorted2.length; i++) {
		DateArray[i] = new Date212(dateListSorted2[i]);
	 }	
	 	}
	 
     public static void printUnsortedList(String [] list) {			//append the unsorted array to the GUI
		  for (int i=0;i<list.length;i++) {
				  unsortedDates.append(list[i]);
				  	unsortedDates.append("\n");
		  	}
	 }
	
      public static void printSortedList(Date212 [] list) {			//append the sorted array to the GUI
		  for (int i=0;i<list.length;i++) {
				  sortedDates.append(String.valueOf(list[i]));
				  	sortedDates.append("\n");
		  		}
	 } 
}
