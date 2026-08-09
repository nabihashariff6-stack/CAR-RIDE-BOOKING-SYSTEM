package com.mycompany.ridetest;
import java.util.Scanner;
public class Ridetest {
    
    public static void main(String[] args){
        
           while(true){
        String[] points = {"Home" , "Mall" , "University", "School" , "College" , "Supermarket",
                           "Office","Hospital"};
        String[] CarACdrivers = {"Abdul majeed" , "Qasim Khan" , "Maaz Ahmed"};
        String[] ACcars = {"Alto-234" , "Corolla GLI - 497" , " Honda City - 789"};
        String[] CarnonACdrivers = {"Abdullah ali" , "sohaib ahmed" , "Shahzaib"};
        String[] nonACcars= {"Mehran - 334 " , "Cultus - 980" , "Alto- 746 (2006 model)"};
        String[] Bikedr = {"Daniyal ali" , "momin saqib" , "bilal chaudary"};
        String[] Bikes = {"125 (AGH-980)" , "125 (ABC-123)" ,"125 (QWE-657)"};
        String[] Rikshawdrivers = {"Minhas khan","shehroze ashraf"};
        String[] Riks = {"Sazagar 1" , "Sazgar 2"};
        
        
        double[] x = {2.1, 3.4 , 1.5 , 4.0 , 3.0 ,5.6 ,7.3,4.7};
        double[] y = {3.2 , 2.0 , 1.5 , 4.3 , 5.1 ,8.0 ,4.4 ,7.8};
        
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("What are you looking for ?");
        System.out.println("1. Book ride");
        System.out.println("2. Card discounts");
        System.out.println("3. About Us");
        
        int option = in.nextInt();
        
     if (option == 1){
           
       System.out.println("Locatons Available");
        
        for(int i = 0; i<points.length; i++){
            System.out.println(i+1 + "." + points[i]);
            
        }
        in.nextLine();
       
        
        System.out.println("Enter Your Name");
        String name = in.nextLine();
        
        System.out.println("Pickup location from 1 - 8");
        int a = in.nextInt() - 1;
        
        System.out.println("Drop off location from 1 - 8 ");
        int b = in.nextInt() - 1;
        
        System.out.println("Choose your ride");
        System.out.println(" 1. Car (AC)");
        System.out.println(" 2. Car     NON(AC)");
        System.out.println(" 3. Bike");
        System.out.println(" 4. Rikshaw)");
        
        CarAC ca1 = new CarAC(points[a] , points[b] , name);
        CarNonAC cn1 = new CarNonAC(points[a],points[b],name);
        Bike b1 = new Bike(points[a],points[b],name);
        Rikshaw r1 = new Rikshaw(points[a],points[b],name);
        
        
        
        int choice =  in.nextInt();
        
        
        
        double finaldist;
        
        if (choice == 1){
            
            System.out.println("Choose available drivers");
            
                for(int j = 0; j<CarACdrivers.length; j++){
                    System.out.println(j+1 + "." + "Driver :" + CarACdrivers[j] + "Car :" + ACcars[j]);
                }
                
            System.out.println("Enter driver choice from 1-3");
            int choice2  = in.nextInt() -1;
            finaldist = ca1.CalculateDistance(a, b, x, y);
            
               System.out.println("Choose your payment method "
                    + "1. Cash"
                    + "2. Card");
            int paymeth  = in.nextInt();
          if (paymeth == 2){
                in.nextLine();
                System.out.println("Enter your Full Name");
                String Name = in.nextLine();
                System.out.println("Enter your bank name");
                String bankname = in.nextLine();
                System.out.println("Enter your card number");
                int Cardnum = in.nextInt();
                System.out.println("Enter Your CVV (Security Code");
                int CVV = in.nextInt();
                
                    System.out.println(" Your card payment has been processed and Your ride has been booked do you wish to proceed further ?"
                            + "1. Yes"
                            + "2. No");
                    int choice3 = in.nextInt();
              if (choice3 ==1){
                if (bankname.equalsIgnoreCase("Bank Al falah")){
                 System.out.println("Your driver's name is" + " " + CarACdrivers[choice2] + " " + "and car model is " + " " + ACcars[choice2] + " " + " total fare without discount is " + " " + ca1.CalculateFare(finaldist) + "and final fare with discount of 20% is " + " " + (ca1.CalculateFare(finaldist)-ca1.CalculateFare(finaldist)*0.20));
                }
                else if(bankname.equalsIgnoreCase("Bank-al-habib")){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + CarnonACdrivers[choice2] + " " + "and car model is " + " " + ACcars[choice2] + " " + " total fare without discount is =" + " " + ca1.CalculateFare(finaldist) + " " + "and final fare with discount of 35% is" + " " + (ca1.CalculateFare(finaldist)-ca1.CalculateFare(finaldist)*0.35) );
                }
                else if(bankname.equalsIgnoreCase("Faisal Bank")){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + CarnonACdrivers[choice2] + " " + "and car model is " + " " + ACcars[choice2] + " " + " total fare without discount is" + " " + ca1.CalculateFare(finaldist) + " " + "and final fare with discount of 50% is" + " " + (ca1.CalculateFare(finaldist)-ca1.CalculateFare(finaldist)*0.50));
                }
                else{
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + CarACdrivers[choice2] + " " + "and car model is " + " " + ACcars[choice2] + " " + " total fare =" + " " + ca1.CalculateFare(finaldist));
                }
            }
             else{
              System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");
               }
          }
         else if(paymeth==1){
                System.out.println("Your ride has been booked do you wish to proceed further ?"
                        + "1. Yes"
                        + "2. No");
                int option4 = in.nextInt();
                if(option4 == 1){
                 System.out.println("Your driver's name is" + " " + CarACdrivers[choice2] + " " + "and car model is " + " " + ACcars[choice2] + " " + " total fare =" + " " + ca1.CalculateFare(finaldist));
                }
                else{
                    System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");
                }
            
         }
          
     
        }       
        
    
                
       else if(choice == 2){
                for(int i = 0; i<CarnonACdrivers.length; i++){
                    System.out.println(i+1 + "." + " " + "Driver :" + " " + CarnonACdrivers[i] + "Car :" + " " + nonACcars[i]);
                }
            
            System.out.println("Enter driver choice from 1-3");
            int choice2  = in.nextInt() - 1;
            finaldist = cn1.CalculateDistance(a, b, x, y);
            
             System.out.println("Choose your payment method "
                    + "1. Cash"
                    + "2. Card");
            int paymeth  = in.nextInt();
            if (paymeth == 2){
                
                in.nextLine();
                System.out.println("Enter your Full Name");
                String Name = in.nextLine();
                System.out.println("Enter your bank name");
                String bankname = in.nextLine();
                System.out.println("Enter your card number");
                int Cardnum = in.nextInt();
                System.out.println("Enter Your CVV (Security Code");
                int CVV = in.nextInt();
                System.out.println(" Your card payment has been processed and Your ride has been booked do you wish to proceed further ?"
                            + "1. Yes"
                            + "2. No");
                    int choice3 = in.nextInt();
              if (choice3 ==1){
                    
                if (bankname .equalsIgnoreCase("Bank Al falah")){
                  System.out.println("Your driver's name is" + " " + CarnonACdrivers[choice2] + " " + "and car model is " + " " + nonACcars[choice2] + " " + " total fare without discount is " + " " + cn1.CalculateFare(finaldist) + "and final fare with discount of 20% is " + " " + (cn1.CalculateFare(finaldist)-cn1.CalculateFare(finaldist)*0.20));
                }
                else if(bankname.equalsIgnoreCase("Bank-al-habib")){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + CarnonACdrivers[choice2] + " " + "and car model is " + " " + nonACcars[choice2] + " " + " total fare without discount is =" + " " + cn1.CalculateFare(finaldist) + " " + "and final fare with discount of 35% is" + " " + (cn1.CalculateFare(finaldist)-cn1.CalculateFare(finaldist)*0.35 ));
                }
                else if(bankname.equalsIgnoreCase("Faisal Bank")){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + CarnonACdrivers[choice2] + " " + "and car model is " + " " + nonACcars[choice2] + " " + " total fare without discount is" + " " + cn1.CalculateFare(finaldist) + " " + "and final fare with discount of 50% is" + " " + (cn1.CalculateFare(finaldist)-cn1.CalculateFare(finaldist)*0.50));
                }
                else{
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + CarnonACdrivers[choice2] + " " + "and car model is " + " " + nonACcars[choice2] + " " + " total fare =" + " " + cn1.CalculateFare(finaldist));
                }
              }
              else if(choice3 == 2){
              System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");
               } 
              else{
                  System.out.println("invalid choice");
              }
                    
                
            }
            else if(paymeth==1){
                System.out.println("Your ride has been booked do you wish to proceed further ?"
                        + "1. Yes"
                        + "2. No");
                int option4 = in.nextInt();
                if(option4 == 1){
                 System.out.println("Your driver's name is" + " " + CarnonACdrivers[choice2] + " " + "and car model is " + " " + nonACcars[choice2] + " " + " total fare =" + " " + cn1.CalculateFare(finaldist));
                }
                else if(option4 == 2){
                    System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");
                }
                else{
                    System.out.println("Invalid choice");
                }
            }
        
          
     
        }       
             
        
         
     else if(choice == 3){
           
                for(int i = 0; i<Bikedr.length; i++){
                    System.out.println(i+1 + "." + "Driver :" + " " + Bikedr[i] + "Bike :" + " " + Bikes[i]);
                }
            
            System.out.println("Enter driver choice from 1-3");
            int choice2  = in.nextInt()-1;
            finaldist = b1.CalculateDistance(a, b, x, y);
            
            System.out.println("Choose your payment method "
                    + "1. Cash"
                    + "2. Card");
            int paymeth  = in.nextInt();
            if (paymeth == 2){
                in.nextLine();
                System.out.println("Enter your Full Name");
                String Name = in.nextLine();
                System.out.println("Enter your bank name");
                String bankname = in.nextLine();
                System.out.println("Enter your card number");
                int Cardnum = in.nextInt();
                System.out.println("Enter Your CVV (Security Code");
                int CVV = in.nextInt();
                System.out.println(" Your card payment has been processed and Your ride has been booked do you wish to proceed further ?"
                            + "1. Yes"
                            + "2. No");
                    int choice3 = in.nextInt();
              if (choice3 ==1){
                if (bankname.equalsIgnoreCase("Bank Al falah")){
                    System.out.println(" Your card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Bikedr[choice2] + " " + "and bike model is " + " " + Bikes[choice2] + " " + " total fare without discount is " + " " + b1.CalculateFare(finaldist) + "and final fare with discount of 20% is " + " " +  (b1.CalculateFare(finaldist) - b1.CalculateFare(finaldist)*0.20));
                }
                else if(bankname.equalsIgnoreCase("Bank-Al-Habib")){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Bikedr[choice2] + " " + "and bike model is " + " " + Bikes[choice2] + " " + " total fare without discount is " + " " + b1.CalculateFare(finaldist) + "and final fare with discount of 35% is " + " " + (b1.CalculateFare(finaldist)- b1.CalculateFare(finaldist)*0.35));
                }
                else if(bankname.equalsIgnoreCase("Faisal Bank")){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Bikedr[choice2] + " " + "and bike model is " + " " + Bikes[choice2] + " " + " total fare without discount is " + " " + b1.CalculateFare(finaldist) + "and final fare  with discount of 50% is  " + " " + (b1.CalculateFare(finaldist) - b1.CalculateFare(finaldist)*0.50));
                }
                else{
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Bikedr[choice2] + " " + "and bike model is " + " " + Bikes[choice2] + " " + " total fare =" + " " + b1.CalculateFare(finaldist));
                }
             }
            else if(choice3 == 2){
                System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");  
            }
            else{
                  System.out.println("Invalid Choice");
              }
            }
              
            else if(paymeth == 1){
                System.out.println("Your ride has been booked do you wish to proceed further ?"
                        + "1. Yes"
                        + "2. No");
                int option4 = in.nextInt();
                if(option4 == 1){
                 System.out.println("Your driver's name is" + " " + Bikedr[choice2] + " " + "and bike model is " + " " + Bikes[choice2] + " " + " total fare =" + " " + b1.CalculateFare(finaldist));
                }
                else if(option4 == 2){
                    System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");
                }
                else{
                    System.out.println("Invalid choice");
                }
            }
            }
           
                
            
            
                
            

        
        else if(choice == 4){
           
                for(int j = 0; j<Rikshawdrivers.length; j++){
                    System.out.println(j+1 + "." + " " + "Driver :" + " " + Rikshawdrivers[j] + " " + "Rikshaw :" + " " + Riks[j]);
                }
            
            System.out.println("Enter driver choice from 1-2");
            int choice2  = in.nextInt()-1;
            finaldist = r1.CalculateDistance(a, b, x, y);
            System.out.println("Choose your payment method "
                    + "1. Cash"
                    + "2. Card");
            int paymeth  = in.nextInt();
            if (paymeth == 2){
                in.nextLine();
                System.out.println("Enter your Full Name");
                String Name = in.nextLine();
                System.out.println("Enter your bank name");
                String bankname = in.nextLine();
                System.out.println("Enter your card number");
                int Cardnum = in.nextInt();
                System.out.println("Enter Your CVV (Security Code");
                int CVV = in.nextInt();
                System.out.println(" Your card payment has been processed and Your ride has been booked do you wish to proceed further ?"
                            + "1. Yes"
                            + "2. No");
                    int choice3 = in.nextInt();
               if (choice3 ==1){
                 if (bankname == "Bank Al falah"){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Rikshawdrivers[choice2] + " " + "and bike model is " + " " + Riks[choice2] + " " + " total fare without discount is" + " " + r1.CalculateFare(finaldist) + "final fare with discount of 20% is" + " " + (r1.CalculateFare(finaldist)-r1.CalculateFare(finaldist)*0.20));
                }
                 else if(bankname == "Bank-al-habib"){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Rikshawdrivers[choice2] + " " + "and bike model is " + " " + Riks[choice2] + " " + " total fare without discount is" + " " + " and final fare with discount of 35% is" + " " + (r1.CalculateFare(finaldist)-r1.CalculateFare(finaldist)*0.35));
                }
                else if(bankname == "Faisal Bank"){
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Rikshawdrivers[choice2] + " " + "and bike model is " + " " + Riks[choice2] + " " + " total fare without discount is" + " " + r1.CalculateFare(finaldist) + " " + "and final fare with discount of 50% is" + " " + (r1.CalculateFare(finaldist)- r1.CalculateFare(finaldist)*0.50) );
                }
                else{
                    System.out.println(" Yoyr card payment has been processed and Your ride has been booked");
                 System.out.println("Your driver's name is" + " " + Rikshawdrivers[choice2] + " " + "and bike model is " + " " + Riks[choice2] + " " + " total fare =" + " " + r1.CalculateFare(finaldist));
                }
               }
               else if(choice3 == 2){
                System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");
               }
            
               else{
                   System.out.println("Invalid choice");
               }
            
                   
            }
            else if(paymeth==1){
               System.out.println("Your ride has been booked do you wish to proceed further ?"
                        + "1. Yes"
                        + "2. No");
                int option4 = in.nextInt();
                if(option4 == 1){
                 System.out.println("Your driver's name is" + " " + Rikshawdrivers[choice2] + " " + "and rikshaw model is " + " " + Riks[choice2] + " " + " total fare =" + " " + r1.CalculateFare(finaldist));
                }
                else if(option4 == 2){
                    System.out.println("Your ride has been cancelled thankyou for using WeDRIVE");
                }
                else{
                    System.out.println("Invalid choice");
                }
                }
            }
          
        }
          
            
                 
        
        
          
    
        
    else if (option == 2){
            System.out.println("Card discounts as follows"
                    + "1. Bank Al falah - 20% off "
                    + "2. Bank-al-habib - 35% off"+
                      " 3.Faisal Bank - 50% off");
        }
        
    else if (option == 3){
            System.out.println("WeDRIVE is a premium car riding app established in 2026 by co-founders Awaisha Hafeez, Nabiha Sharieff and Taaha Malik(previous coo of Uber services(london)).The purpose of the app was to give a mordern comfortable experience for the customers to book rides at reasonable costs and travel where they want to in the city  ");
        }
        
        
            
    }
}

}   




