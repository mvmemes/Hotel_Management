package hotel1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
	     
	     Room obj=new Room();       //Room class object
	     
	     int ch=0,tr=0,ch1=0;  //initializing variables
	     
	     System.out.println("*******************************************************************");
	     System.out.println("-----------WELCOME TO SUNSHINE HOTEL- the lap of nature-----------");
	     System.out.println("*******************************************************************");
	     System.out.println();
	     System.out.println("HOW WE CAN HELP YOU ?");
	     do {
	    	 //Menu
	     System.out.println("\nPLEASE ENTER--\n1. CHECK HOTEL DETAILS\n2. BOOK A ROOM\n3. CHECK OUT\n4. CHECK GUEST LIST");
	     ch=sc.nextInt();
	     switch(ch){
	     
	     case 1:obj.details();  //calling hotel details function
	     break;
	    	 
	     case 2:
	     if(obj.check()==true) {//calling room availability fn
	    	 System.out.println("Rooms are available, Please enter customer details to check in!");
	    	
	    	 obj.book();//calling check-in fn
	     }else {
	    	 System.out.println("Sorry to inform you that rooms are full :(");
	     }break;
	    	 
	     case 3:
	    	 obj.check_out(); //calling check-out fn
	    	 break;
	    	 
	   	 case 4:System.out.println("----THESE DETAILS CAN ONLY BE VIEWED BY OWNER! YOU NEED OWNER LOGIN PASSWORD TO LOGIN----\nPLEASE ENTER 1 TO LOGIN AND 0 TO EXIT");
	   		 int log=sc.nextInt();
	   		 if(log==1) {
	   			 do {
	   			 System.out.println("Please enter login password: ");
	   			 String pw=sc.next();
	   			 
	   			 if(pw.equals("1234")) {
	   				 System.out.println("\n----WELCOME SIR! HERE ARE YOUR CUSTOMERS CHECK-IN DETAILS----\n");
	   				 obj.display();
	   				 break;
	   			 }else {
	   				 System.out.println("Your password is wrong! Do u want to try again (1 to login and 0 to exit):");
	   				 tr=sc.nextInt();
	   			   }
	   			 }while(tr!=0);//
	   			 
	   		 }else {
	   			 break;
	   		 }
	   		 
	   	 case 0:break;
	   		 
	     default:System.out.println("INVALID CHOICE!");
	     
	     }
	     System.out.println("\nIF YOU WANT TO STAY ON PAGE ENTER ANY NUMBER AND 0 TO EXIT CODE!");
	     ch1=sc.nextInt();
	   }while(ch1!=0);
	     System.out.println("************* THANK YOU, VISIT AGAIN :)*****************");
  sc.close();
	}
}







