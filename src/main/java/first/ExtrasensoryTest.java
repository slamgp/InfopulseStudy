package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtrasensoryTest {
	
	public void start(int countVariant) {
		 Scanner in = new Scanner(System.in);	
		 List<Integer> listNumber = initList(countVariant);
	     System.out.println("listNumber = " + listNumber.toString());
	     int megicalNumber =  initMagicNumber(listNumber); 
		 System.out.print("Input you number ");
		 String yourVariant = in.next();
		 while (!isExit(yourVariant)) {
			 if (isNumber(yourVariant)) {
				 int yourNumber  = Integer.parseInt(yourVariant);
				 megicalNumber = checkYourChoice(yourNumber, megicalNumber, listNumber);
			 } 
		     System.out.println();
		     System.out.print("Input you number ");
		     yourVariant = in.next();	  
		 }		 
	}
	
	private List<Integer> initList(int countVariant) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < countVariant; i++) {
			result.add(i);
        }
		return result;
	}
	
	private int initMagicNumber(List<Integer> listNumber) {
		int magicNumber = listNumber.get((int)(Math.random() * (listNumber.size() -1)));
		System.out.println("magic number = " + magicNumber);
		return magicNumber;
	}

	private boolean isNumber(String yourVariant) {
		try {
			int yourNumber  = Integer.parseInt(yourVariant);
			return true;
		} catch(NumberFormatException exception) {
			System.out.println("Bad value");
			return false;
   	   }   
	}
	
	private boolean isExit(String yourVariant) {
		String exit = "q";
		if (yourVariant.equals(exit)) {
			System.out.println("GOOD BY!!!");
			return true;
		}
		return false;		
	}
	
	private int checkYourChoice(int yourNumber, int magicMumber, List<Integer> listNumber) {
		int result = 0;
  
		if (yourNumber == magicMumber) { 	   
			System.out.println("YOU WIN!!!!!!!!");
    	    result = initMagicNumber(listNumber);
        } else if (yourNumber < magicMumber) {
    	    System.out.println("You variant is less!");
    	    result = magicMumber;
        } else if (yourNumber > magicMumber) {
    	    System.out.println("You variant is more!");
    	    result = magicMumber;
        }
		
    	return result;
    }
}
