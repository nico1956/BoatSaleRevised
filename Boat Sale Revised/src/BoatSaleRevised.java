/*
 * This program calculate the total amount of accessories and boat costs.
 * It will loop at every user input until a valid data is entered.
 * At the end, it will return the grand totals.
 *
 * Nico Busatto 12/20/2018
 */

import java.text.*;
import java.util.*;

public class BoatSaleRevised {
	
	//Declare variables
	
		static String iString; //Generic input string
		static char iBoatType; //Boat Type
		static String oBoatName; //Boat Literal
		static double iBoatCost; //Single Boat Cost
		static String oBoatCost; //Formatted Boat Cost amount
		static int iAccessoryType; //Accessory Type
		static String oAccessoryName; //Accessory Literal
		static double cAccessoryCost; //Accessory Cost
		static String oAccessoryCost; //Formatted Accessory Cost
		static double cGtAccessoryCost; //Grand Total Accessory Cost
		static int iQty; //Boat Quantity
		static double iPrepCost; //Preparation Cost
		static String oPrepCost; //Formatted Preparation Cost
		static double cGtPrepCost; //Grand Total preparation cost
		static double cMarkupPercent; //Markup Percentage
        static double cMarkupAmount; //Markup Percentage
        static String oMarkupAmount; //Formatted Markup Amount
		static double cSubtotal; //Subtotal Amount
		static String oSubtotal; //Formatted Subtotal amount
		static double cSalesTax; //Sales Taxes
		static String oSalesTax; //Formatted Sales Tax amomunt
		static double cTotalSales; //Subtotal + Accessories + Tax
		static String oTotalSales; //Formatted Total Sales amount
		static double cGrandTotal = 0; //Grand Total amount
		static String oGrandTotal; //Grand Total amount formatted
		static double cGtTax = 0; //Grand total Tax
		static String oGtTax; //Gtand Total tax formatted
		static double cGtSales = 0; //Grand total sales amount
		static String oGtSales; // Formatted Grand Total Sales amount
		static double cGtMarkup = 0; // Grand Total Markup Amount
		static String oGtMarkup; // Grand Total Markup Amount formatted
		static Scanner myScanner; //Input device
		static int cSalesCounter = 0; //Sales Counter
		static char inputAgain = 'Y'; //Use to control loop
		static NumberFormat nf; //Used to format currency

	public static void main(String[] args) {
		
		//Call Init()
		init();
		
		//Loop until user enters 'n'
		while (inputAgain == 'Y') {
			
			//Call input()
			input();
			
			//Call calcs()
			calcs();
			
			//Call output();
			output();
			
		}	
			
		 if (inputAgain == 'N') {
			 
			//Call Grand Totals 
			GtOutput();
				
		 }
		
	}	
	
	public static void init() {
		
		//Initialize new scanner
		myScanner = new Scanner(System.in);
		
		//Change delimiter from blank space to Enter Key 
		// to allow spaces in string
		myScanner.useDelimiter(System.getProperty("line.separator"));
		
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);

	}
	
    public static void input() {
    	
    	//Prompt for valid boat type
    	
    	boolean quit = false;
    	
    	do {

    		System.out.println("Select type of boat: B = Bass; P = Pontoon; S = Ski; C = Canoe");
        	System.out.println("");
        	 
        	boolean choiceIsOK = false;
    	    
    	    do {
    	    	
    	       iBoatType = myScanner.next().toUpperCase().charAt(0);
    	       switch(iBoatType) {
    	    
    	       case 'B':
        		   System.out.println("The selected boat type is Bass");
        		   System.out.println("");
        		   oBoatName = "Bass";
        		   cMarkupPercent = 33;
    	           choiceIsOK = true;
    	           quit = true;
    	           break;
    	        
    	       case 'P':
        		   System.out.println("The selected boat type is Pontoon");
        		   System.out.println("");
        		   oBoatName = "Pontoon";
        		   cMarkupPercent = 25;
    	           choiceIsOK = true;
    	           quit = true;
    	           break;
    	        
    	       case 'S':
        		   System.out.println("The selected boat type is Ski");
        		   System.out.println("");
        		   oBoatName = "Ski";
        		   cMarkupPercent = 42.5;
    	           choiceIsOK = true;
    	           quit = true;
    	           break; 
    	        
    	       case 'C':
        		   System.out.println("The selected boat type is Canoe");
        		   System.out.println("");
        		   oBoatName = "Canoe";
        		   cMarkupPercent = 20;
    	           choiceIsOK = true;
    	           quit = true;
    	           break; 

    	       default:
    	           System.out.println("Boat type must be B = Bass; P = Pontoon; S = Ski; C = Canoe. Please try again!");
    	           break;
    	       }
    	    
    	    } while (!choiceIsOK);
    	    
    	} while (!quit);
    	
    	
        //Prompt for accessories type
    	
    	boolean quit1 = false;
    	
    	do {
    	
         try {
    	
           System.out.println("Select type of accessories: 1 = Electronics; 2 = Ski Package; 3 = Fishing Package");
           System.out.println("");
          
            boolean choiceIsGood = false;
           
            do {
            
        	   iString = myScanner.next();
               iAccessoryType = Integer.parseInt(iString);   
               switch(iAccessoryType) {
      
               case 1:
                    System.out.println("The selected accessory is Electronics");
   	                System.out.println("");
   	                oAccessoryName = "Electronics";
   	                cAccessoryCost = 5415.30;
   	                choiceIsGood = true;
   	                quit1 = true;
   	                break;
   	   
                case 2:
            	     System.out.println("The selected accessory is Ski Package");
        		     System.out.println("");
         	         oAccessoryName = "Ski Package";
         	         cAccessoryCost = 3980;
   	                 choiceIsGood = true;
   	                 quit1 = true;
         	         break;
         	        
         	    case 3:
            	     System.out.println("The selected accessory is Fishing Package");
        		     System.out.println("");
         	         oAccessoryName = "Fishing Package";
         	         cAccessoryCost = 345.45;
   	                 choiceIsGood = true;
   	                 quit1 = true;
         	         break;
         	    
         	    default:
         		     System.out.println("Accessory type must be 1 = Eletronics; 2 = Ski Package; 3 = Fishing Package. Defaulted to 1 = Electronics");
        		     System.out.println("");
        		     oAccessoryName = "Electronics";
        		     cAccessoryCost = 5415.30;
        		     break;
               
               }
               
            } while (!choiceIsGood);  
      
         }
       	
         catch (Exception e){
    		
              System.out.println("Accessory Type must be 1 = Eletronics; 2 = Ski Package; 3 = Fishing Package!");
              System.out.println("");
              oAccessoryName = "Electronics";
              cAccessoryCost = 5415.30;
    		
    	 }
         
        } while (!quit1);  
    
    	
       //Prompt for Boat Quantity
       do { 	
    	
         try {
    	
           System.out.println("Select Boat quantity: 1 - 25");
           System.out.println("");
           iString = myScanner.next();
           iQty = Integer.parseInt(iString);
        
          if (iQty < 1 || iQty > 25) {
 		     
        	  System.out.println("The Quantity must be between 1 and 25!");
 		      System.out.println("");
 		      iQty = -1;
      	
      	   } else {
      		
      		  System.out.println("The quantity is " + iQty);
      		  System.out.println("");
      		
      	     }
      	
      	 }
      	
         catch (Exception e){
      		
         System.out.println("The quantity must be a number between 1 and 25!");
         System.out.println("");
         iQty = -1;
      		
      	 }
       
       } while (iQty < 1 || iQty > 25);
    
        
       //Prompt for Boat Cost
        
       do { 
    
         try {
    	
           System.out.println("Insert boat price: $2,500.00 - $150,000.00");
           System.out.println("");
           iString = myScanner.next();
           iBoatCost = Double.parseDouble(iString);
        
          if (iBoatCost < 2500.00 || iBoatCost > 150000.00) {
        	  
 		    System.out.println("Boat price must be between $2,500.00 - $150,000.00!");
 		    System.out.println("");
 		    iBoatCost = 2499.99;
      	
      	  } else {
      		
      		System.out.println("The price entered is " + "$" + iBoatCost);
      		System.out.println("");
      		
      	    }
      	
      	 }
      	
         catch (Exception e){
      	    	
            System.out.println("The price must be a number between $2,500.00 and $150,000.00!");
            System.out.println("");
            iBoatCost = 2499.99;
      		
      	 }
         
       } while (iBoatCost < 2500.00 || iBoatCost > 150000.00); 
    
         
       //Prompt for Preparation Cost
       
       do {
    
         try {
    	
           System.out.println("Insert preparation cost: $100.00 - $9,999.99");
           System.out.println("");
           iString = myScanner.next();
           iPrepCost = Double.parseDouble(iString);
        
          if (iPrepCost < 100.00 || iPrepCost > 9999.99) {
        	  
 		   System.out.println("Preparation cost must be between $100.00 - $9,999.99!");
 		   System.out.println("");
 		   iPrepCost = 99.99; 
      	
      	  } else {
      		
      		System.out.println("The preparation cost entered is " + "$" +  iPrepCost);
      		System.out.println("");
      		
      	  }
      	
      	 }
      	
         catch (Exception e){
      		
           System.out.println("Preparation cost must be between $100.00 - $9,999.99!");
           System.out.println("");
           iPrepCost = 99.00;
           
      	 }
         
       } while (iPrepCost < 100.00 || iPrepCost > 10000.00);  
    		
    }
    
    
    public static void calcs() {
    	
    	cSalesCounter = cSalesCounter + 1;
    	
    	cMarkupAmount = (cMarkupPercent * iBoatCost) * iQty;
    	
    	cMarkupAmount = cMarkupAmount / 100;
    		
    	cSubtotal = (iBoatCost + cAccessoryCost + iPrepCost + cMarkupAmount) * iQty;
    	
    	cSalesTax = (cSubtotal * 0.06);
    	
    	cTotalSales = cSubtotal + cSalesTax;
    	
    	
    	//Add to Grand Total amounts
    	
    	cGrandTotal = cGrandTotal + cSubtotal;
    	
    	cGtTax = cGtTax + cSalesTax;
    	
    	cGtSales = cGtSales + cTotalSales;
    	
    	cGtMarkup = cGtMarkup + cMarkupAmount;
    	
    }
    
    
    public static void output() {
    	
    	
    	//Output messages
    	System.out.println("");
    	System.out.println("The chosen boat is " + oBoatName);
    	System.out.println("");
    	System.out.println("The chosen accessory is " + oAccessoryName);
    	System.out.println("");
    	System.out.println("The quantity is " + iQty);
    	System.out.println("");
    	
    	String Header = String.format("%-25s %30s \n", "Item", "Price");
    	oBoatCost = nf.format(iBoatCost);
    	String DetailLine = String.format("%-27s %30s \n", "Boat Cost:", oBoatCost);
    	oAccessoryCost = nf.format(cAccessoryCost);
    	String DetailLine1 = String.format("%-27s %30s \n", "Accessory cost:", oAccessoryCost);
    	oPrepCost = nf.format(iPrepCost);
    	String DetailLine2 = String.format("%-26s %30s \n", "Preparation cost:", oPrepCost);
    	oMarkupAmount = nf.format(cMarkupAmount);
    	String DetailLine3 = String.format("%-26s %30s \n", "Sale Markup amount:", oMarkupAmount);
    	oSubtotal = nf.format(cSubtotal);
    	String DetailLine4 = String.format("%-27s %30s \n", "Subtotal:", oSubtotal);
    	oSalesTax = nf.format(cSalesTax);
    	String DetailLine5 = String.format("%-26s %30s \n", "Taxes:", oSalesTax);
    	oTotalSales = nf.format(cTotalSales);
    	String DetailLine6 = String.format("%-27s %30s \n", "Total:", oTotalSales);
    	
    	System.out.println(Header);
    	System.out.println(DetailLine);
    	System.out.println(DetailLine1);
    	System.out.println(DetailLine2);
    	System.out.println(DetailLine3);
    	System.out.println(DetailLine4);
    	System.out.println(DetailLine5);
    	System.out.println(DetailLine6);

        
        //User prompt to calculate another receipt
        boolean quit2 = false;
        
        do {
        	
            System.out.println("Do you want to calculate another receipt? Y or N");
            
            boolean choiceIsGolden = false;
            
            do {
            
               inputAgain = myScanner.next().toUpperCase().charAt(0);
               switch(inputAgain) {
               
               case 'Y':
                    inputAgain = 'Y';
                    choiceIsGolden = true;
                    quit2 = true;
                    break;
                
               case 'N':
                    inputAgain = 'N';
                    choiceIsGolden = true;
                    quit2 = true;
                    break;
                

               default:
               System.out.println("Invalid choice, please enter Y or N");
               break;
                
               }
               
            } while (!choiceIsGolden);  
      
        } while (!quit2);
        
    }    
            
    public static void GtOutput() {
    	
    	System.out.println("");
    	System.out.println("The Total number of sales is " + cSalesCounter);
    	System.out.println("");
    	
    	String Header1 = String.format("%-25s %30s\n", "Item", "Price");
    	
    	oGrandTotal = nf.format(cGrandTotal);
    	String DetailLine7 = String.format("%-27s %30s \n", "Grand Total:", oGrandTotal);
    	oGtTax = nf.format(cGtTax);
    	String DetailLine8 = String.format("%-26s %30s \n", "Total Taxes:", oGtTax);
    	oGtMarkup = nf.format(cGtMarkup);
    	String DetailLine9 = String.format("%-26s %30s \n", "Total Markup:", oGtMarkup);
    	oGtSales= nf.format(cGtSales);
    	String DetailLine10 = String.format("%-27s %30s \n", "Final Grand Total:", oGtSales);
    	
    	//Print Grand Total Outputs
    	
    	System.out.println(Header1);
    	System.out.println(DetailLine7);
    	System.out.println(DetailLine8);
    	System.out.println(DetailLine9);
    	System.out.println(DetailLine10);
    	
        System.out.println("");
        System.out.println("Program Terminated.");
    	
    }
    
}
	
