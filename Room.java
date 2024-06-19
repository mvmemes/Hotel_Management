package hotel1;
import java.util.Scanner;

public class Room {
	  
	   Scanner s= new Scanner(System.in);
	   int n=0;//no.of rooms booked
	   Customer[] cust=new Customer[10];

	   //hash function
	   int hash(int room) {    
	       int Hval=room%10;
	       return Hval;        
	   }
	   //function to check if rooms are available
	   boolean check() {
	       if(n<10) {
	           return true;
	       }else {
	           return false;
	       }
	   }
	   //Function to add entry into hash table( check-in)
	   void book() {
	       System.out.println("----------Enter customer details----------");
	       System.out.println("Name:");
	       String name=s.next();
	       System.out.println("Mobile number:");
	       String mob=s.next();
	       System.out.println("Check in date:");
	       String in_date=s.next();
	       int flag;
	     //do-while loop for if room is already booked
	       do {
	       flag=0;
	       System.out.println("Enter room no.");
	       int room=s.nextInt();
	       if(search(room)==-1) {
	           int i=hash(room);
	           if(cust[i]==null) {
	              cust[i]=new Customer(name,mob,room,in_date);}
	           else {
	             while(cust[(i)%10]!=null) {
	                i=(i+1)%10;
	             }cust[i]=new Customer(name,mob,room,in_date);
	            }
	           n=n+1;//incrementing no. of guests
	           flag=1;
	           System.out.println("ROOM BOOKED! CHECK-IN SUCCESSFULL:)");}
	       else {
	    	   System.out.println("This room is already booked! Enter another room no.");
	       }
	      }while(flag==0);
	   }
	   
	   void display() {//Function to display List of guests 
		   
		   System.out.println("------------------------------------------------------------------------");
		   System.out.format("%7s%16s%16s%16s","ROOM NO.","NAME","MOBILE NO.","CHECK-IN DATE");
		 //format used to print data in tabular form
	       System.out.println("\n------------------------------------------------------------------------");
	       for(int i=0;i<10;i++) {
	           if(cust[i]==null) {
	               System.out.format("%7s%16s%16s%10s\n","-","-","-","-");
	           }else {
	               System.out.format("%7d%16s%16s%10s\n",cust[i].room,cust[i].name,cust[i].mob,cust[i].in_date);}
	       }
	   }
	   
	 //search function
	   int search(int key) {
	       int i=hash(key);//calling hash fn
	       int temp=hash(key);
	       while(cust[i]!=null) {  //repeating loop until empty cell is found
	    	  if(cust[i].room==key) {
	    		  return i;
	    	  }else
	    	  { i=i+1;
	    	    i%=10;}//for retrieving 
	    	  if(i==temp) {
	    		 break; 
	    	  }
	      }return -1;
	   }
	   
//Function to remove entry from hash table	   
	   void check_out(){ 
		   int flag=0;
		   do {
		      System.out.println("ENTER YOUR ROOM NO. PLEASE: ");
	          int rm=s.nextInt();
	          int i=search(rm);
	          if(i==-1) {
	    	      System.out.println("# Room is empty! Please enter correct room no.#"); //if room is not booked repeat while loop
	          }else {
	             cust[i]=null;
	             flag=1;
	             n=n-1;
	             System.out.println("CHECK OUT SUCCESSSFUL!\nDO VISIT AGAIN :)");}
		   }while(flag==0);
	     }
	   
//display hotel details
	   void details(){
	       System.out.println("----------FACILITIES AVAILABLE:----------");
	       System.out.println("1.Car parking\n2.24 Hour security\n3.Total rooms=10\n4.24 Hour Room service\n5.laundry service\n6.Swimming pool\n7.Poolside dinner");
	       System.out.println();
	       System.out.println("=>ROOM DETAILS:");
	       System.out.println("1.AC and Non-AC rooms Available\n2.Delux room avilable with spa, jacuzzi and living room facilities.");
	       System.out.println("Room Type    Price");
	       System.out.println("AC           5000");
	       System.out.println("Non-AC       3000");
	       System.out.println("Delux        10,000");
	       System.out.println();
	       System.out.println("Check-in time:  14:00\nCheck-out time: 12:00");

	   }
}
